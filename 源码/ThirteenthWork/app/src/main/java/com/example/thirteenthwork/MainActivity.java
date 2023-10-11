package com.example.thirteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private RadioButton NA,BA;
    private Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NA = findViewById(R.id.NA);
        BA = findViewById(R.id.BA);
        sure = findViewById(R.id.sure_s);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (NA.isChecked()){
                    intent.setClass(MainActivity.this,NActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (BA.isChecked()){
                    intent.setClass(MainActivity.this,BActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}