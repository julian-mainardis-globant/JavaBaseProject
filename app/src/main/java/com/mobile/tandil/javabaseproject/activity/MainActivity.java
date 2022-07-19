package com.mobile.tandil.javabaseproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.model.ParkingModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.ParkingPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.ParkingView;

public class MainActivity extends AppCompatActivity {

    private ParkingContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new ParkingPresenter(new ParkingModel(), new ParkingView(this));
    }
}

