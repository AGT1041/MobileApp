package com.example.mobieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Calendar;

import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class MainActivity extends AppCompatActivity {
    private EditText userText;
    private EditText passWord;
    private EditText fullName;
    private EditText emailText;
    Button signUp;
    private Button mDatebtn;
    private TextView mDateText;
    boolean isNameValid, isEmailValid;
    boolean isAllFieldsChecked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userText=findViewById(R.id.editUser);
        emailText=findViewById(R.id.editTextEmail);
        fullName=findViewById(R.id.editTextName);
        passWord=findViewById(R.id.password);
        signUp=findViewById(R.id.regester);
        mDatebtn=findViewById(R.id.datePickerButton);
        mDateText=findViewById(R.id.datetText);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //isAllFieldsChecked=SetValidation();

                if(SetValidation()==true){
                    String username = userText.getText().toString();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("usernames", username);
                    startActivity(intent);
                }
            }
        });
        mDatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
    }
    public boolean SetValidation() {
        if (userText.length() <6) {
            userText.setError("Must have 6 charcters");
            return false;
        }
        if(fullName.length()<8){
            fullName.setError("Must have 8 charcters");
            return false;

        }
        String emailinput = emailText.getText().toString();
//String user=userText.getText().toString();
        if (emailinput.length()==0 && !Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()) {
            //Toast.makeText(this, "Email is Valiade", Toast.LENGTH_SHORT).show();
            emailText.setError("Email is inValiade");
            return false;
        }

         if (passWord.length() <7) {
            passWord.setError("Pawword must have 8 or more charcters");
            return false;
        }


        //} else if (Password.length() < 8) {
         //   Password.setError("Password must be minimum 8 characters");
         //   return false;
       // }

        // after all validation return true.
        return true;

    }
    private void openDatePicker (){
        Calendar  calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

         
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                mDateText.setText(dayOfMonth+"/"+month+"/"+year);
               // LocalDate today = LocalDate.now();
               // LocalDate birthday = LocalDate.of(YEAR, MONTH, DATE);
               // Period period = Period.between(birthday, today);



                //if(p.getYears()<2 ){
                //    mDateText.setError("Must be 18 Years or Older");
                //    return;
                //}

            }
        }, YEAR,MONTH,DATE);
        datePickerDialog.show();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }


}