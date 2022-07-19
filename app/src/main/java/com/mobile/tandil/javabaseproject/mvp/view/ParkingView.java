package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;

import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.View {

    public ParkingView(Activity activity) {
        super(activity);
    }
}

