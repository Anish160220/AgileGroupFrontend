package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.GuitarBLL;

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
        GuitarActivity.this.setTitle("Guitar");
        GuitarrecyclerView = findViewById(R.id.GuitarrecyclerView);

        GuitarBLL guitarBLL = new GuitarBLL();
        if (guitarBLL.getGuitarBid()){
            BidsAdapter bidsAdapter = new BidsAdapter(GuitarActivity.this,Url.bidsList);
            GuitarrecyclerView.setAdapter(bidsAdapter);
            GuitarrecyclerView.setLayoutManager(new LinearLayoutManager(GuitarActivity.this));
        }else{
            Toast.makeText(GuitarActivity.this, "Failed", Toast.LENGTH_LONG).show();
        }
    }
}
