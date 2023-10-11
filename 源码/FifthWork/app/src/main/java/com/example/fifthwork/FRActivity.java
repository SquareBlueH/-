package com.example.fifthwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;

public class FRActivity extends AppCompatActivity {
    private FrameLayout flt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_r);

        flt=findViewById(R.id.flt_f);
        final MyHandler myHangdler=new MyHandler();
        myHangdler.sendMessageDelayed(myHangdler.obtainMessage(0),200);
    }
    public class MyHandler extends Handler{
        int i=0;
        @Override
        public void handleMessage(@NonNull Message msg){
            if (i<100000)i++;
            else i=0;
            Drawable a=getResources().getDrawable(R.drawable.bird1,getTheme());
            Drawable b=getResources().getDrawable(R.drawable.bird2,getTheme());
            Drawable c=getResources().getDrawable(R.drawable.bird3,getTheme());

            switch (i%3){
                case 0:flt.setForeground(a);break;
                case 1:flt.setForeground(b);break;
                case 2:flt.setForeground(c);break;
            }
            this.sendMessageDelayed(this.obtainMessage(0),200);
        }
    }
}
