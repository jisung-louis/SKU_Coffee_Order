package com.jisunglouis.sku_coffee_order.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.jisunglouis.sku_coffee_order.R;

public class BarcodeActivity extends AppCompatActivity {

    private ImageView barcode;
    private ImageView close_barcode;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode_activity);
    }

    public void close_barcode (View v) {
        Intent intent = new Intent(BarcodeActivity.this, HomeActivity.class);
        startActivity(intent);
    }

}
