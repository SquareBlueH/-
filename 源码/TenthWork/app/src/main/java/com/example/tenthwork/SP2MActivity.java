package com.example.tenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SP2MActivity extends AppCompatActivity {
    private Spinner spinner2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p2_m);

        textView=findViewById(R.id.tv2);
        spinner2=findViewById(R.id.spinner2);

        spinner2.setAdapter(new MemberAdapter(this));
        spinner2.setSelection(0,false);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Member member =(Member)parent.getItemAtPosition(position);
                textView.setText("你选择了："+member.getName());
                Toast.makeText(SP2MActivity.this,member.getName(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}