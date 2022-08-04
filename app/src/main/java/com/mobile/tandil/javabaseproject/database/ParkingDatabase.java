package com.mobile.tandil.javabaseproject.database;

import com.mobile.tandil.javabaseproject.entity.Reservation;
import com.mobile.tandil.javabaseproject.util.Constants;
import java.util.ArrayList;
import java.util.HashMap;

public class ParkingDatabase {

    private final HashMap<Integer, ArrayList<Reservation>> hashMap = new HashMap<>();
    private Integer parkingLots = Constants.INVALID_PARKING_LOTS;
    private static ParkingDatabase instance = null;

    public static ParkingDatabase getInstance() {
        if (instance == null) {
            instance = new ParkingDatabase();
        }
        return instance;
    }

    public void addReservation(Reservation reservation) {
        Integer parkingLot = reservation.getParkingNumber();
        if (hashMap.get(parkingLot) == null) {
            ArrayList<Reservation> reservations = new ArrayList<>();
            reservations.add(reservation);
            hashMap.put(parkingLot, reservations);
        } else {
            hashMap.get(parkingLot).add(reservation);
        }
    }

    public Integer getParkingLots() {
        return parkingLots;
    }

    public ArrayList<Reservation> getReservations(int parkingLot) {
        return hashMap.get(parkingLot);
    }

    public void setParkingLots(int parkingLots) {
        this.parkingLots = parkingLots;
    }
}
