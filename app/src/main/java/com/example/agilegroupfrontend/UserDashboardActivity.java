package com.example.agilegroupfrontend;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import broadcast.BroadCastReceiver;
import model.Bids;

public class UserDashboardActivity extends AppCompatActivity {
    BroadCastReceiver broadCastReceiver = new BroadCastReceiver(this);

    private CardView cvAddBid, cvUserOnGoingBid, cvUserSoldOut, cvYourAuction, cvUserCategory, cvUserClosedAuction;
    private EditText etSearch;
    private RecyclerView SearchrecyclerView;
    private Button btnLogOut;
    private SensorManager sensorManager;
    List<Bids> bidsList = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

        registerReceiver(broadCastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadCastReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        SearchrecyclerView = findViewById(R.id.SearchrecyclerView);
        etSearch = findViewById(R.id.etSearch);
        cvAddBid = findViewById(R.id.cvAddBid);
        cvUserOnGoingBid = findViewById(R.id.cvUserOnGoingBid);
        cvUserSoldOut = findViewById(R.id.cvUserSoldOut);
        cvYourAuction = findViewById(R.id.cvYourAuction);
        cvUserCategory = findViewById(R.id.cvUserCategory);
        cvUserClosedAuction = findViewById(R.id.cvUserClosedAuction);
        btnLogOut = findViewById(R.id.btnLogOut);

        cvAddBid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, AddBidActivity.class);
                startActivity(intent);
            }
        });

        cvUserOnGoingBid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, BidsActivity.class);
                startActivity(intent);
            }
        });

        cvUserSoldOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, SoldBidsActivity.class);
                startActivity(intent);
            }
        });
    }
}
