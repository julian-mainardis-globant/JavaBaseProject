package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.database.ParkingDatabase;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.model.ParkingModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingPresenterTest {
    private static final String VALID_STRING_PARKING_AVAILABLE = "123";
    private static final String INVALID_STRING_PARKING_AVAILABLE = "-18";
    private static final String EMPTY_STRING = "";
    private ParkingContract.Presenter presenter;

    @Mock
    private ParkingContract.View view;
    @Mock
    private ListenerDialogFragment dialogFragment;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        presenter = new ParkingPresenter(new ParkingModel(ParkingDatabase.getInstance()), view);
    }

    @Test
    public void testOnShowSpacesButtonPressed() {
        presenter.onShowSpacesButtonPressed(dialogFragment);

        Mockito.verify(view).showDialogFragment(dialogFragment);
    }

    @Test
    public void testListenParkingAvailableEmpty() {
        presenter.listenParkingAvailable(EMPTY_STRING);

        Mockito.verify(view).showToastEmptyAvailableSpaces();
    }

    @Test
    public void testListenParkingAvailableOk() {
        presenter.listenParkingAvailable(VALID_STRING_PARKING_AVAILABLE);

        Mockito.verify(view).showNumberOfParking(VALID_STRING_PARKING_AVAILABLE);
    }

    @Test
    public void testOnShowReservationButtonPressedOk() {
        presenter.listenParkingAvailable(VALID_STRING_PARKING_AVAILABLE);
        presenter.onShowReservationButtonPressed();

        Mockito.verify(view).showReservationActivity();
    }

    @Test
    public void testOnShowReservationButtonPressedInvalid() {
        presenter.listenParkingAvailable(INVALID_STRING_PARKING_AVAILABLE);
        presenter.onShowReservationButtonPressed();

        Mockito.verify(view).showToastEmptyAvailableSpaces();
    }
}
