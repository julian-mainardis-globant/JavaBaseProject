package com.mobile.tandil.javabaseproject.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mobile.tandil.javabaseproject.databinding.DialogFragmentBinding;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.DialogContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.DialogPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.DialogView;

public class ParkingAvailableDialogFragment extends DialogFragment {

    private DialogContract.Presenter presenter;
    private static final String LISTENER_KEY = "LISTENER_KEY";
    public static final String TAG = "PARKING_AVAILABLE_DIALOG_FRAGMENT";
    private DialogFragmentBinding binding;
    private ListenerDialogFragment listenerDialogFragment;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new DialogPresenter(new DialogView(this));

        listenerDialogFragment = (ListenerDialogFragment) getArguments().getSerializable(LISTENER_KEY);
        setListeners();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DialogFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void setListeners() {
        binding.buttonDialogFragment.setOnClickListener(view -> presenter.onPressedInputButton(binding.inputDialogFragment.getText().toString(), listenerDialogFragment));
    }

    public static ParkingAvailableDialogFragment newInstance(ListenerDialogFragment listenerDialogFragment) {
        ParkingAvailableDialogFragment dialogFragment = new ParkingAvailableDialogFragment();
        Bundle bundle = new Bundle();

        bundle.putSerializable(LISTENER_KEY, listenerDialogFragment);
        dialogFragment.setArguments(bundle);

        return dialogFragment;
    }
}
