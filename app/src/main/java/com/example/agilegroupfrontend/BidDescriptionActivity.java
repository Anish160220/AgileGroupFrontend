package com.example.agilegroupfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BidDescriptionActivity extends AppCompatActivity {
    int bidId;
    private EditText etDesPlaceYourBid;
    private Button btnDesAddAmount;
    private ImageView ivDesBidProfile;
    private TextView tvDesBidTitle,tvDesBidPrice,tvDesBidMaxPrice, tvDesBidMarketValue, tvDesBidEndingDate, tvDesBidCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_description);
    }
}
