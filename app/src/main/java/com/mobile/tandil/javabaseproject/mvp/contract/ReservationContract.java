package com.mobile.tandil.javabaseproject.mvp.contract;

import com.mobile.tandil.javabaseproject.entity.Reservation;
import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.util.ValidationEnum;
import java.util.Calendar;

public interface ReservationContract {

    interface Presenter {
        void showPickers(ListenerPickers listenerPickers, Boolean startOrEnd);
        void confirmReservation(String startingDate, String endingDate, String key, String parkingNumber);
        void listenStartingDate(Calendar startingDate);
        void listenEndingDate(Calendar endingDate);
    }

    interface Model {
        Reservation createReservation(String startingDate, String endingDate, String key, String parkingNumber);
        void addReservation(Reservation reservation);
        Boolean parkingIsReserved(Calendar startingDate, Calendar endingDate, Integer parkingNumber);
        ValidationEnum validations(Calendar startingDate, Calendar endingDate, Integer parkNumber);
    }

    interface View {
        void showDateAndTime(ListenerPickers listenerPickers, Boolean startOrEnd);
        void showStartingDate(String date);
        void showEndingDate(String date);
        void toastStartBeforeNow();
        void toastEndBeforeStart();
        void toastParkBiggerThanTotal();
        void toastDateAlreadyReserved();
        void toastCompleteFields();
        void toastAllOk();
    }
}
