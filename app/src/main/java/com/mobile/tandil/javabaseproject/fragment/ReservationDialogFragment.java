package com.mobile.tandil.javabaseproject.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.mobile.tandil.javabaseproject.databinding.DialogFragmentPickersBinding;
import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.mvp.contract.PickersContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.PickersPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.PickersView;

public class ReservationDialogFragment extends DialogFragment {

    PickersContract.Presenter presenter;
    private static final String LISTENER_PICKERS_KEY = "LISTENER_PICKERS_KEY";
    DialogFragmentPickersBinding binding;
    private static Boolean LISTENER_BOOLEAN;
    ListenerPickers listenerPickers;
    public static final String TAG = "PICKERS_DIALOG_FRAGMENT";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new PickersPresenter(new PickersView(this, binding), LISTENER_BOOLEAN);

        listenerPickers = (ListenerPickers) getArguments().getSerializable(LISTENER_PICKERS_KEY);
        setListeners();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DialogFragmentPickersBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    private void setListeners() {
        binding.buttonAcceptPickers.setOnClickListener(view -> presenter.onConfirmedDate(listenerPickers));
    }

    public static ReservationDialogFragment newInstance(ListenerPickers listenerPickers, Boolean startOrEnd) {
        ReservationDialogFragment reservationDialogFragment = new ReservationDialogFragment();
        Bundle bundle = new Bundle();
        LISTENER_BOOLEAN = startOrEnd;
        bundle.putSerializable(LISTENER_PICKERS_KEY, listenerPickers);
        reservationDialogFragment.setArguments(bundle);

        return reservationDialogFragment;
    }
}
