package com.mobile.tandil.javabaseproject.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.mobile.tandil.javabaseproject.database.ParkingDatabase;
import com.mobile.tandil.javabaseproject.databinding.ActivityReservationBinding;
import com.mobile.tandil.javabaseproject.listener.ListenerPickers;
import com.mobile.tandil.javabaseproject.mvp.contract.ReservationContract;
import com.mobile.tandil.javabaseproject.mvp.model.ReservationModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.ReservationPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.ReservationView;
import java.util.Calendar;

public class ReservationActivity extends AppCompatActivity implements ListenerPickers {
    private ReservationContract.Presenter presenter;
    private ActivityReservationBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ReservationPresenter(new ReservationView(this, binding), new ReservationModel(ParkingDatabase.getInstance()));
        setListeners();
    }

    private void setListeners() {
        binding.buttonStartingDayReservationActivity.setOnClickListener(view -> presenter.showPickers(this, true));
        binding.buttonEndingDayReservationActivity.setOnClickListener(view -> presenter.showPickers(this, false));
        binding.acceptButtonReservationActivity.setOnClickListener(view -> presenter.confirmReservation(
                        binding.textViewStartingDayReservationActivity.getText().toString(),
                        binding.textViewEndingDayReservationActivity.getText().toString(),
                        binding.inputCodeReservationActivity.getEditText().getText().toString(),
                        binding.inputTextNumberOfParkingReservationActivity.getEditText().getText().toString()));
    }

    @Override
    public void listenStartingDate(Calendar date) {
        presenter.listenStartingDate(date);
    }

    @Override
    public void listenEndingDate(Calendar date) {
        presenter.listenEndingDate(date);
    }
}
