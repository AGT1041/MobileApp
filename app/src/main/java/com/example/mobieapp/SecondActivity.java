package com.example.mobieapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView userName,age;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userName=findViewById(R.id.loginText);
        age=findViewById(R.id.age);
        back=findViewById(R.id.button);
        String dUserName=getIntent().getStringExtra("usernames");
        int userAge=getIntent().getIntExtra("age",0);

        userName.setText("Hello "+dUserName);
        age.setText("age:"+userAge);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}