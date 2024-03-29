package auctionsystemapi;

import java.util.List;

import model.APIResponse;
import model.Bids;
import model.Bids_Fight;
import model.Date;
import model.ImageResponse;
import model.LoginSignupResponse;
import model.Users;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface AuctionSystemAPI {
    @POST("api/account/register")
    Call<LoginSignupResponse> addUser(@Body Users users);

    @POST("api/account/login")
    Call<LoginSignupResponse> checkUser(@Body Users users);

    @Multipart
    @POST("api/bid/upload")
    Call<ImageResponse> uploadImage(@Header("x-access-token") String token, @Part MultipartBody.Part img);

    @POST("api/bid/addbid")
    Call<APIResponse> addBids(@Header("x-access-token") String token, @Body Bids bids);

    @GET("api/bid/bids")
    Call<List<Bids>> getAllBids(@Header("x-access-token") String token);

    @POST("api/bidfight/addbidfight")
    Call<APIResponse> addBidsFight(@Header("x-access-token") String token, @Body Bids_Fight bids_fight);

    @GET("api/bid/soldbids")
    Call<List<Bids>> getAllSoldBids(@Header("x-access-token") String token);

    //get Auction Ongoing list on the basis of USer_Id
    @GET("api/bid/{id}/soldbid")
    Call<List<Bids>>  getSoldByID(@Header("x-access-token") String token,@Path("id") int id);

    //get Auction Ongoing list on the basis of USer_Id
    @GET("api/bid/{id}/winbid")
    Call<List<Bids>>  getWinByID(@Header("x-access-token") String token,@Path("id") int id);


    @GET("api/bid/guitarbids")
    Call<List<Bids>> getGuitarBids(@Header("x-access-token") String token);

    @GET("api/bid/mikebids")
    Call<List<Bids>> getMikeBids(@Header("x-access-token") String token);

    @GET("api/bid/pedalbids")
    Call<List<Bids>> getPedalBids(@Header("x-access-token") String token);

    @GET("api/bid/otherbids")
    Call<List<Bids>> getOtherBids(@Header("x-access-token") String token);

    @GET("api/bid/{id}/closedbids")
    Call<List<Bids>>  getClosedByID(@Header("x-access-token") String token,@Path("id") int id);

    //Update Closing Auction on the basis of EndingDate
    @PUT("api/bid/{id}/updateendingdate")
    Call<Void> updateEndingDate(@Header("x-access-token") String token,@Path("id") int id,@Body Date date);

    //get Auction Ongoing list on the basis of USer_Id
    @GET("api/bid/{id}/search")
    Call<List<Bids>>  search(@Header("x-access-token") String token,@Path("id") String id);

}
