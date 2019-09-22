package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.GetAllOngoingBidsBLL;

import java.util.ArrayList;
import java.util.List;

import adapter.BidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class BidsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bids);

        BidsActivity.this.setTitle("Ongoing Bids");
        recyclerView = findViewById(R.id.recyclerView);

        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);

        Call<List<Bids>> listCall = auctionSystemAPI.getAllBids(Url.Token);

        GetAllOngoingBidsBLL getAllOngoingBidsBLL = new GetAllOngoingBidsBLL();
        if (getAllOngoingBidsBLL.getAllOngoing()){
            BidsAdapter bidsAdapter = new BidsAdapter(BidsActivity.this,Url.bidsList);
            recyclerView.setAdapter(bidsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(BidsActivity.this));
        }


    }
}
