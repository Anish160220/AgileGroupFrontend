

package com.example.agilegroupfrontend;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.widget.Toast;

        import com.example.agilegroupfrontend.BLL.SoldBidsBLL;

        import java.util.ArrayList;
        import java.util.List;

        import adapter.SoldBidsAdapter;
        import auctionsystemapi.AuctionSystemAPI;
        import model.Bids;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import url.Url;

public class SoldBidsActivity extends AppCompatActivity {
    private RecyclerView soldRecyclerView;
    List<Bids> bidsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_bids);
        SoldBidsActivity.this.setTitle("Sold Items");
        soldRecyclerView = findViewById(R.id.soldRecyclerView);

        SoldBidsBLL soldBidsBLL = new SoldBidsBLL();
        if (soldBidsBLL.getSoldBids()){
            SoldBidsAdapter soldBidsAdapter = new SoldBidsAdapter(SoldBidsActivity.this, Url.bidsList);
            soldRecyclerView.setAdapter(soldBidsAdapter);
            soldRecyclerView.setLayoutManager(new LinearLayoutManager(SoldBidsActivity.this));
        }else{
            Toast.makeText(SoldBidsActivity.this, "Failed", Toast.LENGTH_LONG).show();

        }
    }
}
