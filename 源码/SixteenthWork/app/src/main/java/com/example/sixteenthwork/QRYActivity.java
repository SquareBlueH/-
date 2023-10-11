package com.example.sixteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QRYActivity extends AppCompatActivity {
    private TextView tishi;
    private EditText etPlaceName;
    private Button btnSubmit;
    private SitesDBHlp dbHlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_y);

        tishi = findViewById(R.id.textView7);
        etPlaceName = findViewById(R.id.etPlacName);
        btnSubmit = findViewById(R.id.btnsubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder address = new StringBuilder();
                        String name = etPlaceName. getText(). toString(). trim();
                if(name.length() > 0){
                    ArrayList<String> addresses = dbHlp . getInfo(name);
                    if(addresses.size() > 0){
                        for(String addr: addresses )
                            address . append(addr + "\n");
                    }else{
                        address . append("找不到相关记录!");
                    }
                } else{
                    address.append("请输入关键字!");
                }
                Toast.makeText(QRYActivity . this, address, Toast. LENGTH_LONG) . show();
                tishi.setText(address);
            }
        });
    }
    public void onResume() {
        super .onResume( );
        if(dbHlp == null)
            dbHlp = new SitesDBHlp(this);
    }
    @Override
    public void onPause() {
        super .onPause();
        if(dbHlp != null){
            dbHlp.close();
            dbHlp = null;
        }
    }
}