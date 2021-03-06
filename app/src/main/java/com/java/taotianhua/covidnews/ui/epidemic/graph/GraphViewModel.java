package com.java.taotianhua.covidnews.ui.epidemic.graph;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.java.taotianhua.covidnews.model.EpidemicData;
import com.java.taotianhua.covidnews.repository.Repository;

public class GraphViewModel extends ViewModel {

    /**
     * return a certain region's data
     */

    private MutableLiveData<EpidemicData> graphData;

    public GraphViewModel() {
    }

    public LiveData<EpidemicData> getEpidemicData(String country, String province, String county) {
        if (graphData == null) {
            graphData = new MutableLiveData<>();
        }
        if (county.length() == 0) {
            if (province.length() == 0) return getEpidemicData(country);
            else return getEpidemicData(country, province);
        }
        if (province.length() == 0) {
            Log.d("Debug", "province为空但county不为空是不能出现的");
        }
        String region = country + "|" + province + "|" + county;
        Log.d("Debug", region);
        loadRegionDataAsync(region);
        return graphData;
    }

    public LiveData<EpidemicData> getEpidemicData(String country, String province) {
        if (graphData == null) {
            graphData = new MutableLiveData<>();
        }
        if (province.length() == 0) { //为""
            return getEpidemicData(country);
        }
        String region = country + "|" + province;
        Log.d("Debug", region);
        loadRegionDataAsync(region);
        return graphData;
    }

    public LiveData<EpidemicData> getEpidemicData(String country) {
        if (graphData == null) {
            graphData = new MutableLiveData<>();
        }
        String region = country;
        loadRegionDataAsync(region);
        Log.d("Debug", region);
        return graphData;
    }

    private void loadRegionDataAsync(String region) {
        //TODO: return a EpidemicData be region key.
        new Thread(() -> {
            EpidemicData epidemicData = Repository.getInstance().getEpidemicData(region);
            graphData.postValue(epidemicData);
        }).start();
    }
}