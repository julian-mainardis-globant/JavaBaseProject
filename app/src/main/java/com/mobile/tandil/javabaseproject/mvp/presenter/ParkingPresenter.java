package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.util.Constants;

public class ParkingPresenter implements ParkingContract.Presenter {
    private final ParkingContract.Model model;
    private final ParkingContract.View view;

    public ParkingPresenter(ParkingContract.Model model, ParkingContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onShowSpacesButtonPressed(ListenerDialogFragment listenerDialogFragment) {
        view.showDialogFragment(listenerDialogFragment);
    }

    @Override
    public void listenParkingAvailable(String parkingAvailable) {
        if (parkingAvailable.isEmpty()) {
            view.showToastEmptyAvailableSpaces();
        } else {
            model.setParkingAvailable(Integer.parseInt(parkingAvailable));
            view.showNumberOfParking(String.valueOf(model.getParkingAvailable()));
        }
    }

    @Override
    public void onShowReservationButtonPressed() {
        if (model.getParkingAvailable() > Constants.INVALID_PARKING_LOTS) {
            view.showReservationActivity();
        } else {
            view.showToastEmptyAvailableSpaces();
        }
    }
}
