package com.mobile.tandil.javabaseproject.mvp.contract;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;

public interface DialogContract {

    interface Presenter {
        void onPressedInputButton(String parkingAvailable, ListenerDialogFragment listenerDialogFragment);
    }

    interface View {
        void showParkingAvailable(String parkingAvailable, ListenerDialogFragment listenerDialogFragment);
    }
}
