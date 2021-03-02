package com.example.mission11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    TextView textView;

    @Override
    protected void onNewIntent(Intent intent) {

        processIntent(intent);

        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextInput);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyService.class);

                String input = editText.getText().toString();
                intent.putExtra("inputs", input);

                startService(intent);
            }
        });

        Intent getIntent = getIntent();
        processIntent(getIntent);

    }

    private void processIntent(Intent getIntent) {
        if(getIntent != null){
            String getText = getIntent.getStringExtra("inputText");

            textView.setText(getText);
        }
    }
}