package com.jisunglouis.sku_coffee_order.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jisunglouis.sku_coffee_order.R;

public class FindcafeActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_findcafe);
    }

    public void menufindcafe_backward(View v) {
        Intent intent = new Intent(FindcafeActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
