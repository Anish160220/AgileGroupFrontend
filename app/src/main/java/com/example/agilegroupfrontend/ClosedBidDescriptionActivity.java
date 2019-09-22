package com.example.agilegroupfrontend;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.UpdateClosedBidBLL;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;

import auctionsystemapi.AuctionSystemAPI;

import model.Date;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import url.Url;

public class ClosedBidDescriptionActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private Button btnCreateClosedAuction;
    private ImageView ivDesClosedBidProfile;
    private TextView tvDesClosedBidTitle,etDesClosedBidEndingDate, etDesClosedBidPrice, etDesClosedBidMaxPrice, tvDesClosedBidMarketValue, tvDesClosedBidCategory;
    int bidId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_bid_description);
        btnCreateClosedAuction = findViewById(R.id.btnCreateClosedAuction);
        ivDesClosedBidProfile = findViewById(R.id.ivDesClosedBidProfile);
        tvDesClosedBidTitle = findViewById(R.id.tvDesClosedBidTitle);
        etDesClosedBidPrice = findViewById(R.id.etDesClosedBidPrice);
        etDesClosedBidMaxPrice = findViewById(R.id.etDesClosedBidMaxPrice);
        tvDesClosedBidMarketValue = findViewById(R.id.tvDesClosedBidMarketValue);
        etDesClosedBidEndingDate = findViewById(R.id.etDesClosedBidEndingDate);
        tvDesClosedBidCategory = findViewById(R.id.tvDesClosedBidCategory);
        btnCreateClosedAuction = findViewById(R.id.btnCreateClosedAuction);

        etDesClosedBidEndingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        StrictMode();
        URL url = null;
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            ivDesClosedBidProfile.setImageResource(bundle.getInt("bidImage"));
            try {
                url = new URL("http://10.0.2.2:3000/uploads/" + bundle.getString("bidImage"));
                ivDesClosedBidProfile.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (IOException e) {
                e.printStackTrace();
            }


            tvDesClosedBidTitle.setText(bundle.getString("bidTitle"));
            etDesClosedBidPrice.setText(String.valueOf(bundle.getInt("bidPrice")));
            etDesClosedBidMaxPrice.setText(String.valueOf(bundle.getInt("maxPrice")));
            tvDesClosedBidMarketValue.setText(String.valueOf(bundle.getInt("marketValue")));
            tvDesClosedBidCategory.setText(bundle.getString("category"));
            String bid_Id = String.valueOf(bundle.getInt("bidId"));
            bidId = Integer.parseInt(bid_Id);
            Toast.makeText(ClosedBidDescriptionActivity.this, "Bid Id: " + bidId, Toast.LENGTH_LONG).show();
        }
        btnCreateClosedAuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartYourBid();
            }
        });
    }

    private void StartYourBid() {
        String endingDate = etDesClosedBidEndingDate.getText().toString();
        int Bid_id =bidId;

        Date date = new Date(endingDate);

        UpdateClosedBidBLL updateClosedBidBLL  = new UpdateClosedBidBLL(Bid_id, date);

        if (updateClosedBidBLL.checkUpdateClosedBid()){
            Toast.makeText(ClosedBidDescriptionActivity.this, "Successfully updated your bid",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ClosedBidDescriptionActivity.this,ClosedBidsActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(ClosedBidDescriptionActivity.this,"Failed",Toast.LENGTH_LONG).show();

        }


    }

    private void loadDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,this,year, month,day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-10000);
        datePickerDialog.getDatePicker().setMaxDate((System.currentTimeMillis()-1000)+7*24*60*60*1000);
        datePickerDialog.show();
    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String stringMonth = convertToMonth(month);
        String date =  year  + "-" + stringMonth + "-" + dayOfMonth;
        etDesClosedBidEndingDate.setText(date);
    }
    private String convertToMonth(int month){
        String textMonth="";
        switch (month){
            case 0:
                textMonth = "01";
                break;
            case 1:
                textMonth = "02";
                break;
            case 2:
                textMonth = "03";
                break;
            case 3:
                textMonth = "04";
                break;
            case 4:
                textMonth = "05";
                break;
            case 5:
                textMonth = "06";
                break;
            case 6:
                textMonth = "07";
                break;
            case 7:
                textMonth= "08";
                break;
            case 8:
                textMonth = "09";
                break;
            case 9:
                textMonth = "10";
                break;
            case 10:
                textMonth = "11";
                break;
            case 11:
                textMonth = "12";
                break;
        }
        return textMonth;

    }
}

