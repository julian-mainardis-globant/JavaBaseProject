package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.DialogFragment;
import com.mobile.tandil.javabaseproject.fragment.ParkingAvailableDialogFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.DialogContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.FragmentView;

public class DialogView extends FragmentView implements DialogContract.View {

    public DialogView(ParkingAvailableDialogFragment fragment) {
        super(fragment);
    }

    @Override
    public void showParkingAvailable(String parkingAvailable, ListenerDialogFragment listenerDialogFragment) {
        DialogFragment fragment = (DialogFragment) getFragment();
        listenerDialogFragment.listenAvailableSpaces(parkingAvailable);
        fragment.dismiss();
    }
}
