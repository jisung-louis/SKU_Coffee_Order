package com.jisunglouis.sku_coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PrepaidActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_prepaid);
    }

    public void menuprepaid_backward(View v) {
        Intent intent = new Intent(PrepaidActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
