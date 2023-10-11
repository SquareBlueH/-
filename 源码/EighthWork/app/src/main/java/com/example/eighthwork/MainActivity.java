package com.example.eighthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private RadioButton CA,DA;
    private Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CA=findViewById(R.id.CActivity_c);
        DA=findViewById(R.id.DActivity_d);
        sure=findViewById(R.id.sure_s);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (CA.isChecked()){
                    intent.setClass(MainActivity.this,CActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (DA.isChecked()){
                    intent.setClass(MainActivity.this,DActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}