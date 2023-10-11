package com.example.tenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner_s);
        sure = findViewById(R.id.sure_s);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (spinner.getSelectedItemPosition()==0){
                    intent.setClass(MainActivity.this,SP1Activity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (spinner.getSelectedItemPosition()==1){
                    intent.setClass(MainActivity.this,SP2MActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });

    }
}