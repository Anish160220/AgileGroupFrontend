package com.example.agilegroupfrontend.BLL;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.agilegroupfrontend.BidsActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.BidsAdapter;
import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class GetAllOngoingBidsBLL {
    boolean isSuccess = false;
    List<Bids> bidsList = new ArrayList<>();

    public boolean getAllOngoing(){
        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);
        Call<List<Bids>> listCall = auctionSystemAPI.getAllBids(Url.Token);
        try {
      Response<List<Bids>> listResponse = listCall.execute();
            Url.bidsList = listResponse.body();


                isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
}
