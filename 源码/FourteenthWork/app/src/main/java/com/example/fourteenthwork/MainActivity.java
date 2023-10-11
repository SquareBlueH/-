package com.example.fourteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    public static ProgressDialog skbMusic;
    /********************************************************************************
    //（1）创建接收器过滤常量和信号常量。
     ********************************************************************************/
    //MusicBox接收器所能响应的Action
    public static final String MUSIC_BOX_ACTION = "com.example.FourteenthWork.MUSIC_BOX_ACTION";
    //MusicService接收器所能响应的Action
    public static final String MUSIC_SERVICE_ACTION = "com.example.FourteenthWork.MUSIC_SERVICE_ACTION";
    //初始化flag
    public static final int STATE_NON = 0x100;
    //播放的f1ag
    public static final int STATE_PLAY = 0x101;
    //暂停的f1ag
    public static final int STATE_PAUSE = 0x102;
    //停止放的f1ag
    public static final int STATE_STOP = 0x103;
    //播放上: -首的f1ag
    public static final int STATE_PREVIOUS = 0x104;
    //播放下一首的f1ag
    public static final int STATE_NEXT = 0x105;

    /********************************************************************************
    //（2）其他变量
     ********************************************************************************/
    private Button btnPlayOrPause,btnPre,btnNext;
    //进度条
    protected static SeekBar skbMusic;
    //获取界面中显示歌曲标题、作者文本框
    TextView title, author;
    String[] titleStrs = new String[]{"静悄悄","去年夏天","说散就散"};
    String[] authorStrs = new String[]{"大泫","王大毛","袁娅维"};
    //是否正在播放
    boolean isPlaying = false;
    MusicBoxReceiver mReceiver;
    IntentFilter filter;
    Intent intent;
    private int state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/********************************************************************************
        //（3）初始化
 ********************************************************************************/
        skbMusic = findViewById(R.id.seekBar);
        skbMusic.setOnSeekBarChangeListener(sChangeListener);
        btnNext = findViewById(R.id.up);
        btnPlayOrPause = findViewById(R.id.start);
        btnPre = findViewById(R.id.down);
        btnNext.setOnClickListener(listener);
        btnPlayOrPause.setOnClickListener(listener);
        btnPre.setOnClickListener(listener);
        title = findViewById(R.id.name);
        author = findViewById(R.id.man);


        //注册接收器
        mReceiver = new MusicBoxReceiver();
        filter = new IntentFilter();
        filter.addAction(MUSIC_BOX_ACTION);
        registerReceiver(mReceiver, filter);
        intent = new Intent(this, MusicService.class);//指定要开启的服务
        //情况- :判断后台服务是否已开启，如开启则恢复当前播放进度和状态
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE))
            if ("com.example.administrator.FourteenthWork.MusicService".equals(service.service.getClassName()) && service.started) {
                skbMusic.setMax(MusicService.mediaPlayer.getDuration());
                skbMusic.setProgress(MusicService.mediaPlayer.getCurrentPosition());
                title.setText(titleStrs[MusicService.current]);//更新音乐标题
                author.setText(authorStrs[MusicService.current]);//更新音乐作者
                state = STATE_PLAY;
                if (MusicService.mediaPlayer.isPlaying()) {
                    btnPlayOrPause.setText("暂停");
                    isPlaying = true;
                }
                return;
            }
        //情况二:未开启过服务 则开启服务
        title.setText(titleStrs[0]);
        author.setText(authorStrs[0]);
        state = STATE_NON;
        //启动后台Service
        startService(intent);
    }

    /********************************************************************************
        //（4）按钮监听器
     ********************************************************************************/
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.down://下一首
                        btnPlayOrPause.setText("暂停");
                        state = STATE_NEXT;
                        sendBroadcastToService(state);
                        isPlaying = true;
                        break;
                    case R.id.start: //播放或暂停
                        if (!isPlaying) {
                            btnPlayOrPause.setText("暂停");
                            state = STATE_PLAY;
                            sendBroadcastToService(state);
                            isPlaying = true;
                        } else {
                            btnPlayOrPause.setText("播放");
                            state = STATE_PAUSE;
                            sendBroadcastToService(state);
                            isPlaying = false;
                        }
                        break;
                    case R.id.up://上一首
                        btnPlayOrPause.setText("暂停");
                        state = STATE_PREVIOUS;
                        sendBroadcastToService(state);
                        isPlaying = true;
                        break;
                    default:
                        break;
                }

            }
        };

    /********************************************************************************
        //（5）进度条监听
     ********************************************************************************/

        SeekBar.OnSeekBarChangeListener sChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //当拖动停止后，控制mediaPlayer播放指定位 置的音乐
                if (state != STATE_NON)
                    MusicService.mediaPlayer.seekTo(seekBar.getProgress());
                else seekBar.setProgress(0);
                MusicService.isChanging = false;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                MusicService.isChanging = true;
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
        };
    /********************************************************************************
    //（6）接收器实现、发送广播、菜单停止和退出
     ********************************************************************************/

    //创建一个播接收器用于接收后台Service发出的广播
    class MusicBoxReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // /获取Intent中的current消息，current代表 当前i正在播放的歌曲
            int current = intent.getIntExtra("current", -1);
            title.setText(titleStrs[current]);//更新音乐标题
            author.setText(authorStrs[current]);//更新音乐作者
        }
    }
        /**
         *向后台Service发送控制广播
         *@param state int state控制状态码
         * */
        protected void sendBroadcastToService ( int state){
            Intent intent = new Intent();
            intent.setAction(MUSIC_SERVICE_ACTION);
            intent.putExtra("control", state);
            //向后台Service发送播放控制的广播
            sendBroadcast(intent);
        }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            //关联和添加菜单项
            getMenuInflater().inflate(R.menu.menu_main, menu);
            menu.add(0, 1, 1, "停止");
            menu.add(0, 2, 2, "退出");
            return true;
        }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            int id = item.getItemId();
            if (id == 1) {
                btnPlayOrPause.setText("播放");
                sendBroadcastToService(STATE_STOP);
                isPlaying = false;
            } else if (id == 2) {
                stopService(intent);
                this.finish();
            }
            return true;
        }

        @Override
        protected void onDestroy() {
            unregisterReceiver(mReceiver);
            super.onDestroy();
        }
}