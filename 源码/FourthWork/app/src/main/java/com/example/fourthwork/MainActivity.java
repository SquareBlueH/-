package com.example.fourthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private Button sure;
    private RadioButton choose1,choose2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sure=findViewById(R.id.sure_s);
        choose1=findViewById(R.id.choose1_c);
        choose2=findViewById(R.id.choose2_h);
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();

                if (choose1.isChecked()){
                    intent.setClass(MainActivity.this,SkbActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                else if (choose2.isChecked()){
                    intent.setClass(MainActivity.this,ImgActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}