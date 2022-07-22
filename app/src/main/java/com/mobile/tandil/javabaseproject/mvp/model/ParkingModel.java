package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.Model {

    private static final int DEFAULT_VALUE = -1;
    private int parkingAvailable = DEFAULT_VALUE;

    @Override
    public void setParkingAvailable(int parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    @Override
    public int getParkingAvailable() {
        return parkingAvailable;
    }
}
