package com.oslac.agecalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {
    private int date;
   private int month;
    private int year;
   public static final String EXTRA_DAY = "com.oslac.agecalculator.extra_day";
    public static final String EXTRA_MONTH = "com.oslac.agecalculator.extra_month";
    public static final String EXTRA_YEAR = "com.oslac.agecalculator.extra_year";
    Button submit;
    EditText BirthDate;
    EditText BirthMonth;
    EditText BirthYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LinearLayout linearLayout = findViewById(R.id.ll);
        submit=findViewById(R.id.submit);
        BirthDate=findViewById(R.id.bd);
        BirthMonth=findViewById(R.id.bm);
        BirthYear=findViewById(R.id.by);
        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(BirthYear.getText().toString().equals("")||BirthMonth.getText().toString().equals("")||BirthDate.getText().toString().equals("")||BirthYear.getText().toString().isEmpty()||BirthMonth.getText().toString().isEmpty()||BirthDate.getText().toString().isEmpty())
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity2.this)
                            .setMessage("Kindly Enter All Specified Fields")
                            .setPositiveButton("Got it",null)
                            .create();
                    alertDialog.show();

                }
              else{
                  int birth_date = Integer.parseInt(BirthDate.getText().toString());
                  int birth_month =Integer.parseInt(BirthMonth.getText().toString());
                  int birth_year =Integer.parseInt(BirthYear.getText().toString());
                  LocalDate localDate = LocalDate.now();
                 int present_date =localDate.getDayOfMonth();
                 int present_month=localDate.getMonthValue();
                 int present_year=localDate.getYear();

if(Error(birth_date,birth_month,1900,present_year,birth_year)){
                 if(present_year>birth_year){
                     if(present_month==birth_month){
                         if(birth_date==present_date)
                         {
                             year=present_year-birth_year;
                             month=0;
                             date=0;
                         }
                         else if(birth_date<present_date){
                             year=present_year-birth_year;
                             month=0;
                             date=present_date-birth_date;
                         }
                         else{
                               year=present_year-birth_year-1;
                             month=12+present_month-1-birth_month;
                            int k= DaysNumber(present_month-1,present_year);
                            date=k-birth_date+present_date+1;
                         }

                     }
                     else if(present_month>birth_month)
                     {
                         if(birth_date==present_date)
                         {
                             year=present_year-birth_year;
                             month=present_month-birth_month;
                             date=0;
                         }
                         else if(birth_date<present_date){
                             year=present_year-birth_year;
                             month=present_month-birth_month;
                             date=present_date-birth_date;
                         }
                         else{
                             year=present_year-birth_year;
                             month=present_month-birth_month-1;
                             int k=DaysNumber(present_month-1,present_year);
                             date=k-birth_date+1+present_date;
                         }
                     }
                     else{
                         if(birth_date==present_date)
                         {
                             year=present_year-birth_year-1;
                             month=12+present_month-birth_month;
                             date=0;
                         }
                         else if(birth_date<present_date){
                             year=present_year-birth_year-1;
                             month=12+present_month-birth_month;
                             date=present_date-birth_date;
                         }
                         else{
                             year=present_year-birth_year-1;
                             month=12+present_month-birth_month-1;
                             int k=DaysNumber(present_month-1,present_year);
                             date=k-birth_date+present_date+1;
                         }
                     }
                 }
           else
                 {

                   if(birth_month==present_month)
                   {
                       if(birth_date<=present_date)
                       {
                           date=present_date-birth_date;
                           month=present_month-birth_month;
                           year=present_year-birth_year;
                       }
                       else
                           Snackbar.make(linearLayout,"Kindly Enter Valid Details In The Specified Fields",Snackbar.LENGTH_SHORT).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE).show();
                   }
                   else if(birth_month<present_month)
                   {
                       if(birth_date==present_date)
                       {
                           date=present_date-birth_date;
                           month=present_month-birth_month;
                           year=present_year-birth_year;
                       }
                       else if(birth_date<present_date)
                       {
                           date=present_date-birth_date;
                           month=present_month-birth_month;
                           year=present_year-birth_year;
                       }
                       else
                       {   int k=DaysNumber(present_month-1,present_year);
                           date=k+present_date-birth_date+1;
                           month=present_month-birth_month-1;
                           year=present_year-birth_year;

                       }
                   }
                   else
                       Snackbar.make(linearLayout,"Kindly Enter Valid Details In The Specified Fields",Snackbar.LENGTH_SHORT).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE).show();



                 }
    Intent intent = new Intent(MainActivity2.this,progressBar.class);
    intent.putExtra(EXTRA_DAY,date);
    intent.putExtra(EXTRA_MONTH,month);
    intent.putExtra(EXTRA_YEAR,year);
    startActivity(intent);
    finish();


}
else
{
    Snackbar.make(linearLayout,"Kindly Enter Valid Details In The Specified Fields",Snackbar.LENGTH_SHORT).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE).show();
}



                 BirthDate.setText("");
                 BirthMonth.setText("");
                 BirthYear.setText("");

                }
            }
        });
    }

    public int DaysNumber(int month,int year){
        if(month==4||month==6||month==9||month==11)
            return 30;
        else if(month==2) {
            if(LeapYearCheck(year))
                return 29;
            else
                return 28;
        }
       else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            return 31;
       else
           return 0;
    }

    public boolean LeapYearCheck(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public boolean Error(int date,int month,int starting_year,int present_year,int year){
      if(year>=starting_year && year<=present_year){
          if(DaysNumber(month,present_year)==30 && date<31 && date>0)
              return true;
          else if(DaysNumber(month,present_year)==28 && date<29 && date>0)
              return true;
          else if(DaysNumber(month,present_year)==29 && date<30 && date>0)
              return true;
          else if(DaysNumber(month, present_year) == 31 && date < 32 && date > 0)
              return true;
          else
              return false;


      }
      else
          return false;
    }
}