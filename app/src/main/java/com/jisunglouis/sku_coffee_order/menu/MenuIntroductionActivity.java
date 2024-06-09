package com.jisunglouis.sku_coffee_order.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jisunglouis.sku_coffee_order.R;

public class MenuIntroductionActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_introduction);
    }

    public void menuintroduction_backward(View v) {
        Intent intent = new Intent(MenuIntroductionActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
