package com.example.fifthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LNActivity extends AppCompatActivity {
    private Button adjust;
    private LinearLayout line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_n);

        adjust=findViewById(R.id.adjust_a);
        line=findViewById(R.id.line2);

        adjust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (line.getOrientation()==LinearLayout.VERTICAL){
                line.setOrientation(LinearLayout.HORIZONTAL);
                Toast.makeText(LNActivity.this,"当前为：纵向布局",Toast.LENGTH_SHORT).show();
                return;}
                else if (line.getOrientation()==LinearLayout.HORIZONTAL);{
                line.setOrientation(LinearLayout.VERTICAL);
                Toast.makeText(LNActivity.this,"当前为：横向布局",Toast.LENGTH_SHORT).show();
                return;}
            }
        });
    }
}