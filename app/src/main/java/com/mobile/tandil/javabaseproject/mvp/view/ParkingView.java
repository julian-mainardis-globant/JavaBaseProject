package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;

import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.View {

    private final ActivityMainBinding binding;

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);

        this.binding = binding;
    }

    @Override
    public void showNumberOfParking(String numberOfParking) {
        binding.textViewMainActivity.setText(numberOfParking);
    }
}
