package com.mobile.tandil.javabaseproject.mvp.contract;

public interface ParkingContract {

    interface Model {
        void setParkingAvailable(int parkingAvailable);
        int getParkingAvailable();
    }

    interface View {
        void showNumberOfParking(String numberOfParking);
    }

    interface Presenter {
        void onShowButtonPressed();
    }
}
