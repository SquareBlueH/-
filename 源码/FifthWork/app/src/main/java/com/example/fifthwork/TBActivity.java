package com.example.fifthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TBActivity extends AppCompatActivity {

    private EditText username, password;
    private Button denglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_b);

        username = findViewById(R.id.username_u);
        password = findViewById(R.id.passwrod_p);
        denglu = findViewById(R.id.denglu_d);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login()){
                    Intent intent=new Intent();
                    String uname=username.getText().toString();
                    intent.putExtra("1",uname);
                    intent.setClass(TBActivity.this,MainActivity2.class);
                    TBActivity.this.startActivity(intent);
                }
                else Toast.makeText(TBActivity.this,"用户或密码输入错误",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean login() {
        String name[][] = {{"pry", "123"}, {"admin", "admin"}, {"look", "456"}};
        for (String s[] : name) {
            if (username.getText().toString().equals(s[0]) && password.getText().toString().equals(s[1]))
                return true;
        }
        return false;
    }
}