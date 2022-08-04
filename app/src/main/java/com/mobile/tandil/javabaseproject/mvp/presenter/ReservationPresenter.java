package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.mvp.contract.ReservationContract;
import com.mobile.tandil.javabaseproject.util.DateUtils;
import com.mobile.tandil.javabaseproject.util.ValidationEnum;
import java.util.Calendar;

public class ReservationPresenter implements ReservationContract.Presenter {
    private final ReservationContract.View view;
    private final ReservationContract.Model model;

    public ReservationPresenter(ReservationContract.View view, ReservationContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void showPickers(ListenerPickers listenerPickers, Boolean startOrEnd) {
        view.showDateAndTime(listenerPickers, startOrEnd);
    }

    @Override
    public void listenStartingDate(Calendar startingDate) {
        view.showStartingDate(DateUtils.calendarToString(startingDate));
    }

    @Override
    public void listenEndingDate(Calendar endingDate) {
        view.showEndingDate(DateUtils.calendarToString(endingDate));
    }

    @Override
    public void confirmReservation(String startingDate, String endingDate, String key, String parkingNumber) {
        Calendar startDate = DateUtils.stringToCalendar(startingDate);
        Calendar endDate = DateUtils.stringToCalendar(endingDate);

        if (!key.isEmpty() && !parkingNumber.isEmpty() && !startingDate.isEmpty() && !endingDate.isEmpty()) {
            Integer parkNumber = Integer.parseInt(parkingNumber);
            ValidationEnum rta = model.validations(startDate, endDate, parkNumber);
            switch (rta) {
                case START_BEFORE_NOW:
                    view.toastStartBeforeNow();
                    break;
                case END_BEFORE_START:
                    view.toastEndBeforeStart();
                    break;
                case PARK_BIGGER_THAN_TOTAL:
                    view.toastParkBiggerThanTotal();
                    break;
                case DATE_ALREADY_RESERVED:
                    view.toastDateAlreadyReserved();
                    break;
                case ALL_OK:
                    model.addReservation(model.createReservation(startingDate, endingDate, key, parkingNumber));
                    view.toastAllOk();
                    break;
            }
        } else {
            view.toastCompleteFields();
        }
    }
}
