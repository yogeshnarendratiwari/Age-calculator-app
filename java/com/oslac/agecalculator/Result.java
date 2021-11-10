package com.oslac.agecalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;



import static com.oslac.agecalculator.progressBar.EXTRA_DAY1;
import static com.oslac.agecalculator.progressBar.EXTRA_MONTH1;
import static com.oslac.agecalculator.progressBar.EXTRA_YEAR1;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
       int date = intent.getIntExtra(EXTRA_DAY1,0);
       int month = intent.getIntExtra(EXTRA_MONTH1,0);
        int year = intent.getIntExtra(EXTRA_YEAR1,0);
        TextView age = findViewById(R.id.age);
        String Age = year+" years : "+month+" months : "+date+" days";
        age.setText(Age);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Result.this, "Thank You For Rating Our App :)", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Result.this,MainActivity2.class));
                finish();
            }
        });

    }
}