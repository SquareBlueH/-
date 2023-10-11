package com.example.fourthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.ImageView;

public class ImgActivity extends AppCompatActivity {

    private Sensor s;
    private SensorManager sm;
    private ImageView imgv;
    private int rate;
    private Vibrator vb;
    private SensorEventListener listener;
    int[] imgid ={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        imgv=findViewById(R.id.img_i);
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        vb=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        rate=SensorManager.SENSOR_DELAY_NORMAL;

        listener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x=event.values[0];
                float y=event.values[1];
                float z=event.values[2];
                float f=15;
                int i=(int)(Math.random()*100)%4;
                if(Math.abs(x)>f||Math.abs(y)>f||Math.abs(z)>f){
                    vb.vibrate(1000);
                    imgv.setImageResource(imgid[i]);
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sm.registerListener(listener,s,rate);
    }
    @Override
    protected void onDestroy() {
        vb.cancel();
        sm.unregisterListener(listener,s);
        super.onDestroy();
    }
}