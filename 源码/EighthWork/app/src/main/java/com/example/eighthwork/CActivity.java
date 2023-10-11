package com.example.eighthwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class CActivity extends AppCompatActivity {

    private TextView ctv;
    private CalendarView cld;
    private int dday,mmonth,yyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        ctv=findViewById(R.id.ctv_c);
        cld=findViewById(R.id.cld_c);

        cld.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                yyear=year;
                mmonth=month;
                dday=dayOfMonth;

                AlertDialog.Builder dialog = new AlertDialog.Builder(CActivity.this);
                dialog.setTitle("请确定选中\n"+yyear+"-"+mmonth+"-"+dday);
                dialog.setMessage("请再次确定这一天的好日子");

                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ctv.setText("选择"+yyear+"-"+mmonth+"-"+dday+"这一天祝你愉快！");
                    }
                });

                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ctv.setText("当天不宜时候");
                    }
                });
                dialog.create();
                dialog.show();
            }
        });
    }
}