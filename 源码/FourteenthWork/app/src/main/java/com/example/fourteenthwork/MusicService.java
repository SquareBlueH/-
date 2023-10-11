package com.example.fourteenthwork;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service {
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
    TimerTask mTimerTask;
    static boolean isChanging = false;//互斥变量,防止定时器与SeekBar拖动时进度冲突
    //创建一- 个媒体播放器的对象
    static MediaPlayer mediaPlayer;
    //创建一- 个Asset管理器的的对象
    AssetManager assetManager;
    //存放音乐名的数组
    String[] musics = new String[]{"jingqiaoqiao.m4a","qunianaxiatian.m4a","shuosanjiusan.m4a"};
    //当前的播放的音乐
    static int current;
    //当前播放状态
    int state = STATE_NON;
    //记录Timer运行状态
    boolean isTimerRunning = false;
    MusicSercieReceiver receiver;
    IntentFilter filter;
    private Timer mTimer;


    /********************************************************************************
    //（3）初始化
     ********************************************************************************/
    public void onCreate() {
        super.onCreate();
        //注册接收器
        receiver = new MusicSercieReceiver();
        filter = new IntentFilter();
        filter.addAction(MUSIC_SERVICE_ACTION);
        registerReceiver(receiver, filter);
        mediaPlayer = new MediaPlayer();
        assetManager = getAssets();
        current = 0;
        ///为mediaPlayer的完成 事件创建监听器
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                current++;
                prepareAndPlay(current);
            }
        });
    }


    /********************************************************************************
    //（4）装载和播放音乐的方法
     ********************************************************************************/

    /**
     * .
     * 装载和播放音乐
     *
     * @param index int index 播放第几首音乐的索引
     */

    protected void prepareAndPlay(int index) {
        //TODO Auto-generated ethod stub
        if (isTimerRunning) {// 如果Timer正在运行
            mTimer.cancel();//取消定时器
            isTimerRunning = false;
        }
        if (index > musics.length-1) {
            current = index = 0;
        }
        if (index < 0) {
            current = index = musics.length-1;
        }
        //发送厂播停止前台Activity更新界面
        Intent intent = new Intent();
        intent.putExtra("current", index);
        intent.setAction(MUSIC_BOX_ACTION);
        sendBroadcast(intent);

        try {
            //获取assets目录下指定文件的AssetFileDescriptor对象
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(musics[current]);
            mediaPlayer.reset();//初始化mediaPlayer对象
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
            //准备播放音乐
            mediaPlayer.prepare();
            //播放音乐
            mediaPlayer.start();
            //getDuration 0方法要在prepare()方法之后，否则会出现异常
            MainActivity.skbMusic.setMax(mediaPlayer.getDuration());//设置SeekBar的长度
        } catch (IOException e) {
            //TODO Auto -generated catch block
            e.printStackTrace();
        }
        // --------定时器记录播放进---------
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                isTimerRunning = true;
                if (isChanging == true) //当用户正在拖动进度进度条时不处理进度条的的进度
                    return;
                MainActivity.skbMusic.setProgress(mediaPlayer.getCurrentPosition());
            }
        };
        //每隔10毫秒检测一下播放进度
        mTimer.schedule(mTimerTask, 0, 10);
    }


/********************************************************************************
    //（4）接收器
 ********************************************************************************/
    //创建广播接收器用于接收前台Activity发去的广播
    class MusicSercieReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int control = intent.getIntExtra("control", -1);
            switch (control) {
                case STATE_PLAY://播放音乐
                    if (state == STATE_PAUSE) {//如果原来状态是暂停
                        mediaPlayer.start();
                    } else if (state != STATE_PLAY) {
                        prepareAndPlay(current);
                    }
                    state = STATE_PLAY;
                    break;
                case STATE_PAUSE://暂停播放
                    if (state == STATE_PLAY) {
                        mediaPlayer.pause();
                        state = STATE_PAUSE;
                    }
                    break;
                case STATE_STOP: //停止播放
                    if (state == STATE_PLAY || state == STATE_PAUSE) {
                        state = STATE_STOP;
                        mediaPlayer.seekTo(0);
                        mediaPlayer.stop();
                    }
                    break;
                case STATE_PREVIOUS://上一首
                    prepareAndPlay(--current);
                    state = STATE_PLAY;
                    break;
                case STATE_NEXT://下一-首
                    prepareAndPlay(++current);
                    state = STATE_PLAY;
                    break;
                default: break;
            }
        }
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        mTimerTask.cancel();
        mediaPlayer.release();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}



