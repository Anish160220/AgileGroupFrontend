package com.example.agilegroupfrontend.BLL;

import android.content.Intent;
import android.widget.Toast;

import com.example.agilegroupfrontend.BidDescriptionActivity;
import com.example.agilegroupfrontend.BidsActivity;

import auctionsystemapi.AuctionSystemAPI;
import model.APIResponse;
import model.Bids_Fight;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;
import url.Url;

public class BidFightBLL {
    private int bidId, bidderId, bidAmount;
    private boolean isSuccess = false;

    public BidFightBLL(int bidId, int bidderId, int bidAmount) {
        this.bidId = bidId;
        this.bidderId = bidderId;
        this.bidAmount = bidAmount;
    }

    public boolean checkBidFight(){
        Bids_Fight bids_fight = new Bids_Fight(this.bidId, this.bidderId, this.bidAmount);

        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);

        Call<APIResponse> usersCall = auctionSystemAPI.addBidsFight(Url.Token,bids_fight);

        try {
            Response<APIResponse> response = usersCall.execute();
            if (response.body().isSuccess()){
                isSuccess=true;
            }
        }catch (Exception e){

        }

        return isSuccess;
    }
}
