package com.example.samplerecyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonAdapter();

        adapter.addItem(new Person("김민수", "010-2343-5352"));
        adapter.addItem(new Person("김하늘", "010-3241-3251"));
        adapter.addItem(new Person("홍길동", "010-2347-5954"));
        adapter.addItem(new Person("고길동", "010-1352-5954"));
        adapter.addItem(new Person("신길동", "010-4633-5954"));
        adapter.addItem(new Person("신기덕", "010-4634-5954"));
        adapter.addItem(new Person("정기덕", "010-8645-5954"));
        adapter.addItem(new Person("정기석", "010-1353-5954"));
        adapter.addItem(new Person("김민수", "010-2343-5352"));
        adapter.addItem(new Person("김하늘", "010-3241-3251"));
        adapter.addItem(new Person("홍길동", "010-2347-5954"));
        adapter.addItem(new Person("고길동", "010-1352-5954"));
        adapter.addItem(new Person("신길동", "010-4633-5954"));
        adapter.addItem(new Person("신기덕", "010-4634-5954"));
        adapter.addItem(new Person("정기덕", "010-8645-5954"));
        adapter.addItem(new Person("정기석", "010-1353-5954"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "아이템 선택 됨 : " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}