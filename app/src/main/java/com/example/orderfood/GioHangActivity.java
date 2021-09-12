package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GioHangActivity extends AppCompatActivity {
    ListView lvFoodOder;

    List<Food> foodList;
    AdapterFood adapterFood;
    AdapterGioHang adapterGioHang;
    ImageButton imgBack;
    TextView tvPrice1;
    int Total_Price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        lvFoodOder = findViewById(R.id.lvOrder);
        tvPrice1 = findViewById(R.id.tvPrice1);
        imgBack = findViewById(R.id.btnBack);

        foodList = new ArrayList<>();

        Intent intent = this.getIntent();
        ArrayList<String> name = intent.getStringArrayListExtra("name");
        ArrayList<Integer> sl = intent.getIntegerArrayListExtra("soluong");

        for (int i = 0; i < name.size(); i++) {
            foodList.add(new Food(name.get(i), sl.get(i)));
            Total_Price += sl.get(i) * 10;
        }
        adapterGioHang = new AdapterGioHang(foodList);
        lvFoodOder.setAdapter(adapterGioHang);
        tvPrice1.setText(Total_Price + "$");
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}