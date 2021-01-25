package com.example.misson04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    EditText Message;
    TextView showBytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Message = findViewById(R.id.message);
        showBytes = findViewById(R.id.showBytes);

        Button sendBtn = findViewById(R.id.sendBtn);
        Button cancelBtn = findViewById(R.id.cancelBtn);

        Message.setSingleLine(false);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "전송할 메세지 : " + Message.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                byte[] bytes = null;
                try {
                    bytes = s.toString().getBytes("KSC5601");
                    int length = bytes.length;
                    showBytes.setText(length + "/ 80 바이트");
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if (strBytes.length > 80) {
                        s.delete(s.length() - 2, s.length() - 1);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Message.addTextChangedListener(textWatcher);
    }
}