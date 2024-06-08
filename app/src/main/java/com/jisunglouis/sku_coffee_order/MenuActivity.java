package com.jisunglouis.sku_coffee_order;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
    }

    public void x_button(View v) {
        Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void menuintroduce(View v) {
        Intent intent = new Intent(MenuActivity.this, MenuIntroductionActivity.class);
        startActivity(intent);
    }

    public void accumulate(View v) {
        Intent intent = new Intent(MenuActivity.this, AccumulateActivity.class);
        startActivity(intent);
    }

    public void coupon(View v) {
        Intent intent = new Intent(MenuActivity.this, CouponActivity.class);
        startActivity(intent);
    }

    public void order(View v) {
        Intent intent = new Intent(MenuActivity.this, OrderActivity.class);
        startActivity(intent);
    }

    public void orderhistory(View v) {
        Intent intent = new Intent(MenuActivity.this, OrderhistoryActivity.class);
        startActivity(intent);
    }

    public void prepaidcard(View v) {
        Intent intent = new Intent(MenuActivity.this, PrepaidActivity.class);
        startActivity(intent);
    }

    public void mymenu(View v) {
        Intent intent = new Intent(MenuActivity.this, MymenuActivity.class);
        startActivity(intent);
    }

    public void findcafe(View v) {
        Intent intent = new Intent(MenuActivity.this, FindcafeActivity.class);
        startActivity(intent);
    }

    public void news(View v) {
        Intent intent = new Intent(MenuActivity.this, NewsActivity.class);
        startActivity(intent);
    }

    public void servicecenter(View v) {
        Intent intent = new Intent(MenuActivity.this, ServicecenterActivity.class);
        startActivity(intent);
    }

    public void naver(View v) {
        String naverUrl = "https://www.naver.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(naverUrl));
        startActivity(intent);
    }

    public void facebook(View v) {
        String facebookUrl = "https://www.facebook.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(facebookUrl));
        startActivity(intent);
    }

    public void instagram(View v) {
        String instagramUrl = "https://www.instagram.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(instagramUrl));
        startActivity(intent);
    }
}
