package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.SoldBidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class SoldBidsActivity extends AppCompatActivity {
    private RecyclerView soldRecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_bids);
        soldRecyclerView = findViewById(R.id.soldRecyclerView);

        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);

        Call<List<Bids>> listCall = auctionSystemAPI.getAllSoldBids(Url.Token);

        listCall.enqueue(new Callback<List<Bids>>() {
            @Override
            public void onResponse(Call<List<Bids>> call, Response<List<Bids>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SoldBidsActivity.this, "Error : " + response.code(), Toast.LENGTH_LONG).show();

                    bidsList = response.body();

                    Toast.makeText(SoldBidsActivity.this, String.valueOf(bidsList.size()), Toast.LENGTH_LONG).show();

                    SoldBidsAdapter soldBidsAdapter = new SoldBidsAdapter(SoldBidsActivity.this, bidsList);
                    soldRecyclerView.setAdapter(soldBidsAdapter);
                    soldRecyclerView.setLayoutManager(new LinearLayoutManager(SoldBidsActivity.this));
                }
            }

            @Override
            public void onFailure(Call<List<Bids>> call, Throwable t) {
                Toast.makeText(SoldBidsActivity.this, "Error : "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
