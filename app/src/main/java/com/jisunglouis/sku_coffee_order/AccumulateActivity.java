package com.jisunglouis.sku_coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AccumulateActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_accumulate);
    }

    public void menuaccumulate_backward(View v) {
        Intent intent = new Intent(AccumulateActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}

