package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.DialogContract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DialogPresenterTest {
    private static final String EMPTY_STRING = "";
    private DialogContract.Presenter presenter;

    @Mock
    private DialogContract.View view;
    @Mock
    private ListenerDialogFragment dialogFragment;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        presenter = new DialogPresenter(view);
    }

    @Test
    public void testOnPressedInputButton() {
        presenter.onPressedInputButton(EMPTY_STRING, dialogFragment);

        Mockito.verify(view).showParkingAvailable(EMPTY_STRING, dialogFragment);
    }
}
