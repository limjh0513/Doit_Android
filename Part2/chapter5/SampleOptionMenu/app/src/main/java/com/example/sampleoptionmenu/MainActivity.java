package com.example.sampleoptionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int curId = item.getItemId();

        switch (curId) {
            case R.id.menu_refresh: {
                Toast.makeText(getApplicationContext(), "새로고침 매뉴 선택", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_search: {
                Toast.makeText(getApplicationContext(), "검색 매뉴 선택", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_setting: {
                Toast.makeText(getApplicationContext(), "설정 매뉴 선택", Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}