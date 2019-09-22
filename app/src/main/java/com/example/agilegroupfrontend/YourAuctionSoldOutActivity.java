package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.YourAuctionSoldOutActivityBLL;

import java.util.ArrayList;
import java.util.List;

import adapter.YourAuctionSoldOutAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class YourAuctionSoldOutActivity extends AppCompatActivity {
    private RecyclerView yourAuctionSoldOutRecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_auction_sold_out);
        YourAuctionSoldOutActivity.this.setTitle("Your Sold Auction");
        yourAuctionSoldOutRecyclerView = findViewById(R.id.yourAuctionSoldOutRecyclerView);

        YourAuctionSoldOutActivityBLL yourAuctionSoldOutActivityBLL = new YourAuctionSoldOutActivityBLL();

        if (yourAuctionSoldOutActivityBLL.getOwnSoldBids()){
            YourAuctionSoldOutAdapter yourAuctionSoldOutAdapter = new YourAuctionSoldOutAdapter(YourAuctionSoldOutActivity.this, Url.bidsList);
            yourAuctionSoldOutRecyclerView.setAdapter(yourAuctionSoldOutAdapter);
            yourAuctionSoldOutRecyclerView.setLayoutManager(new LinearLayoutManager(YourAuctionSoldOutActivity.this));

        }else{
            Toast.makeText(YourAuctionSoldOutActivity.this, "Failed", Toast.LENGTH_LONG).show();

        }
    }
}
