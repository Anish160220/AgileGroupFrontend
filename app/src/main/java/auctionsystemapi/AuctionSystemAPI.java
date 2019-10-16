package auctionsystemapi;

import java.util.List;

import model.Bids;
import model.Bids_Fight;
import model.ImageResponse;
import model.LoginSignupResponse;
import model.Response;
import model.Users;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AuctionSystemAPI {
    @POST("api/account/register")
    Call<LoginSignupResponse> addUser(@Body Users users);

    @POST("api/account/login")
    Call<LoginSignupResponse> checkUser(@Body Users users);

    @Multipart
    @POST("api/bid/upload")
    Call<ImageResponse> uploadImage(@Header("x-access-token") String token, @Part MultipartBody.Part img);

    @POST("api/bid/addbid")
    Call<Response> addBids(@Header("x-access-token") String token, @Body Bids bids);

    @GET("api/bid/bids")
    Call<List<Bids>> getAllBids(@Header("x-access-token") String token);

    @POST("api/bidfight/addbidfight")
    Call<Response> addBidsFight(@Header("x-access-token") String token,@Body Bids_Fight bids_fight);
}
