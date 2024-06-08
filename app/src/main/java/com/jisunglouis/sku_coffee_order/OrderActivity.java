package com.jisunglouis.sku_coffee_order;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class OrderActivity extends AppCompatActivity implements OrderActivity_RecyclerViewAdapter.ItemClickListener {
    OrderActivity_RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);

        String[] data = new String[100];
        for(int i=1;i<=100;i++){
            data[i-1]="friend #"+1;
        }
        RecyclerView recyclerView = findViewById(R.id.rview);
    }
}
