package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.MikeBLL;

import java.util.ArrayList;
import java.util.List;

import adapter.BidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class MikeActivity extends AppCompatActivity {
    private RecyclerView MikerecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mike);
        MikeActivity.this.setTitle("Mike");
        MikerecyclerView = findViewById(R.id.MikerecyclerView);

        MikeBLL mikeBLL = new MikeBLL();
        if (mikeBLL.getMikeBid()){
            BidsAdapter bidsAdapter = new BidsAdapter(MikeActivity.this,Url.bidsList);
            MikerecyclerView.setAdapter(bidsAdapter);
            MikerecyclerView.setLayoutManager(new LinearLayoutManager(MikeActivity.this));
        }else{
            Toast.makeText(MikeActivity.this, "Failed", Toast.LENGTH_LONG).show();

        }

    }
}
