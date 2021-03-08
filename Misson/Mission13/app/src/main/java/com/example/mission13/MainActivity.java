package com.example.mission13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editTextName;
    EditText editTextDate;
    EditText editTextPhone;
    Button button;
    TextView textView2;
    int userCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editTextName = findViewById(R.id.editTextName);
        editTextDate = findViewById(R.id.editTextDate);
        editTextPhone = findViewById(R.id.editTextPhone);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        UserAdapter adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String date = editTextDate.getText().toString();
                String phone = editTextPhone.getText().toString();

                adapter.addItem(new User(name, date, phone));
                userCnt++;
                textView2.setText(userCnt + "명");

                adapter.notifyDataSetChanged();
            }
        });

    }
}