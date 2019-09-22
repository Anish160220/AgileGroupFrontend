package com.example.agilegroupfrontend.BLL;

import java.util.ArrayList;
import java.util.List;

import auctionsystemapi.AuctionSystemAPI;
import model.Bids;
import retrofit2.Call;
import retrofit2.Response;
import url.Url;

public class SearchBLL {
    private String keyword;
    boolean isSuccess = false;
    List<Bids> bidsList = new ArrayList<>();

    public SearchBLL(String keyword) {
        this.keyword = keyword;
    }

    public boolean checkSearch() {
        AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);
        Call<List<Bids>> listCall = auctionSystemAPI.search(Url.Token, this.keyword);
        try {
            Response<List<Bids>> listResponse = listCall.execute();
            if (listResponse.isSuccessful()) {
                Url.bidsList = listResponse.body();
                isSuccess = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
