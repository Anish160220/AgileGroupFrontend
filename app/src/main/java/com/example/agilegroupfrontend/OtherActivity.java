package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.OtherBLL;

import java.util.ArrayList;
import java.util.List;

import adapter.BidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class OtherActivity extends AppCompatActivity {
    private RecyclerView OtherrecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        OtherActivity.this.setTitle("Others");
        OtherrecyclerView = findViewById(R.id.OtherrecyclerView);

        OtherBLL otherBLL = new OtherBLL();
        if (otherBLL.getOtherBId()){
            BidsAdapter bidsAdapter = new BidsAdapter(OtherActivity.this,bidsList);
            OtherrecyclerView.setAdapter(bidsAdapter);
            OtherrecyclerView.setLayoutManager(new LinearLayoutManager(OtherActivity.this));
        }else{
            Toast.makeText(OtherActivity.this, "Failed" , Toast.LENGTH_LONG).show();

        }

    }
}
