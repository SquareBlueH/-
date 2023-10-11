package com.example.thirteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BActivity extends AppCompatActivity {
    //（1）	声明好控件并在OnCreate方法中使用findViewById方法关联好控件。
    private String string;
    private TextView tv;
    private EditText edt_num,edt_msg;
    private Button bt;


    //（2）	编写内部类——广播接收类SmsReceiver，该类可以接收短信的广播，接收到后显示在消息框和BActivity的textview中
    class SmsReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            SmsMessage msg = null;
            tv.setText("");
            string = "";
            if (null != bundle) {
                Object[] smsObj = (Object[]) bundle.get("pdus");
                for (Object object : smsObj) {
                    msg = SmsMessage.createFromPdu((byte[]) object);
                    Date date = new Date(msg.getTimestampMillis());//时间
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String receiveTime = format.format(date);
                    string += "\n number:" + msg.getOriginatingAddress()
                            + " \n body:" + msg.getDisplayMessageBody()
                            + " \n time:" + receiveTime;
                }
                Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
                tv.setText(string);
            }
        }
    }

    //（3）	补充声明广播类型、广播接收类和信息过滤器
    static final String BROADCAST_ACTION = "android.provider.Telephony.SMS_RECEIVED";
    SmsReceiver smsReceiver ;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        //（4）	在OnCreate方法中初始化过滤器、广播接收类和注册
        intentFilter = new IntentFilter(BROADCAST_ACTION);
        smsReceiver = new SmsReceiver();
        registerReceiver(smsReceiver, intentFilter);


        tv = findViewById(R.id.tv_ba);
        edt_num = findViewById(R.id.edt_num);
        edt_msg = findViewById(R.id.edt_msg);
        bt = findViewById(R.id.bt_ba);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //（5）	为按钮添加点击事件，并在onclick事件中编写代码。如果手机号不空，且短信长度不超过70个字则直接发送，否则要拆解为多条短信循环发送。
                String phone_number = edt_num.getText().toString().trim();
                String sms_content = edt_msg.getText().toString().trim();
                if (phone_number.equals("")) {
                    Toast.makeText(BActivity.this, "请输入来信手机号! ", Toast.LENGTH_SHORT).show();
                } else {
                    SmsManager smsManager = SmsManager.getDefault();
                    if (sms_content.length() > 70) {
                        List<String> contents = smsManager.divideMessage(sms_content);
                        for (String sms : contents) {
                            smsManager.sendTextMessage(phone_number, null, sms, null, null);
                        }
                    } else {
                        smsManager.sendTextMessage(phone_number, null, sms_content, null, null);
                        Toast.makeText(BActivity.this, "短信已发送", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //（6）	重写onDestroy方法
    @Override
    protected void onDestroy() {
        unregisterReceiver(smsReceiver);
        super.onDestroy();
    }
}