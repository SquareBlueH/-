package com.example.sevework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton touch,gestures;
    private Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        touch=findViewById(R.id.TouchActivity_t);
        gestures=findViewById(R.id.GesturesActivity_g);
        sure=findViewById(R.id.sure_s);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();

                if(touch.isChecked()){
                    intent.setClass(MainActivity.this, TouchActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if(gestures.isChecked()){
                    intent.setClass(MainActivity.this, GesturesActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}