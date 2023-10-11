package com.example.eighthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DActivity extends AppCompatActivity {
    private Button sure1,sure2;
    private TextView data,time;
    private int year,month,day,hour,minute;

    DatePickerDialog.OnDateSetListener onDateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            DActivity.this.year=year;
            DActivity.this.month=month;
            DActivity.this.day=dayOfMonth;
            data.setText(year+"年"+(month+1)+"月"+dayOfMonth+"日");
        }
    };
    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            DActivity.this.hour=hourOfDay;
            DActivity.this.minute=minute;
            time.setText(hourOfDay+"时"+minute+"分");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        sure1=findViewById(R.id.sure1_s);
        sure2=findViewById(R.id.sure2_s);
        data=findViewById(R.id.data_d);
        time=findViewById(R.id.time_t);

        Calendar ca = Calendar.getInstance();
        year = ca.get(Calendar.YEAR);
        month = ca.get(Calendar.MONTH);
        day = ca.get(Calendar.DAY_OF_MONTH);

        sure1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DActivity.this,onDateSetListener,year,month,day).show();
            }
        });
        sure2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(DActivity.this,onTimeSetListener,hour,minute,true).show();
                time.setText(hour+"时"+minute+"分");
            }
        });
    }
}