package com.example.agilegroupfrontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class YourAuctionDashboardActivity extends AppCompatActivity {
    private CardView cvYourAuctionOnGoingBid, cvYourAuctionSoldOut, cvYourAuctionWinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_auction_dashboard);
        YourAuctionDashboardActivity.this.setTitle("Your Dashboard");
        cvYourAuctionSoldOut = findViewById(R.id.cvYourAuctionSoldOut);
        cvYourAuctionWinner = findViewById(R.id.cvYourAuctionWinner);
        cvYourAuctionSoldOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YourAuctionDashboardActivity.this, YourAuctionSoldOutActivity.class);
                startActivity(intent);
            }
        });

        cvYourAuctionWinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YourAuctionDashboardActivity.this, YourAuctionWinActivity.class);
                startActivity(intent);
            }
        });

    }
}
