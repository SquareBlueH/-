package com.example.ninthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;

import java.io.IOException;

public class ALMActivity extends AppCompatActivity {
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_l_m);

        try {
            mp = new MediaPlayer();

            mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Alarms/getup.mp3");
            AudioManager audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
            if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM)!=0){
                mp.setAudioStreamType(AudioManager.STREAM_ALARM);
                mp.setLooping(true);
                mp.prepare();
                mp.start();
            }

            //读取工程内部raw文件夹的音乐
            //mp=MediaPlayer.create(this,R.raw.getup);
            // mp.setLooping(true);
            // mp.start();

            new AlertDialog.Builder(this).setTitle("闹钟").setMessage("起床！起床！！起床！！！").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mp.release();
                    ALMActivity.this.fileList();
                }
            }).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}