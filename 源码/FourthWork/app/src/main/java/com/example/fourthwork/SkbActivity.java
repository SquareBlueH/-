package com.example.fourthwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SkbActivity extends AppCompatActivity {

    private TextView textView,TextView2;
    private ConstraintLayout cl;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skb);


        textView=findViewById(R.id.textView);
        cl=findViewById(R.id.cl_c);
        seekBar=findViewById(R.id.seekBar);
        TextView2=findViewById(R.id.textView2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cl.setBackgroundColor(Color.rgb(progress,progress,progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SkbActivity.this,"当前亮度值："+seekBar.getProgress(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}