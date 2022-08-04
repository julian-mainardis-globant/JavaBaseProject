package com.mobile.tandil.javabaseproject.entity;

import com.mobile.tandil.javabaseproject.util.DateUtils;
import java.util.Calendar;

public class Reservation {
    private final Calendar startingDate;
    private final Calendar endingDate;
    private final String key;
    private final Integer parkingNumber;

    public Reservation(String startingDate, String endingDate, String key, String parkingNumber) {
        this.startingDate = DateUtils.stringToCalendar(startingDate);
        this.endingDate = DateUtils.stringToCalendar(endingDate);
        this.key = key;
        this.parkingNumber = Integer.parseInt(parkingNumber);
    }

    public Calendar getStartingDate() {
        return startingDate;
    }

    public Calendar getEndingDate() {
        return endingDate;
    }

    public String getKey() {
        return key;
    }

    public Integer getParkingNumber(){
        return parkingNumber;
    }
}
