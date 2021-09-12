package com.example.orderfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterFood extends BaseAdapter {
    List<Food> foodList;

    public AdapterFood(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

       View v = layoutInflater.inflate(R.layout.item_food,viewGroup , false);

        TextView tvName = v.findViewById(R.id.tvName);

        Food food = foodList.get(i);

        tvName.setText(food.getName());
        return v;
    }
}
