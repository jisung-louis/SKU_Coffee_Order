package com.jisunglouis.sku_coffee_order;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private TextView remainingPoints;
    private EditText pointsInput;
    private Button usePointsButton, continuePaymentButton;
    private CheckBox agreementCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);

        remainingPoints = findViewById(R.id.payment_remaining_point);
        pointsInput = findViewById(R.id.payment_points_input);
        usePointsButton = findViewById(R.id.payment_points_button);
        continuePaymentButton = findViewById(R.id.payment_btn_continue_payment);
        agreementCheckBox = findViewById(R.id.payment_check_box_agreement);

        usePointsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPointsUsagePopup();
            }
        });

        continuePaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (agreementCheckBox.isChecked()) {
                    goToNextPage();
                } else {
                    Toast.makeText(PaymentActivity.this, "모든 사항에 동의해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 커피 이름을 받아와서 텍스트뷰에 설정
        String selectedCoffee = getIntent().getStringExtra("selectedCoffee");
        updateCoffeeInformation(selectedCoffee);
    }

    private void showPointsUsagePopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("포인트를 사용하시겠습니까?")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 포인트 사용 로직 구현
                        Toast.makeText(PaymentActivity.this, "포인트가 사용되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    private void goToNextPage() {
        Intent intent = new Intent(PaymentActivity.this, CheckoutActivity.class);
        startActivity(intent);
    }

    private void updateCoffeeInformation(String coffeeName) {
        TextView coffeeNameTextView = findViewById(R.id.payment_coffee_name);
        coffeeNameTextView.setText(coffeeName);
    }
}