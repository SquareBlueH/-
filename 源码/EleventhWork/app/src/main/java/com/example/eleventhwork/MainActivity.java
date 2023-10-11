package com.example.eleventhwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private RadioButton GDA,RCV,WBA;
    private Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GDA=findViewById(R.id.GDA_g);
        RCV=findViewById(R.id.RCV_r);
        WBA=findViewById(R.id.WBA_e);
        sure=findViewById(R.id.sure_s);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (GDA.isChecked()){
                    intent.setClass(MainActivity.this,GDActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (RCV.isChecked()){
                    intent.setClass(MainActivity.this,RCVActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (WBA.isChecked()){
                    intent.setClass(MainActivity.this,WBVActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}