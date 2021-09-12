package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {
    TextView tvPrice;
    TextView tvSL;
    Button btnOrder;
    ImageButton imgGioHang;


    ListView lvFood;
    Food food0, food1, food2, food3, food4, food5;
    List<Food> foods;
    AdapterFood adapterFood;

    int count = 0;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        tvPrice = findViewById(R.id.tvPrice);
        tvSL = findViewById(R.id.tvSL);
        btnOrder = findViewById(R.id.btnOder);
        imgGioHang = findViewById(R.id.imgGioHang);
        lvFood=findViewById(R.id.lvFood);
        food0 = new Food("Pizza Panda", 0);
        food1 = new Food("KFC Super", 0);
        food2 = new Food("Bread Eggs", 0);
        food3 = new Food("Coca Cola", 0);
        food4 = new Food("Chicken super", 0);
        food5 = new Food("Cup Cake", 0);

        foods=new ArrayList<>();
        foods.add(food0);
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);
        foods.add(food5);
        adapterFood = new AdapterFood(foods);
        lvFood.setAdapter(adapterFood);
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int positions = i;
                count += 1;
                tvSL.setText(count + "");
                price += 10;
                tvPrice.setText(price + "$");
                Food newFood = new Food(foods.get(i).getName(), foods.get(positions).getSl() + 1);
                foods.set(positions, newFood);
            }
        });
        imgGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(getBaseContext(), GioHangActivity.class);

                ArrayList<String> listFoodOrder = new ArrayList<>();
                ArrayList<Integer> listSoLuong = new ArrayList<>();
                for (Food food : foods) {
                    if (food.getSl() > 0) {
                        listFoodOrder.add(food.getName());
                        listSoLuong.add(food.getSl());
                    }
                }
                intentAdd.putStringArrayListExtra("name", listFoodOrder);
                intentAdd.putIntegerArrayListExtra("soluong", listSoLuong);
                startActivity(intentAdd);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Thank you! Your order is sent to restaurant",Toast.LENGTH_LONG);
                tvSL.setText("0");
                tvPrice.setText("0");
            }
        });
    }
}