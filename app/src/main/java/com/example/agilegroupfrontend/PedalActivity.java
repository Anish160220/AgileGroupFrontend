package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.PedalBLL;

import java.util.ArrayList;
import java.util.List;

import adapter.BidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class PedalActivity extends AppCompatActivity {
    private RecyclerView PedalrecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedal);
        PedalActivity.this.setTitle("Pedal");
        PedalrecyclerView = findViewById(R.id.PedalrecyclerView);

        PedalBLL pedalBLL = new PedalBLL();
        if (pedalBLL.getPedalBid()){
            BidsAdapter bidsAdapter = new BidsAdapter(PedalActivity.this,Url.bidsList);
            PedalrecyclerView.setAdapter(bidsAdapter);
            PedalrecyclerView.setLayoutManager(new LinearLayoutManager(PedalActivity.this));
        }else{
            Toast.makeText(PedalActivity.this, "Failed", Toast.LENGTH_LONG).show();

        }
    }
}
