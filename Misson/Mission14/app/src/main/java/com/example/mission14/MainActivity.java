package com.example.mission14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemAdapter();
        addItemList();
        addItemList();
        addItemList();
        addItemList();

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ItemAdapter.ViewHolder viewHolder, View view, int position) {

                ItemList item = (ItemList) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택된 제품 : " + item.getItemName() + "\n가격 : " + item.getItemPrice() +
                        "\n상품설명 : " + item.getItemExam(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addItemList() {
        adapter.addItem(new ItemList(R.drawable.shose, "FILA 신발", "60,000원", "FILA의 어글리 슈즈"));
        adapter.addItem(new ItemList(R.drawable.tee, "무지 티", "10,000원", "여러 색깔의 무지 티"));
        adapter.addItem(new ItemList(R.drawable.food, "외식 상품권", "50,000원", "어디서든 사용할 수 있는 외식 상품권"));
    }
}