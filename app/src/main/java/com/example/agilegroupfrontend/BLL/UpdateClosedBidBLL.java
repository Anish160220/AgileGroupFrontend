package com.example.agilegroupfrontend.BLL;

import auctionsystemapi.AuctionSystemAPI;
import model.APIResponse;
import model.Date;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class UpdateClosedBidBLL {
    private int id;
    private Date date;
    boolean isSuccess = false;

    public UpdateClosedBidBLL(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public boolean checkUpdateClosedBid(){
        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);
        Call<Void> updateEndingDate = auctionSystemAPI.updateEndingDate(Url.Token,this.id,this.date);
        try {


            Response<Void> response = updateEndingDate.execute();
            if (response.isSuccessful()) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
