package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.BidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class GuitarActivity extends AppCompatActivity {
    private RecyclerView GuitarrecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar);
        GuitarrecyclerView = findViewById(R.id.GuitarrecyclerView);
        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);

        Call<List<Bids>> listCall = auctionSystemAPI.getGuitarBids(Url.Token);

        listCall.enqueue(new Callback<List<Bids>>() {
            @Override
            public void onResponse(Call<List<Bids>> call, Response<List<Bids>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(GuitarActivity.this, "Error : "+response.code(), Toast.LENGTH_LONG).show();

                    bidsList = response.body();

                    Toast.makeText(GuitarActivity.this, String.valueOf(bidsList.size()), Toast.LENGTH_LONG).show();

                    BidsAdapter bidsAdapter = new BidsAdapter(GuitarActivity.this,bidsList);
                    GuitarrecyclerView.setAdapter(bidsAdapter);
                    GuitarrecyclerView.setLayoutManager(new LinearLayoutManager(GuitarActivity.this));
                }
            }

            @Override
            public void onFailure(Call<List<Bids>> call, Throwable t) {
                Toast.makeText(GuitarActivity.this, "Error : "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
