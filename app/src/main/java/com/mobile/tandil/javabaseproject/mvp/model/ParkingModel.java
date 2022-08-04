package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.database.ParkingDatabase;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.util.Constants;

public class ParkingModel implements ParkingContract.Model {
    private int parkingAvailable = Constants.INVALID_PARKING_LOTS;
    private ParkingDatabase database;

    public ParkingModel(ParkingDatabase database) {
        this.database = database;
    }

    @Override
    public void setParkingAvailable(int parkingAvailable) {
        database.setParkingLots(parkingAvailable);
    }

    @Override
    public int getParkingAvailable() {
        return database.getParkingLots();
    }
}
