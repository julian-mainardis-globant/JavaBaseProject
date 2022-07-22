package com.mobile.tandil.javabaseproject.mvp.contract;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;

public interface ParkingContract {

    interface Model {
        void setParkingAvailable(int parkingAvailable);
        int getParkingAvailable();
    }

    interface View {
        void showDialogFragment(ListenerDialogFragment listenerDialogFragment);
        void showNumberOfParking(String numberOfParking);
    }

    interface Presenter {
        void onShowButtonPressed(ListenerDialogFragment listenerDialogFragment);
        void listenParkingAvailable(String parkingAvailable);
    }
}
