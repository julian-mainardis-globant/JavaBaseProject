package com.mobile.tandil.javabaseproject.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Calendar stringToCalendar(String stringDate) {
        if(!stringDate.isEmpty()){
            SimpleDateFormat format = new SimpleDateFormat(Constants.CALENDAR_FORMAT);
            Date dateFormatted;

            try {
                dateFormatted = format.parse(stringDate);
                Calendar dateCalendar = Calendar.getInstance();
                dateCalendar.setTime(dateFormatted);
                return dateCalendar;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static String calendarToString(Calendar date) {
        Format formatter = new SimpleDateFormat(Constants.CALENDAR_FORMAT);
        return formatter.format(date.getTime());
    }
}
