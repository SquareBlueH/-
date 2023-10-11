package com.example.thirdwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //声明控件对象的方法
    private EditText username, password;
    private Button denglu, dengluother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String[][] name = new String[][]{{"pry","123"},{"1","2"},{"xxx","456"}};
        String[][] name = {{"pry", "123"}, {"admin", "8888"}, {"xxx", "456"}};
        //获取上面定义控件的对象
        username = findViewById(R.id.username_u);
        password = findViewById(R.id.password_p);
        denglu = findViewById(R.id.denglu_d);
        dengluother = findViewById(R.id.dengluother_o);

        //为按钮绑定监听器
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取文本输入框中的内容，也是上述username和password的内容
                String uname = username.getText().toString();
                String pword = password.getText().toString();

                //判定输入框的内容
                for (int i = 0; i < name.length; i++) {  //二维数组的行循环
                    if (name[i][0].equals(uname) && name[i][1].equals(pword)) { //保证每次都是寻找二维数组的第一个，也就是用户名     //保证每次都是寻找二维数组的第二个，也就是密码
                        //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        Intent intent = new Intent(); // 新建一个Intent对象
                        intent.setClass(MainActivity.this, MainActivity2.class);  //指定intent要启动的类
                        intent.putExtra("1", uname); //将字符值入 Intent对象中，其中字符值必须选择不一样的数值
                        intent.putExtra("2", pword); //将字符值入 Intent对象中，其中字符值必须选择不一样的数值
                        MainActivity.this.startActivity(intent);//启动一个新的Activity
                        Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (i == name.length - 1) {
                        Toast.makeText(MainActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }

/*
                if(uname.equals("pry")&&pword.equals("123")){
                    //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Intent intent = new Intent(); // 新建一个Intent对象
                    intent.setClass(MainActivity.this, MainActivity2.class);  //指定intent要启动的类
                    intent.putExtra("1",uname); //将字符值入 Intent对象中，其中字符值必须选择不一样的数值
                    intent.putExtra("2",pword); //将字符值入 Intent对象中
                    MainActivity.this.startActivity(intent);//启动一个新的Activity
                }
                else {
                    Toast.makeText(MainActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                }

 */


/*
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //Intent intent = new Intent(); // 新建一个Intent对象
                //intent.setClass(MainActivity.this, MainActivity2.class);  //指定intent要启动的类
                intent.putExtra("1",uname); //将字符值入 Intent对象中，其中字符值必须选择不一样的数值
                intent.putExtra("2",pword); //将字符值入 Intent对象中
                MainActivity.this.startActivity(intent);//启动一个新的Activity

                //startActivity(intent);


 */
            }
        });

        dengluother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pword = password.getText().toString();

                //判定输入框的内容

                //if(uname.equals("pry")&&pword.equals("123")){
                for (int i = 0; i < name.length; i++) {  //二维数组的行循环
                    if (name[i][0].equals(uname) && name[i][1].equals(pword)) { //保证每次都是寻找二维数组的第一个，也就是用户名     //保证每次都是寻找二维数组的第二个，也就是密码
                        //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        Intent intent = new Intent(); // 新建一个Intent对象
                        intent.setClass(MainActivity.this, MainActivity3.class);  //指定intent要启动的类
                        intent.putExtra("11", uname); //将字符值入 Intent对象中，其中字符值必须选择不一样的数值
                        MainActivity.this.startActivity(intent);//启动一个新的Activity
                        Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (i == name.length - 1) {
                        Toast.makeText(MainActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


//        denglu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (login()){
//                    Intent intent = new Intent();
//                    intent.setClass(MainActivity.this,MainActivity2.class);
//                    MainActivity.this.startActivity(intent);
//                }
//                else Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    private boolean login(){
//        String data[][] = {{"pry","123"},{"admin","1234"},{"user","111"}};
//        for (String s[]:data){
//            if (username.getText().toString().equals(s[0])&&password.getText().toString().equals(s[1]))
//                return true;
//        }
//        return false;
//    }
    }
}