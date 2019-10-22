package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.YourAuctionWinAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class YourAuctionWinActivity extends AppCompatActivity {
    private RecyclerView yourAuctionWinRecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_auction_win);
        yourAuctionWinRecyclerView = findViewById(R.id.yourAuctionWinRecyclerView);
        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);

        Call<List<Bids>> listCall = auctionSystemAPI.getWinByID(Url.Token,Url.userId);

        listCall.enqueue(new Callback<List<Bids>>() {
            @Override
            public void onResponse(Call<List<Bids>> call, Response<List<Bids>> response) {
                bidsList = response.body();
                YourAuctionWinAdapter yourAuctionWinAdapter = new YourAuctionWinAdapter(YourAuctionWinActivity.this, bidsList);
                yourAuctionWinRecyclerView.setAdapter(yourAuctionWinAdapter);
                yourAuctionWinRecyclerView.setLayoutManager(new LinearLayoutManager(YourAuctionWinActivity.this));

            }

            @Override
            public void onFailure(Call<List<Bids>> call, Throwable t) {
                Toast.makeText(YourAuctionWinActivity.this, "E"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
