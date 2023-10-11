package com.example.thirdwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //声明控件对象的方法
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //获取上面定义控件的对象
        textView=findViewById(R.id.textView_t);
        Intent intent =getIntent();
        textView.setText(intent.getStringExtra("1")+"\n"+intent.getStringExtra("2"));

        /*
        String name1=intent.getStringExtra("1");
        String name2=intent.getStringExtra("2");
        textView.setText("用户名："+name1+"\n\b"+"密码："+name2);

         */

        /*
        String []name={name2,"\n",name1};
        for (int i=0;i<name.length;i++){
            textView.setText(name[i]+"");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

         */


    }
}