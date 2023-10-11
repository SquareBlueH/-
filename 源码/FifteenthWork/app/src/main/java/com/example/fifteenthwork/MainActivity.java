package com.example.fifteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private RadioButton sha,isa,esa;
    private Button sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sha=findViewById(R.id.sha);
        isa=findViewById(R.id.isa);
        esa=findViewById(R.id.esa);
        sure=findViewById(R.id.sure_s);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (sha.isChecked()){
                    intent.setClass(MainActivity.this,SHActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (isa.isChecked()){
                    intent.setClass(MainActivity.this,ISActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (esa.isChecked()){
                    intent.setClass(MainActivity.this,ESActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}