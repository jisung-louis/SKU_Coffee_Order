package com.jisunglouis.sku_coffee_order.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jisunglouis.sku_coffee_order.order.OrderActivity;
import com.jisunglouis.sku_coffee_order.R;
import com.jisunglouis.sku_coffee_order.menu.MenuActivity;

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
        Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    public void home_barcode(View v) {
        Intent intent = new Intent(HomeActivity.this, BarcodeActivity.class);
        startActivity(intent);
    }

    public void home_order(View v) {
        Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
        startActivity(intent);
    }
}