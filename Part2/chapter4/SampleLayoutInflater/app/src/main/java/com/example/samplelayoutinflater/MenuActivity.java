package com.example.samplelayoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        container = findViewById(R.id.container);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); //인플레이터 객체 참조
                inflater.inflate(R.layout.sub1, container, true); //container에 sub1.xml을 레이아웃으로 설정
                CheckBox checkBox = container.findViewById(R.id.checkBox); // 부분 레이아웃이 container 객체에 설정되어 container객체에서 findViewById 사용
                checkBox.setText("로딩 되었어요.");
            }
        });
    }
}