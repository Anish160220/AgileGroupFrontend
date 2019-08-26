package auctionsystemapi;

import model.LoginSignupResponse;
import model.Users;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuctionSystemAPI {
    @POST("api/account/register")
    Call<LoginSignupResponse> addUser(@Body Users users);
}
