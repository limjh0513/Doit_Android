package com.example.misson07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button userBtn = findViewById(R.id.userBtn);
        Button salesBtn = findViewById(R.id.salesBtn);
        Button productBtn = findViewById(R.id.productBtn);

        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("from", "고객 관리");
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        salesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("from", "매출 관리");
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        productBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("from", "상품 관리");
                setResult(RESULT_OK, intent);

                finish();
            }
        });

    }
}