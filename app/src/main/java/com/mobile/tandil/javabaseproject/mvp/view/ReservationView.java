package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.StringRes;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.databinding.ActivityReservationBinding;
import com.mobile.tandil.javabaseproject.fragment.ReservationDialogFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.mvp.contract.ReservationContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;

public class ReservationView extends ActivityView implements ReservationContract.View {
    private final ActivityReservationBinding binding;

    public ReservationView(Activity activity, ActivityReservationBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showDateAndTime(ListenerPickers listenerPickers, Boolean startOrEnd) {
        ReservationDialogFragment reservationDialogFragment = ReservationDialogFragment.newInstance(listenerPickers, startOrEnd);
        FragmentManager fragmentManager = getFragmentManager();
        reservationDialogFragment.show(fragmentManager, ReservationDialogFragment.TAG);
    }

    @Override
    public void showStartingDate(String date) {
        binding.textViewStartingDayReservationActivity.setText(date);
    }

    @Override
    public void showEndingDate(String date) {
        binding.textViewEndingDayReservationActivity.setText(date);
    }

    private void showToast(@StringRes int idMsg) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, idMsg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void toastStartBeforeNow() {
        showToast(R.string.start_date_before_now);
    }

    @Override
    public void toastEndBeforeStart() {
        showToast(R.string.ending_before_starting);
    }

    @Override
    public void toastParkBiggerThanTotal() {
        showToast(R.string.park_number_bigger_than_total);
    }

    @Override
    public void toastDateAlreadyReserved() {
        showToast(R.string.date_already_reserved);
    }

    @Override
    public void toastCompleteFields() {
        showToast(R.string.complete_fields);
    }

    @Override
    public void toastAllOk() {
        showToast(R.string.reservation_saved);
    }
}
