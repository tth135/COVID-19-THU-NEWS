package com.java.taotianhua.covidnews.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.java.taotianhua.covidnews.R;


public class CatalogDialogFragment extends DialogFragment {


    public CatalogDialogFragment(HomeViewModel homeViewModel) {
    this.viewModel = homeViewModel;
    }

    private ToggleButton newsButton;
    private ToggleButton paperButton;
    private ToggleButton eventButton;
    private ToggleButton pointsButton;

    HomeViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // empty slot
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_catalog_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        newsButton = view.findViewById(R.id.newsButton);
        paperButton =view.findViewById(R.id.paperButton);
        eventButton = view.findViewById(R.id.eventButton);
        pointsButton = view.findViewById(R.id.pointsButton);

        newsButton.setChecked(viewModel.isSelected(0));
        paperButton.setChecked(viewModel.isSelected(1));
        eventButton.setChecked(viewModel.isSelected(2));
        pointsButton.setChecked(viewModel.isSelected(3));

        newsButton.setOnClickListener(view1 -> viewModel.setSelected(0, newsButton.isChecked()));
        paperButton.setOnClickListener(view12 -> viewModel.setSelected(1, paperButton.isChecked()));
        eventButton.setOnClickListener(view13 -> viewModel.setSelected(2, eventButton.isChecked()));
        pointsButton.setOnClickListener(view14 -> viewModel.setSelected(3, pointsButton.isChecked()));
    }
}