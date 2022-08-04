package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.mvp.contract.PickersContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PickersPresenterTest {
    private PickersContract.Presenter presenter;

    @Mock
    private PickersContract.View view;
    @Mock
    private ListenerPickers listenerPickers;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        presenter = new PickersPresenter(view, true);
    }

    @Test
    public void testOnConfirmedDateStart() {
        presenter.onConfirmedDate(listenerPickers);

        Mockito.verify(view).showStartingDate(listenerPickers);
    }

    @Test
    public void testOnConfirmedDateEnd() {
        presenter = new PickersPresenter(view, false);

        presenter.onConfirmedDate(listenerPickers);

        Mockito.verify(view).showEndingDate(listenerPickers);
    }
}
