package com.example.sevework;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;


public class GesturesActivity extends AppCompatActivity {
    private TextView tvgst;
    private GestureOverlayView gstolv;
    private GestureLibrary gstlib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);


        gstlib=GestureLibraries.fromRawResource(this,R.raw.gestures);
        if (!gstlib.load())finish();

        tvgst=findViewById(R.id.tvgst);
        gstolv=findViewById(R.id.gstolv);

        gstolv.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

                ArrayList<Prediction> predictions=gstlib.recognize(gesture);

                if (predictions.size()>0&&predictions.get(0).score>5.0){
                    String result="手势名称："+predictions.get(0).name+"\n手势得分："+String.valueOf(predictions.get(0).score);
                    tvgst.setText(result);
                }
            }
        });
    }
}