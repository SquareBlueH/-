package com.example.sevework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TouchActivity extends AppCompatActivity {

    private TextView tv;
    private ImageView touch;
    private GestureDetector gt;

    GestureDetector.OnGestureListener listener= new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(@NonNull MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(@NonNull MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(@NonNull MotionEvent e) {
            Toast.makeText(TouchActivity.this,"单击抬起",Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public boolean onScroll(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(@NonNull MotionEvent e) {

            Toast.makeText(TouchActivity.this,"长按",Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(TouchActivity.this,"滑屏",Toast.LENGTH_SHORT).show();
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        tv=findViewById(R.id.tv_t);
        touch=findViewById(R.id.touch_t);
        touch.setFocusable(true);
        touch.setClickable(true);
        touch.setLongClickable(true);

        gt=new GestureDetector(listener);

        touch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                tv.setText("X="+event.getX()+"\n"+"Y="+event.getY());
                return gt.onTouchEvent(event);
            }
        });
    }
}