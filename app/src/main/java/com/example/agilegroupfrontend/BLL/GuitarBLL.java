package com.example.agilegroupfrontend.BLL;

import java.util.ArrayList;
import java.util.List;

import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class GuitarBLL {
    boolean isSuccess = false;
    List<Bids> bidsList = new ArrayList<>();

    public boolean getGuitarBid(){
        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);
        Call<List<Bids>> listCall = auctionSystemAPI.getGuitarBids(Url.Token);
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
