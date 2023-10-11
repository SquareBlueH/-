package com.example.sixteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
public class MainActivity extends AppCompatActivity {
    private RadioButton addActivity,aryActivity,mngActivity;
    private Button sure;
    private SitesDBHlp dbHlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addActivity = findViewById(R.id.ADDActivity);
        aryActivity = findViewById(R.id.QRYActivity);
        mngActivity = findViewById(R.id.MNGActivity);
        sure = findViewById(R.id.sure);

        if(dbHlp == null)
            dbHlp = new SitesDBHlp(this);
        dbHlp. fillDB();

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (addActivity.isChecked()){
                    intent.setClass(MainActivity.this,ADDActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (aryActivity.isChecked()){
                    intent.setClass(MainActivity.this,QRYActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (mngActivity.isChecked()){
                    intent.setClass(MainActivity.this,MNGActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}