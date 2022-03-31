package com.example.userregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("han", "ShowActivity.onCreate()");
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        String sex = intent.getStringExtra("sex");
        String hobby = intent.getStringExtra("hobby");
        String city = intent.getStringExtra("city");
        TextView tv_username=findViewById(R.id.tv_username);
        TextView tv_password=findViewById(R.id.tv_password);
        TextView tv_sex=findViewById(R.id.tv_sex);
        TextView tv_hobby=findViewById(R.id.tv_hobby);
        TextView tv_city=findViewById(R.id.tv_city);
        tv_username.setText(username);
        tv_password.setText(password);
        tv_sex.setText(sex);
        tv_hobby.setText(hobby);
        tv_city.setText(city);

        Button close = findViewById(R.id.bt_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
    @Override
    protected void onStart() {
        Log.e("han", "ShowActivity.onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("han", "ShowActivity.onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("han", "ShowActivity.onPause: ()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("han", "ShowActivity.onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("han", "ShowActivity.onDestroy()");
    }
}