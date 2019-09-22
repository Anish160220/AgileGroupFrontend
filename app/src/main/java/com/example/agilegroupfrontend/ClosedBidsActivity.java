package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.ClosedBidBLL;

import java.util.ArrayList;
import java.util.List;

import adapter.ClosedBidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class ClosedBidsActivity extends AppCompatActivity {
    private RecyclerView closedRecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_bids);
        closedRecyclerView = findViewById(R.id.closedRecyclerView);

        ClosedBidBLL closedBidBLL = new ClosedBidBLL();

        if (closedBidBLL.getClosedBid()){
            ClosedBidsAdapter closedBidsAdapter = new ClosedBidsAdapter(ClosedBidsActivity.this,Url.bidsList);
            closedRecyclerView.setAdapter(closedBidsAdapter);
            closedRecyclerView.setLayoutManager(new LinearLayoutManager(ClosedBidsActivity.this));
        }else{
            Toast.makeText(ClosedBidsActivity.this, "Failed", Toast.LENGTH_LONG).show();

        }

    }
}
