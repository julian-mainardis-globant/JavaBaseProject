package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.Model {

    private int parkingAvailable = -1;

    @Override
    public void setParkingAvailable(int parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    @Override
    public int getParkingAvailable() {
        return parkingAvailable;
    }
}
