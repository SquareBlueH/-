package com.example.ninthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button sure1,sure2;
    private TextView data,time,status;
    private Switch sw;
    private int day,year,month,hour,minute;
    Calendar ca = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener onDateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            MainActivity.this.year=year;
            MainActivity.this.month=month;
            MainActivity.this.day=dayOfMonth;
            data.setText(year+"年"+(month+1)+"月"+dayOfMonth+"日");
        }
    };
    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            MainActivity.this.hour=hourOfDay;
            MainActivity.this.minute=minute;
            time.setText(hourOfDay+"时"+minute+"分");
        }
    };


    protected void setAlarm(){
        ca = Calendar.getInstance();
        ca.set(year,month,day,hour,minute,0);

        Intent intent = new Intent(MainActivity.this,ALMActivity.class);

        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_IMMUTABLE);

        AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP,ca.getTimeInMillis(),pi);

        Toast.makeText(MainActivity.this,"闹钟已设置！",Toast.LENGTH_SHORT).show();
        status.setText("闹钟时间："+year+"年"+(month+1)+"月"+day+"日"+hour+"时"+minute+"分");
    }
    protected void cancelAlarm(){
        Intent intent = new Intent(MainActivity.this,ALMActivity.class);

        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_IMMUTABLE);

        AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
        am.cancel(pi);

        Toast.makeText(MainActivity.this,"闹钟已取消！",Toast.LENGTH_SHORT).show();
        status.setText("NOT SET");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sure1=findViewById(R.id.sure1_s);
        sure2=findViewById(R.id.sure2_s);
        sw=findViewById(R.id.switch_s);
        data=findViewById(R.id.data_d);
        time=findViewById(R.id.time_t);
        status=findViewById(R.id.status_s);

        year=ca.get(Calendar.YEAR);
        month=ca.get(Calendar.MONTH);
        day=ca.get(Calendar.DAY_OF_MONTH);
        hour=ca.get(Calendar.HOUR_OF_DAY);
        minute=ca.get(Calendar.MINUTE);

        sure1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this,onDateSetListener,year,month,day).show();
            }
        });
        sure2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this,onTimeSetListener,hour,minute,true).show();
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    setAlarm();
                }
                else {
                    cancelAlarm();
                }
            }
        });
    }
    @Override
    protected void onRestart() {
        data.setText("NOT SET");
        time.setText("NOT SET");
        status.setText("NOT SET");
        sw.setText("NOT SET");

        super.onRestart();
    }
}




























