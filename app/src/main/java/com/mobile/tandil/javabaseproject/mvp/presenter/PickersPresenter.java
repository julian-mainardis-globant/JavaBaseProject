package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.mvp.contract.PickersContract;

public class PickersPresenter implements PickersContract.Presenter {
    private final PickersContract.View view;
    private final Boolean startOrEnd;

    public PickersPresenter(PickersContract.View view, Boolean startOrEnd) {
        this.view = view;
        this.startOrEnd = startOrEnd;
    }

    @Override
    public void onConfirmedDate(ListenerPickers listenerPickers) {
        if (startOrEnd) {
            view.showStartingDate(listenerPickers);
        } else {
            view.showEndingDate(listenerPickers);
        }
    }
}
