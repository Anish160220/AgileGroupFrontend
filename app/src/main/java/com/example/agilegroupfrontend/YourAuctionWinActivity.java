package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.YourAuctionSoldOutActivityBLL;
import com.example.agilegroupfrontend.BLL.YourAuctionWinBLL;

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
        YourAuctionWinActivity.this.setTitle("Your Won Items");
        yourAuctionWinRecyclerView = findViewById(R.id.yourAuctionWinRecyclerView);

        YourAuctionWinBLL yourAuctionWinBLL = new YourAuctionWinBLL();

        if (yourAuctionWinBLL.getWinBid()) {
            YourAuctionWinAdapter yourAuctionWinAdapter = new YourAuctionWinAdapter(YourAuctionWinActivity.this, Url.bidsList);
            yourAuctionWinRecyclerView.setAdapter(yourAuctionWinAdapter);
            yourAuctionWinRecyclerView.setLayoutManager(new LinearLayoutManager(YourAuctionWinActivity.this));

        } else {
            Toast.makeText(YourAuctionWinActivity.this, "Failed", Toast.LENGTH_LONG).show();

        }


    }
}
