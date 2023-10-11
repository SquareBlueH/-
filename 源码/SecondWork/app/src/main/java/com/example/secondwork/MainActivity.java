package com.example.secondwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username,password;
    private Button denglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username=findViewById(R.id.username_n);
        password=findViewById(R.id.password_p);
        denglu=findViewById(R.id.denglu_d);
        int[] max =new int[6];
        int[] min =new int[1];


        password.addTextChangedListener(new TextWatcher() {
            private int start;
            private  int end;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                //输入过程

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //输入前确认执行
//                if (password.getText().toString().length()>6)
//                    password.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
                //输入结束的方法
                start=password.getSelectionStart();
                end=password.getSelectionEnd();
                if(password.length()>max.length){

                    Toast.makeText(MainActivity.this,"您输入的密码超过6位数！",Toast.LENGTH_SHORT).show();
                    s.delete(start-7,end);

                    /*
                    Toast.makeText(MainActivity.this,"输入密码超过6位数！\n将为您开启保护模式！",Toast.LENGTH_SHORT).show();
                    s.delete(start,end-1);//实现出现异常退出软件

                     */
                     /*
                    int t=end;
                    password.setText(s);
                    password.setSelection(t);

                     */
                }
            }
        });

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.length()<min.length&&password.length()<min.length){
                    Toast.makeText(MainActivity.this,"请填写信息！",Toast.LENGTH_SHORT).show();
                }
                else if (username.length()<min.length){
                    Toast.makeText(MainActivity.this,"账号不能为空！",Toast.LENGTH_SHORT).show();
                }
                else if (password.length()<min.length){
                    Toast.makeText(MainActivity.this,"密码不能为空！",Toast.LENGTH_SHORT).show();
                }
                if (username.length()>min.length&&password.length()>min.length){
                    Toast.makeText(MainActivity.this,"用户名："+username.getText()+"\n\b密码："+password.getText(),Toast.LENGTH_SHORT).show(); }
                }
        });
    }
}