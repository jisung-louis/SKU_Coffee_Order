package com.jisunglouis.sku_coffee_order.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jisunglouis.sku_coffee_order.R;
import com.jisunglouis.sku_coffee_order.home.HomeActivity;

public class OrderActivity extends AppCompatActivity implements OrderActivity_RecyclerViewAdapter.ItemClickListener {
    OrderActivity_RecyclerViewAdapter category_adapter, list_adapter;
    String[] data = {
            "커피",
            "콜드브루",
            "논 커피",
            "티/에이드",
            "프라페/블렌디드",
            "병음료"
    };

    String[][] data2 = {
            {"아메리카노", "아샷추 아이스티", "믹스커피"}, // 커피
            {"콜드브루", "콜드브루 라떼", "돌체 콜드브루 라떼"}, // 콜드브루
            {"초코 라떼", "고구마 라떼", "녹차 라떼"}, // 논 커피
            {"아이스티", "얼그레이티", "캐모마일티"}, // 티/에이드
            {"민트 초코 프라페", "피스타치오 아몬드 프라페","자바칩 프라페"}, // 프라페/블렌디드
            {"뽀로로(밀크)","뽀로로(딸기)","뽀로로(사과)"} // 병음료
    };
    String[][] data2_price = {
            {"1600", "3400", "3000"}, // 커피
            {"2300", "3000", "3500"}, // 콜드브루
            {"2900", "3400", "3300"}, // 논 커피
            {"3000", "3700", "3700"}, // 티/에이드
            {"4500", "4500","4500"}, // 프라페/블렌디드
            {"1500","1500","1500"} // 병음료
    };
    int[][] coffeeImages = {
            {R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee},
            {R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee},
            {R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee},
            {R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee},
            {R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee},
            {R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee,R.drawable.home_bottombar_coffee}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);



        RecyclerView recyclerView1 = findViewById(R.id.rview); // 커피 카테고리
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        category_adapter = new OrderActivity_RecyclerViewAdapter(this, data, OrderActivity_RecyclerViewAdapter.VIEW_TYPE_1);
        category_adapter.setClickListener(this);
        recyclerView1.setAdapter(category_adapter);

        int columns = 3; // 커피 카테고리 별 커피 리스트
        RecyclerView recyclerView2 = findViewById(R.id.rview2);
        recyclerView2.setLayoutManager(new GridLayoutManager(this, columns));
        list_adapter = new OrderActivity_RecyclerViewAdapter(this, data2[0], data2_price[0],coffeeImages[0],OrderActivity_RecyclerViewAdapter.VIEW_TYPE_2);
        list_adapter.setClickListener(this);
        recyclerView2.setAdapter(list_adapter);
    }
    int categoryPosition=0;
    @Override
    public void onItemClick(View view, int position, int viewType) {

        if (viewType == OrderActivity_RecyclerViewAdapter.VIEW_TYPE_1) {
            categoryPosition=position;
            category_adapter.setSelectedPosition(position);
            list_adapter.updateData(data2[position],data2_price[position],coffeeImages[position] );
        }
        else{
            Intent intent = new Intent(OrderActivity.this, OrderdetailActivity.class);
            intent.putExtra("categoryPosition",categoryPosition);
            intent.putExtra("coffeePosition",position);
            intent.putExtra("coffeeName",data2[categoryPosition][position]);
            intent.putExtra("coffeeImage",coffeeImages[categoryPosition][position]);
            intent.putExtra("coffeePrice",data2_price[categoryPosition][position]);
            startActivity(intent);
        }
    }
    public void order_button_backward(View view){
        Intent intent = new Intent(OrderActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}