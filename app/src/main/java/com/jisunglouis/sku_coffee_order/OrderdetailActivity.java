package com.jisunglouis.sku_coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderdetailActivity extends AppCompatActivity {

    private RadioGroup radioGroup_size;
    private TextView price;
    private int counter = 1;
    private TextView count;
    private Button b_minus;
    private Button b_plus;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

        radioGroup_size = findViewById(R.id.radiogroup_size);
        price = findViewById(R.id.price);
        count = findViewById(R.id.count);
        b_plus = findViewById(R.id.b_plus);
        b_minus = findViewById(R.id.b_minus);

        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                count.setText(String.valueOf(counter));
            }
        });

        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                count.setText(String.valueOf(counter));
            }
        });

        radioGroup_size.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String priceText = "Price: ";
                if (checkedId == R.id.small) {
                    priceText += "1200원";
                } else if (checkedId == R.id.medium) {
                    priceText += "1600원";
                } else if (checkedId == R.id.large) {
                    priceText += "3000원";
                }
                price.setText(priceText);
            }
        });

    }

    public void order_detail_backward(View V) {
        Intent intent = new Intent(OrderdetailActivity.this, OrderActivity.class);
        startActivity(intent);
    }

    public void b_order(View v) {
        Intent intent = new Intent(OrderdetailActivity.this, PaymentActivity.class);
        startActivity(intent);
    }
}
