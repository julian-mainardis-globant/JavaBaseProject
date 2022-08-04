package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.activity.ReservationActivity;
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

    @Override
    public void showReservationActivity() {
        Context context = getContext();
        if (context != null) {
            Intent i = new Intent(context, ReservationActivity.class);
            context.startActivity(i);
        }
    }

    @Override
    public void showToastEmptyAvailableSpaces() {
        Activity activity = getActivity();
        if(activity != null) {
            Toast.makeText(activity, R.string.reservation_button_main_activity, Toast.LENGTH_SHORT).show();
        }
    }
}
