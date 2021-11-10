package com.oslac.agecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import java.util.Timer;
import java.util.TimerTask;

import static com.oslac.agecalculator.MainActivity2.EXTRA_DAY;
import static com.oslac.agecalculator.MainActivity2.EXTRA_MONTH;
import static com.oslac.agecalculator.MainActivity2.EXTRA_YEAR;

public class progressBar extends AppCompatActivity {
    public static final String EXTRA_DAY1 = "com.oslac.agecalculator.extra_day1";
    public static final String EXTRA_MONTH1 = "com.oslac.agecalculator.extra_month2";
    public static final String EXTRA_YEAR1 = "com.oslac.agecalculator.extra_year3";
    int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(progress);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                progress++;
                progressBar.setProgress(progress);
                if(progress==10)
                {
                    timer.cancel();
                    Intent intent = getIntent();
                    int date = intent.getIntExtra(EXTRA_DAY,0);
                    int month = intent.getIntExtra(EXTRA_MONTH,0);
                    int year = intent.getIntExtra(EXTRA_YEAR,0);
                    Intent intent1 = new Intent(progressBar.this,Result.class);
                    intent1.putExtra(EXTRA_DAY1,date);
                    intent1.putExtra(EXTRA_MONTH1,month);
                    intent1.putExtra(EXTRA_YEAR1,year);
                    startActivity(intent1);
                    finish();
                }
            }
        },0,50);
    }
}