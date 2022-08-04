package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.database.ParkingDatabase;
import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.mvp.contract.ReservationContract;
import com.mobile.tandil.javabaseproject.mvp.model.ReservationModel;
import com.mobile.tandil.javabaseproject.util.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Calendar;

@RunWith(MockitoJUnitRunner.class)
public class ReservationPresenterTest {
    private static final String EMPTY_STRING = "";
    private static final String VALID_STRING_STARTING_DATE = "10-09-2022 09:33";
    private static final String INVALID_STRING_STARTING_DATE = "10-04-2022 09:33";
    private static final String VALID_STRING_ENDING_DATE = "12-09-2022 10:22";
    private static final String INVALID_STRING_ENDING_DATE = "12-04-2022 10:22";
    private static final String STRING_KEY_CODE = "222";
    private static final String VALID_STRING_PARKING_NUMBER = "22";
    private static final String INVALID_STRING_PARKING_NUMBER = "1230";
    private static final Integer VALID_INT_PARKING_AVAILABLE = 123;
    private ReservationContract.Presenter presenter;
    private ParkingDatabase database;

    @Mock
    private ReservationContract.View view;
    @Mock
    private ListenerPickers listenerPickers;
    @Mock
    private Calendar startingDate;
    @Mock
    private Calendar endingDate;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        database = ParkingDatabase.getInstance();
        database.setParkingLots(VALID_INT_PARKING_AVAILABLE);
        presenter = new ReservationPresenter(view, new ReservationModel(database));
    }

    @After
    public void clearDatabase() {
        database.clearDatabase();
    }

    @Test
    public void testShowPickersTrue() {
        presenter.showPickers(listenerPickers, true);

        Mockito.verify(view).showDateAndTime(listenerPickers, true);
    }

    @Test
    public void testShowPickersFalse() {
        presenter.showPickers(listenerPickers, false);

        Mockito.verify(view).showDateAndTime(listenerPickers, false);
    }

    @Test
    public void testListenStartingDate() {
        presenter.listenStartingDate(startingDate);

        Mockito.verify(view).showStartingDate(DateUtils.calendarToString(startingDate));
    }

    @Test
    public void testListenEndingDate() {
        presenter.listenEndingDate(endingDate);

        Mockito.verify(view).showEndingDate((DateUtils.calendarToString(endingDate)));
    }

    @Test
    public void testConfirmReservationEmptyStartingDate() {
        presenter.confirmReservation(EMPTY_STRING, VALID_STRING_STARTING_DATE, STRING_KEY_CODE, VALID_STRING_PARKING_NUMBER);

        Mockito.verify(view).toastCompleteFields();
    }

    @Test
    public void testConfirmReservationEmptyEndingDate() {
        presenter.confirmReservation(VALID_STRING_STARTING_DATE, EMPTY_STRING, STRING_KEY_CODE, VALID_STRING_PARKING_NUMBER);

        Mockito.verify(view).toastCompleteFields();
    }

    @Test
    public void testConfirmReservationEmptyKey() {
        presenter.confirmReservation(VALID_STRING_STARTING_DATE, VALID_STRING_ENDING_DATE, EMPTY_STRING, VALID_STRING_PARKING_NUMBER);

        Mockito.verify(view).toastCompleteFields();
    }

    @Test
    public void testConfirmReservationEmptyParkingNumber() {
        presenter.confirmReservation(VALID_STRING_STARTING_DATE, VALID_STRING_ENDING_DATE, STRING_KEY_CODE, EMPTY_STRING);

        Mockito.verify(view).toastCompleteFields();
    }

    @Test
    public void testConfirmReservationStartBeforeNow() {
        presenter.confirmReservation(INVALID_STRING_STARTING_DATE, VALID_STRING_ENDING_DATE, STRING_KEY_CODE, VALID_STRING_PARKING_NUMBER);

        Mockito.verify(view).toastStartBeforeNow();
    }

    @Test
    public void testConfirmReservationEndBeforeStart() {
        presenter.confirmReservation(VALID_STRING_STARTING_DATE, INVALID_STRING_ENDING_DATE, STRING_KEY_CODE, VALID_STRING_PARKING_NUMBER);

        Mockito.verify(view).toastEndBeforeStart();
    }

    @Test
    public void testConfirmReservationParkBiggerThanTotal() {
        presenter.confirmReservation(VALID_STRING_STARTING_DATE, VALID_STRING_ENDING_DATE, STRING_KEY_CODE, INVALID_STRING_PARKING_NUMBER);

        Mockito.verify(view).toastParkBiggerThanTotal();
    }

    @Test
    public void testConfirmReservationAllOk() {
        presenter.confirmReservation(VALID_STRING_STARTING_DATE, VALID_STRING_ENDING_DATE, STRING_KEY_CODE, VALID_STRING_PARKING_NUMBER);

        Mockito.verify(view).toastAllOk();
    }

    @Test
    public void testConfirmReservationDateAlreadyReserved() {
        presenter.confirmReservation(VALID_STRING_STARTING_DATE, VALID_STRING_ENDING_DATE, STRING_KEY_CODE, VALID_STRING_PARKING_NUMBER);
        presenter.confirmReservation(VALID_STRING_STARTING_DATE, VALID_STRING_ENDING_DATE, STRING_KEY_CODE, VALID_STRING_PARKING_NUMBER);

        Mockito.verify(view).toastDateAlreadyReserved();
    }
}
