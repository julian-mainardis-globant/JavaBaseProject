package com.mobile.tandil.javabaseproject.mvp.contract;

import com.mobile.tandil.javabaseproject.listener.ListenerPickers;

public interface PickersContract {

    interface Presenter {
        void onConfirmedDate(ListenerPickers listenerPickers);
    }

    interface View {
        void showStartingDate(ListenerPickers listenerPickers);
        void showEndingDate(ListenerPickers listenerPickers);
    }
}
