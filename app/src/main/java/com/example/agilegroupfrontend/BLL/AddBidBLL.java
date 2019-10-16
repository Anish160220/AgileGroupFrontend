package com.example.agilegroupfrontend.BLL;

import auctionsystemapi.AuctionSystemAPI;
import model.APIResponse;
import model.Bids;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class AddBidBLL {
    private int userId;

    private String bidImage,bidTitle;
    private int startingPrice,maxPrice,marketValue;
    private String endingDate;
    private String category;
    private int bidCount;
       private String status;
    boolean isSuccess = false;

    public AddBidBLL(int userId, String bidImage, String bidTitle, int startingPrice, int maxPrice, int marketValue, String endingDate, String category, int bidCount, String status) {
        this.userId = userId;
        this.bidImage = bidImage;
        this.bidTitle = bidTitle;
        this.startingPrice = startingPrice;
        this.maxPrice = maxPrice;
        this.marketValue = marketValue;
        this.endingDate = endingDate;
        this.category = category;
        this.bidCount = bidCount;
        this.status = status;
    }

    public boolean checkAddBid() {
        Bids bids = new Bids(this.userId,this.bidImage,this.bidTitle, this.startingPrice,this.maxPrice,this.marketValue,this.endingDate,this.category,this.bidCount,this.status);

        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);
        Call<APIResponse> usersCall = auctionSystemAPI.addBids(Url.Token,bids);
        try {


            Response<APIResponse> response = usersCall.execute();
            if (response.body().isSuccess()) {
                isSuccess = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    }

