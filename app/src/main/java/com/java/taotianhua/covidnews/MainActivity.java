package com.java.taotianhua.covidnews;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.java.taotianhua.covidnews.repository.HistoryManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_epidemic,
                R.id.navigation_scholars,
                R.id.navigation_user
        )
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void onClearHistory(View view) {
        Log.i("","ClearHistory clicked");
        HistoryManager.getInstance().clearHistory();
        // TODO: give a message
    }

    public void onAbout(View view) {
        Log.i("","About clicked");

    }

    public void onClearCache(View view) {
        Log.i("","ClearCache clicked");
        // TODO: clear cache
    }


}