package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogIn;
    EditText edUserName, edPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogIn = findViewById(R.id.btnLogin);
        edPassWord = findViewById(R.id.editPassWord);
        edUserName = findViewById(R.id.editUserName);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edUserName.getText().toString().length() != 0 && edPassWord.getText().toString().length() != 0) {
                    if (edUserName.getText().toString().equals("xuanhung") && edPassWord.getText().toString().equals("hung2302")) {
                        Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Sai mật khẩu hoặc tên đăng nhập", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập thông tin", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}