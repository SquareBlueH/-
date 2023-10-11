package com.example.thirteenthwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//最低版本必须为API26以上
//记得修改build.gradle中minSdkVersion数值在26及以上
public class NActivity extends AppCompatActivity {
    private TextView tv;
    private EditText edt;
    private int second;
    private Button mit,sed;
    private NotificationManager manager;
    private NotificationChannelGroup channelGroup;
    private NotificationChannel notificationChannel;
    private Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n);

        tv = findViewById(R.id.tv_na);
        edt = findViewById(R.id.edt);
        mit=findViewById(R.id.bt_namit);
        sed=findViewById(R.id.bt_nased);

        //管理通知类
        manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        //通知渠道组用于管理通知渠道
        channelGroup = new NotificationChannelGroup("GroupId1", "GroupName1");
        //创建通知渠道组
        manager.createNotificationChannelGroup(channelGroup);
        //创建通知渠道
        notificationChannel = new NotificationChannel("ChannelId1", "ChannelName1", NotificationManager.IMPORTANCE_HIGH);
        notificationChannel.enableLights(true);//允许使用LED消息提示灯
        notificationChannel.enableVibration(true);//允许振动
        notificationChannel.setLightColor(Color.YELLOW);//设置LED提示灯为黄色
        notificationChannel.setVibrationPattern(new long[]{ 0, 100, 100, 100 });//设置振动的频率
        notificationChannel.setGroup("GroupId1");//设置通知渠道组
        manager.createNotificationChannel(notificationChannel);

        // 通知跳转动作
        Intent intent = new Intent(this, NActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE);
        //构造通知
        notification = new NotificationCompat.Builder(this, "ChannelId1")
                .setContentTitle("干饭了干饭了干饭了")
                .setContentText("干饭不积极，脑子有问题！")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();


        mit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second= Integer.parseInt(edt.getText().toString());
                new CountDownTimer(second * 60000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (mit !=null){
                            //打开按钮该功能，则按钮可使用
                            mit.setClickable(false);
                            mit.setEnabled(false);
                            sed.setClickable(false);
                            sed.setEnabled(false);
                            long minute=millisUntilFinished/60000;
                            long second=(millisUntilFinished-minute*(1000*60))/1000;
                            tv.setText("将在" + minute + "分" + second + "秒后发送通知");
                        }
                    }

                    @Override
                    public void onFinish() {
                        if ((mit != null)){
                            //关闭关闭该功能，则按钮不能使用
                            mit.setClickable(true);
                            mit.setEnabled(true);
                            sed.setClickable(true);
                            sed.setEnabled(true);
                            tv.setText("通知已发出，请查看通知栏信息。");
                            manager.notify(0, notification);
                        }
                        //在Activity或Fragment销毁的时候记得调用 cancle() 方法，否则它的 onTick() 方法还会继续执行，容易造成内存泄漏。
                        cancel();
                    }
                }.start();
            }
        });
        sed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second= Integer.parseInt(edt.getText().toString());
                new CountDownTimer(second * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (sed != null){
                            //关闭关闭该功能，则按钮不能使用
                            mit.setClickable(false);
                            mit.setEnabled(false);
                            sed.setClickable(false);
                            sed.setEnabled(false);
                            long second=millisUntilFinished/1000;
                            tv.setText("将在" + second + "秒后发送通知");
                        }
                    }

                    @Override
                    public void onFinish() {
                        if (sed != null){
                            //打开按钮该功能，则按钮可使用
                            mit.setClickable(true);
                            mit.setEnabled(true);
                            sed.setClickable(true);
                            sed.setEnabled(true);
                            tv.setText("通知已发出，请查看通知栏信息。");
                            manager.notify(0, notification);
                        }
                        //在Activity或Fragment销毁的时候记得调用 cancle() 方法，否则它的 onTick() 方法还会继续执行，容易造成内存泄漏。
                        cancel();
                    }
                }.start();
            }
        });
    }
}
//Android8.0版本及以下使用
//1.使用了过时的Notification.Builder类，应该使用NotificationCompat.Builder替代。
//2.没有为通知设置渠道，这会导致在Android 8.0及以上版本上无法显示通知。
//3.在Android 10及以上版本上，需要在AndroidManifest.xml文件中添加权限REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,否则可能会
//被系统限制后台运行。
//public class NActivity extends AppCompatActivity {
//    private TextView tv;
//    private EditText edt;
//    private Button bt;
//    private Intent intent;
//    private NotificationManager notificationManager;
//    private PendingIntent pendingIntent;
//    private Notification notification;
//    private int second;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_n);
//
//        tv = findViewById(R.id.tv_na);
//        edt = findViewById(R.id.edt);
//        bt = findViewById(R.id.bt_na);
//
//
//        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        intent = new Intent(this, BActivity.class);
//        pendingIntent = PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_MUTABLE);
//        notification = new Notification.Builder(this)
//                .setContentTitle("你老师喊你回直播间上网课啦! ! ")
//                .setContentText("学习短信的收发")
//                .setSmallIcon(android.R.drawable.ic_menu_info_details)
//                .setAutoCancel(true)
//                .setContentIntent(pendingIntent)
//                .build();
//
//        //构造通知
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                second= Integer.parseInt(edt.getText().toString());
//                new CountDownTimer(second * 1000, 1000) {
//                    @Override
//                    public void onTick(long millisUntilFinished) {
//                        tv.setText((millisUntilFinished / 1000) + "秒后发通知");
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        tv.setText("通知已发出");
//                        notificationManager.notify(0, notification);
//                    }
//                }.start();
//            }
//        });
//    }
//}