package com.mobile.tandil.javabaseproject.mvp.contract;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;

public interface ParkingContract {

    interface Presenter {
        void onShowSpacesButtonPressed(ListenerDialogFragment listenerDialogFragment);
        void listenParkingAvailable(String parkingAvailable);
        void onShowReservationButtonPressed();
    }

    interface Model {
        void setParkingAvailable(int parkingAvailable);
        int getParkingAvailable();
    }

    interface View {
        void showDialogFragment(ListenerDialogFragment listenerDialogFragment);
        void showNumberOfParking(String numberOfParking);
        void showReservationActivity();
        void showToastEmptyAvailableSpaces();
    }
}
