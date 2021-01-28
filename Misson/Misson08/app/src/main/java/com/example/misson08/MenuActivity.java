package com.example.misson08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public static final int REQUEST_USER = 201;
    public static final int REQUEST_SALES = 202;
    public static final int REQUEST_PRODUCT = 203;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_USER) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String move = bundle.getString("move");

                Toast.makeText(getApplicationContext(), "Request CODE : " + requestCode + "\n받은 데이터 : " + move, Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_SALES) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String move = bundle.getString("move");

                Toast.makeText(getApplicationContext(), "Request CODE : " + requestCode + "\n받은 데이터 : " + move, Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_PRODUCT) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String move = bundle.getString("move");

                Toast.makeText(getApplicationContext(), "Request CODE : " + requestCode + "\n받은 데이터 : " + move, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();

        Button userBtn = findViewById(R.id.userBtn);
        Button salesBtn = findViewById(R.id.salesBtn);
        Button productBtn = findViewById(R.id.productBtn);

        Button backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Action", "돌아가기");
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("Action", "고객 관리");

                startActivityForResult(intent, REQUEST_USER);
            }
        });

        salesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalesActivity.class);
                intent.putExtra("Action", "매출 관리");

                startActivityForResult(intent, REQUEST_SALES);
            }
        });

        productBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                intent.putExtra("Action", "상품 관리");

                startActivityForResult(intent, REQUEST_PRODUCT);
            }
        });

    }
}