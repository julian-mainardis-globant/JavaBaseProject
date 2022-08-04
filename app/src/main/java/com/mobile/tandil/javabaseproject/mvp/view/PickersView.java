package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Fragment;
import com.mobile.tandil.javabaseproject.databinding.DialogFragmentPickersBinding;
import com.mobile.tandil.javabaseproject.fragment.ReservationDialogFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.mvp.contract.PickersContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.FragmentView;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PickersView extends FragmentView implements PickersContract.View {
    private final DialogFragmentPickersBinding binding;

    public PickersView(Fragment fragment, DialogFragmentPickersBinding binding) {
        super(fragment);
        this.binding = binding;
    }

    private Calendar getDate() {
        ReservationDialogFragment fragment = (ReservationDialogFragment) getFragment();
        Calendar calendar = new GregorianCalendar();
        calendar.set(binding.datePickerDialogFragment.getYear(),
                binding.datePickerDialogFragment.getMonth(),
                binding.datePickerDialogFragment.getDayOfMonth(),
                binding.timePickerDialogFragment.getHour(),
                binding.timePickerDialogFragment.getMinute());
        fragment.dismiss();

        return calendar;
    }

    @Override
    public void showStartingDate(ListenerPickers listenerPickers) {
        listenerPickers.listenStartingDate(getDate());
    }

    @Override
    public void showEndingDate(ListenerPickers listenerPickers) {
        listenerPickers.listenEndingDate(getDate());
    }
}
