package com.example.misson09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    UserInput userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = new UserInput();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, userInput).commit();
    }
}