package com.jisunglouis.sku_coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class OrderdetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);
    }

    public void order_detail_backward(View V) {
        Intent intent = new Intent(OrderdetailActivity.this, OrderActivity.class);
        startActivity(intent);
    }
}
