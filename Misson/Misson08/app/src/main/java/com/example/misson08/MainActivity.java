package com.example.misson08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idInput;
    EditText passwordInput;

    static final String ADMIN_ID = "jhjh";
    static final String ADMIN_password = "1234";

    public static final int REQUEST_CODE_MENU = 101;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String action = bundle.getString("Action");

                Toast.makeText(getApplicationContext(), "Request CODE : " + requestCode + "\n받은 데이터 : "  + action, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idInput = findViewById(R.id.idInput);
        passwordInput = findViewById(R.id.passwordInput);

        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((idInput.getText().toString().equals(null)) || (passwordInput.getText().toString().equals(null))) {
                    Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    if (idInput.getText().toString().equals(ADMIN_ID)) {
                        if (passwordInput.getText().toString().equals(ADMIN_password)) {
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivityForResult(intent, REQUEST_CODE_MENU);
                        } else {
                            Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}