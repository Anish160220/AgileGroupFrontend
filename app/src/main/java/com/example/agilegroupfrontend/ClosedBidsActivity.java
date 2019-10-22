package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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

        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);

        Call<List<Bids>> listCall = auctionSystemAPI.getClosedByID(Url.Token,Url.userId);

        listCall.enqueue(new Callback<List<Bids>>() {
            @Override
            public void onResponse(Call<List<Bids>> call, Response<List<Bids>> response) {
                Toast.makeText(ClosedBidsActivity.this, "Error : "+response.code(), Toast.LENGTH_LONG).show();

                bidsList = response.body();

                Toast.makeText(ClosedBidsActivity.this, String.valueOf(bidsList.size()), Toast.LENGTH_LONG).show();

                ClosedBidsAdapter closedBidsAdapter = new ClosedBidsAdapter(ClosedBidsActivity.this,bidsList);
                closedRecyclerView.setAdapter(closedBidsAdapter);
                closedRecyclerView.setLayoutManager(new LinearLayoutManager(ClosedBidsActivity.this));
            }

            @Override
            public void onFailure(Call<List<Bids>> call, Throwable t) {
                Toast.makeText(ClosedBidsActivity.this, "Error : "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
