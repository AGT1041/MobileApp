package com.example.mobieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userText;
    private EditText emailText;
    Button signUp;
    boolean isNameValid, isEmailValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userText=findViewById(R.id.editUser);
        emailText=findViewById(R.id.editTextEmail);
        signUp=findViewById(R.id.regester);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SetValidation(emailText)==true) {
                    String username = userText.getText().toString();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("usernames", username);
                    startActivity(intent);
                }
            }
        });
    }
    public boolean SetValidation(EditText emailText) {
        String emailinput = emailText.getText().toString();
        if (!emailinput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()) {
            Toast.makeText(this, "Email is Valiade", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(this,"Invalied email",Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}