package com.example.fifthwork;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    //声明需要控件对象的方法
    private TextView pryname;
    private RadioButton boy,girl;
    private CheckBox sports,play,reading;
    private Button queding;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //获取控件对象
        pryname=findViewById(R.id.pry_p);
        boy=findViewById(R.id.boy_b);
        girl=findViewById(R.id.girl_g);
        sports=findViewById(R.id.sports_s);
        play=findViewById(R.id.play_p);
        reading=findViewById(R.id.reading_r);
        queding=findViewById(R.id.queding_q);

        radioGroup=findViewById(R.id.radioGroup_r);


        Intent intent =getIntent();
        String name=intent.getStringExtra("1");
        pryname.setText(name);

        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sex="",favor="",info="",OMG="";

                if (boy.isChecked())sex=boy.getText().toString();
                else if(girl.isChecked())sex=girl.getText().toString();
                if (sports.isChecked())favor+=sports.getText().toString()+"、";
                if (play.isChecked())favor+=play.getText().toString()+"、";
                if (reading.isChecked())favor+=reading.getText().toString();

                info="用户名："+pryname.getText()+"\b\b性别："+sex+"\n爱好："+favor;
                OMG="用户名："+pryname.getText()+"\b\b性别：Gay"+sex+"\n爱好："+favor;

                if(sex.length()==0){
                    Toast.makeText(MainActivity2.this,OMG,Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity2.this,info,Toast.LENGTH_SHORT).show();

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton r=findViewById(checkedId);
                //String c = r.getText().toString();
                Toast.makeText(MainActivity2.this,r.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });




    }
    /*
    private  void checkRgSelected(RadioGroup radioGroup){
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            int tagPos = i;
            radioGroup.getChildAt(i).setOnClickListener(v -> {
                Integer tag = (Integer) radioGroup.getTag();
                if(tag == null){
                    //第一次选中点击
                    radioGroup.clearCheck();
                    radioGroup.check(v.getId());
                    radioGroup.setTag(tagPos);
                }else{
                    //是否是上一次选中点击的,如果是说明是重复点击，取消选中
                    if(tag == tagPos){
                        radioGroup.clearCheck();
                        radioGroup.setTag(null);
                    }else{
                        radioGroup.check(v.getId());
                        radioGroup.setTag(tagPos);
                    }
                }
            });
        }
    }

     */
}