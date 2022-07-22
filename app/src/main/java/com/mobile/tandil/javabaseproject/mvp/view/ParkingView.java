package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.fragment.ParkingAvailableDialogFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.View {

    private final ActivityMainBinding binding;

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);

        this.binding = binding;
    }

    @Override
    public void showDialogFragment(ListenerDialogFragment listenerDialogFragment) {
        ParkingAvailableDialogFragment dialog = ParkingAvailableDialogFragment.newInstance(listenerDialogFragment);
        FragmentManager fragmentManager = getFragmentManager();
        dialog.show(fragmentManager, ParkingAvailableDialogFragment.TAG);
    }

    @Override
    public void showNumberOfParking(String numberOfParking) {
        binding.textViewMainActivity.setText(numberOfParking);
    }
}
