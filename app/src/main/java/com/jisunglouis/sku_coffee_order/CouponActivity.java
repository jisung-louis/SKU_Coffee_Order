package com.jisunglouis.sku_coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CouponActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_coupon);
    }

    public void menucoupon_backward(View v) {
        Intent intent = new Intent(CouponActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
