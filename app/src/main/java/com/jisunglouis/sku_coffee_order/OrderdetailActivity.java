package com.jisunglouis.sku_coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderdetailActivity extends AppCompatActivity {

    private RadioGroup radioGroup_size,radioGroup_iceorhot;
    private TextView coffeeName, price;
    private ImageView coffeeImage;
    private int counter = 1;
    private TextView count;
    private Button b_minus;
    private Button b_plus;
    private int coffeePrice;
    private int currentPrice;
    private boolean isIce=true;
    private int isMedium=0; // -1 = small, 0 = medium, 1 = large(tall)

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

        radioGroup_size = findViewById(R.id.radiogroup_size);
        radioGroup_iceorhot = findViewById(R.id.radiogroup_iceorhot);
        price = findViewById(R.id.price);
        count = findViewById(R.id.count);
        b_plus = findViewById(R.id.b_plus);
        b_minus = findViewById(R.id.b_minus);

        coffeeName = findViewById(R.id.coffeeName);
        coffeeName.setText(getIntent().getStringExtra("coffeeName"));
        coffeeImage = findViewById(R.id.coffeeImage);
        coffeeImage.setImageResource(getIntent().getIntExtra("coffeeImage",R.drawable.home_bottombar_coffee));
        coffeePrice=Integer.parseInt(getIntent().getStringExtra("coffeePrice"));
        price.setText("Price : "+coffeePrice+"원");

        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                count.setText(String.valueOf(counter));
                if(currentPrice>0){
                    String priceText = "Price : "+currentPrice*counter+"원";
                    price.setText(priceText);
                }
            }
        });

        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter>1) {
                    counter--;
                    count.setText(String.valueOf(counter));
                    if(currentPrice>0){
                        String priceText = "Price : "+currentPrice*counter+"원";
                        price.setText(priceText);
                    }
                }
            }
        });

        radioGroup_size.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.small) {
                    currentPrice = coffeePrice - 400;
                    isMedium=-1;
                }  else if (checkedId == R.id.large) {
                    currentPrice = coffeePrice + 1400;
                    isMedium=1;
                } else if (checkedId ==R.id.medium){
                    currentPrice = coffeePrice;
                    isMedium=0;
                }
                String priceText = "Price : "+currentPrice*counter+"원";
                price.setText(priceText);
            }
        });

        radioGroup_iceorhot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.ice) {
                    isIce=true;
                }  else if (checkedId == R.id.hot) {
                    isIce=false;
                }
            }
        });

    }

    public void order_detail_backward(View V) {
        Intent intent = new Intent(OrderdetailActivity.this, OrderActivity.class);
        startActivity(intent);
    }

    public void b_order(View v) {
        Intent intent = new Intent(OrderdetailActivity.this, PaymentActivity.class);
        intent.putExtra("coffeeImage",getIntent().getIntExtra("coffeeImage",R.drawable.home_bottombar_coffee));
        intent.putExtra("coffeeName",getIntent().getStringExtra("coffeeName"));
        intent.putExtra("iceOrHot",isIce);
        intent.putExtra("isMedium",isMedium);
        intent.putExtra("coffeeCount",counter);
        intent.putExtra("coffeePrice",currentPrice*counter);
        startActivity(intent);
    }
}
