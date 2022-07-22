package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;

public class ParkingPresenter implements ParkingContract.Presenter {

    private final ParkingContract.Model model;
    private final ParkingContract.View view;

    public ParkingPresenter(ParkingContract.Model model, ParkingContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onShowButtonPressed(ListenerDialogFragment listenerDialogFragment) {
        view.showDialogFragment(listenerDialogFragment);
    }

    @Override
    public void listenParkingAvailable(String parkingAvailable) {
        model.setParkingAvailable(Integer.parseInt(parkingAvailable));
        view.showNumberOfParking(String.valueOf(model.getParkingAvailable()));
    }
}
