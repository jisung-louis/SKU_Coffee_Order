package com.jisunglouis.sku_coffee_order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    private ImageView home_menu;
    private ImageView home_barcode;
    private ImageView home_notification;
    private ImageView home_order;
    private ImageView home_payment;
    private ImageView home_coupon;

    private ImageView home_map;

    private ImageView home_myinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    public void home_menu(View v) {

    }
}