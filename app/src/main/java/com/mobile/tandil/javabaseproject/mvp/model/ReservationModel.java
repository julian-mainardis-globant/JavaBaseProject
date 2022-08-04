package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.database.ParkingDatabase;
import com.mobile.tandil.javabaseproject.entity.Reservation;
import com.mobile.tandil.javabaseproject.util.ValidationEnum;
import com.mobile.tandil.javabaseproject.mvp.contract.ReservationContract;
import java.util.ArrayList;
import java.util.Calendar;

public class ReservationModel implements ReservationContract.Model {

    ParkingDatabase database;

    public ReservationModel(ParkingDatabase database) {
        this.database = database;
    }

    @Override
    public Reservation createReservation(String startingDate, String endingDate, String key, String parkingNumber) {
        return new Reservation(startingDate, endingDate, key, parkingNumber);
    }

    public Boolean parkingIsReserved(Calendar startingDate, Calendar endingDate, Integer parkingNumber) {
        ArrayList<Reservation> reservations = database.getReservations(parkingNumber);
        boolean flag = false;

        if (reservations != null) {
            for (int i = 0; i < reservations.size(); i++) {
                if (startingDate.before(reservations.get(i).getEndingDate()) || endingDate.after(reservations.get(i).getStartingDate())) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public ValidationEnum validations(Calendar startingDate, Calendar endingDate, Integer parkingNumber) {
        if (startingDate.before(Calendar.getInstance())) {
            return ValidationEnum.START_BEFORE_NOW;
        } else if (endingDate.before(startingDate)) {
            return ValidationEnum.END_BEFORE_START;
        } else if (parkingNumber > database.getParkingLots()) {
            return ValidationEnum.PARK_BIGGER_THAN_TOTAL;
        } else if (parkingIsReserved(startingDate, endingDate, parkingNumber)) {
            return ValidationEnum.DATE_ALREADY_RESERVED;
        } else {
            return ValidationEnum.ALL_OK;
        }
    }

    @Override
    public void addReservation(Reservation reservation) {
        database.addReservation(reservation);
    }
}
