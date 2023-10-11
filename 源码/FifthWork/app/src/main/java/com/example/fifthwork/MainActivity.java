package com.example.fifthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private Button sure;
    private RadioButton lna,tba,fra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sure=findViewById(R.id.sure_s);
        lna=findViewById(R.id.lna_l);
        tba=findViewById(R.id.tba_t);
        fra=findViewById(R.id.fra_f);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();

                if (lna.isChecked()){
                    intent.setClass(MainActivity.this,LNActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (tba.isChecked()){
                    intent.setClass(MainActivity.this,TBActivity.class);
                    MainActivity.this.startActivity(intent);
                }
               else  if (fra.isChecked()){
                    intent.setClass(MainActivity.this,FRActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}