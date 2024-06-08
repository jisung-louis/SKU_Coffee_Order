package com.jisunglouis.sku_coffee_order;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jisunglouis.sku_coffee_order.OrderActivity_RecyclerViewAdapter;

public class OrderActivity extends AppCompatActivity implements OrderActivity_RecyclerViewAdapter.ItemClickListener {
    OrderActivity_RecyclerViewAdapter category_adapter, list_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);

        String[] data = {
                "NEW",
                "커피",
                "콜드브루",
                "논 커피",
                "티/에이드",
                "프라페/블렌디드",
                "병음료"
        };

        String[] data2 = {
                "Latte",
                "Espresso",
                "Americano",
                "Cappuccino",
                "Macchiato",
                "Mocha",
                "Affogato"
        };

        RecyclerView recyclerView1 = findViewById(R.id.rview); // 커피 카테고리
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        category_adapter = new OrderActivity_RecyclerViewAdapter(this, data, OrderActivity_RecyclerViewAdapter.VIEW_TYPE_1);
        category_adapter.setClickListener(this);
        recyclerView1.setAdapter(category_adapter);

        int columns = 3; // 커피 카테고리 별 커피 리스트
        RecyclerView recyclerView2 = findViewById(R.id.rview2);
        recyclerView2.setLayoutManager(new GridLayoutManager(this, columns));
        list_adapter = new OrderActivity_RecyclerViewAdapter(this, data2, OrderActivity_RecyclerViewAdapter.VIEW_TYPE_2);
        list_adapter.setClickListener(this);
        recyclerView2.setAdapter(list_adapter);
    }

    @Override
    public void onItemClick(View view, int position, int viewType) {
        if (viewType == OrderActivity_RecyclerViewAdapter.VIEW_TYPE_1) {
            category_adapter.setSelectedPosition(position);
        }
    }
}