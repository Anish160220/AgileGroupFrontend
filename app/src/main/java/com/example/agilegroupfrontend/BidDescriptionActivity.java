package com.example.agilegroupfrontend;

import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.BidFightBLL;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import url.Url;

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
        etDesPlaceYourBid = findViewById(R.id.etDesPlaceYourBid);
        btnDesAddAmount = findViewById(R.id.btnDesAddAmount);
        ivDesBidProfile = findViewById(R.id.ivDesBidProfile);
        tvDesBidTitle = findViewById(R.id.tvDesBidTitle);
        tvDesBidPrice = findViewById(R.id.tvDesBidPrice);
        tvDesBidMaxPrice = findViewById(R.id.tvDesBidMaxPrice);
        tvDesBidMarketValue = findViewById(R.id.tvDesBidMarketValue);
        tvDesBidEndingDate = findViewById(R.id.tvDesBidEndingDate);
        tvDesBidCategory = findViewById(R.id.tvDesBidCategory);

        StrictMode();
        URL url = null;
        Bundle bundle = getIntent().getExtras();

        if(bundle != null)
        {
            ivDesBidProfile.setImageResource(bundle.getInt("bidImage"));
            try {
                url = new URL("http://10.0.2.2:3000/uploads/"+bundle.getString("bidImage"));
                ivDesBidProfile.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (IOException e) {
                e.printStackTrace();
            }


            tvDesBidTitle.setText(bundle.getString("bidTitle"));
            tvDesBidPrice.setText(String.valueOf(bundle.getInt("bidPrice")));
            tvDesBidMaxPrice.setText(String.valueOf(bundle.getInt("maxPrice")));
            tvDesBidMarketValue.setText(String.valueOf(bundle.getInt("marketValue")));
            tvDesBidEndingDate.setText(bundle.getString("endingDate"));
            tvDesBidCategory.setText(bundle.getString("category"));
            String bid_Id= String.valueOf(bundle.getInt("bidId"));
            bidId=Integer.parseInt(bid_Id);
            Toast.makeText(BidDescriptionActivity.this,"Bid Id: "+bidId,Toast.LENGTH_LONG).show();
        }

        btnDesAddAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddAmount();

            }
        });
    }

    private void AddAmount() {
        if(validate()){
            int bidAmount = Integer.parseInt(etDesPlaceYourBid.getText().toString());
            BidFightBLL bidFightBLL = new BidFightBLL(bidId, Url.userId, bidAmount);


           if (bidFightBLL.checkBidFight()){
               Toast.makeText(BidDescriptionActivity.this,"Bid amount added successful",Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(BidDescriptionActivity.this,Url.message,Toast.LENGTH_SHORT).show();

           }



        }

    }


    private boolean validate() {
        boolean flag = true;
        if(TextUtils.isEmpty(etDesPlaceYourBid.getText().toString())){
            etDesPlaceYourBid.setError("Place Your Bid First");
            etDesPlaceYourBid.requestFocus();
            flag= false;
        }
        else if(Integer.parseInt(etDesPlaceYourBid.getText().toString())<=Integer.parseInt(tvDesBidPrice.getText().toString())){
            etDesPlaceYourBid.setError("Please select higher amount than Bid Price and lower than Bid Max Price");
            etDesPlaceYourBid.requestFocus();
            flag=false;
        }
        return  flag;
    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

}

