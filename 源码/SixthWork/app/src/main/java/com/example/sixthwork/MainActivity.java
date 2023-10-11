package com.example.sixthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private Button sure;
    private RadioButton opm,ctm,pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sure=findViewById(R.id.sure_s);
        opm=findViewById(R.id.OPMENUActivity);
        ctm=findViewById(R.id.CTMENUActivity);
        pop=findViewById(R.id.POPActivity);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();

                if(opm.isChecked()){
                    intent.setClass(MainActivity.this,OPMENUActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if(ctm.isChecked()){
                    intent.setClass(MainActivity.this,CTMENUActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if(pop.isChecked()){
                    intent.setClass(MainActivity.this,POPActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}