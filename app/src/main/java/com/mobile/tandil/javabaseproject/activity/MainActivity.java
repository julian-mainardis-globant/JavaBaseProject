package com.mobile.tandil.javabaseproject.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.mobile.tandil.javabaseproject.database.ParkingDatabase;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.model.ParkingModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.ParkingPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.ParkingView;

public class MainActivity extends AppCompatActivity implements ListenerDialogFragment {
    private ParkingContract.Presenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ParkingPresenter(new ParkingModel(ParkingDatabase.getInstance()), new ParkingView(this, this.binding));
        setListeners();
    }

    public void setListeners() {
        binding.buttonMainActivity.setOnClickListener(view -> presenter.onShowSpacesButtonPressed(this));
        binding.buttonReservationActivity.setOnClickListener(view -> presenter.onShowReservationButtonPressed());
    }

    @Override
    public void listenAvailableSpaces(String availableSpaces) {
        presenter.listenParkingAvailable(availableSpaces);
    }
}
