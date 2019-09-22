package com.example.agilegroupfrontend;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.SearchBLL;

import java.util.ArrayList;
import java.util.List;

import adapter.BidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import broadcast.BroadCastReceiver;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

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
        UserDashboardActivity.this.setTitle("Dashboard");
        SearchrecyclerView = findViewById(R.id.SearchrecyclerView);
        etSearch = findViewById(R.id.etSearch);
        cvAddBid = findViewById(R.id.cvAddBid);
        cvUserOnGoingBid = findViewById(R.id.cvUserOnGoingBid);
        cvUserSoldOut = findViewById(R.id.cvUserSoldOut);
        cvYourAuction = findViewById(R.id.cvYourAuction);
        cvUserCategory = findViewById(R.id.cvUserCategory);
        cvUserClosedAuction = findViewById(R.id.cvUserClosedAuction);
        btnLogOut = findViewById(R.id.btnLogOut);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Url.userId = 0;
                Url.Token ="";
                Intent intent = new Intent(UserDashboardActivity.this, MainActivity.class);
                finish();
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etSearch.getText().toString().equals("")){
                    SearchrecyclerView.setVisibility(View.VISIBLE);
                }else {
                    SearchrecyclerView.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                bidsList=null;
            }
        });

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }

            private void performSearch() {
                SearchBLL searchBLL = new SearchBLL(etSearch.getText().toString());

                if (searchBLL.checkSearch()){
                    BidsAdapter bidsAdapter = new BidsAdapter(UserDashboardActivity.this,Url.bidsList);
                    SearchrecyclerView.setAdapter(bidsAdapter);
                    SearchrecyclerView.setLayoutManager(new LinearLayoutManager(UserDashboardActivity.this));
                }else{
                    Toast.makeText(UserDashboardActivity.this, "Failed", Toast.LENGTH_LONG).show();

                }

            }
        });
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

        cvYourAuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, YourAuctionDashboardActivity.class);
                startActivity(intent);
            }
        });

        cvUserCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this,CategoryDashboardActivity.class);
                startActivity(intent);
            }
        });

        cvUserClosedAuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, ClosedBidsActivity.class);
                startActivity(intent);
            }
        });
    }
}
