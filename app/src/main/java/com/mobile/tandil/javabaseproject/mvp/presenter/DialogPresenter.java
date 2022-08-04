package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.DialogContract;

public class DialogPresenter implements DialogContract.Presenter {
    private final DialogContract.View view;

    public DialogPresenter(DialogContract.View view) {
        this.view = view;
    }

    @Override
    public void onPressedInputButton(String parkingAvailable, ListenerDialogFragment listenerDialogFragment) {
        view.showParkingAvailable(parkingAvailable, listenerDialogFragment);
    }
}
