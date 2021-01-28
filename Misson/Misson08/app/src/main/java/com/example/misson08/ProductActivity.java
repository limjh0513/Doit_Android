package com.example.misson08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class ProductActivity extends AppCompatActivity {

    public static final int REQUEST_MOVE_LOGIN = 302;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Button moveMenu = findViewById(R.id.moveMenu3);
        Button moveLogin = findViewById(R.id.moveLogin3);

        moveMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("move", "상품 관리에서 메인 메뉴로");
                setResult(RESULT_OK, intent);

                finish();
            }
        });


        moveLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(getApplicationContext(), "로그인 화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                startActivityForResult(intent, REQUEST_MOVE_LOGIN);
            }
        });
    }
}