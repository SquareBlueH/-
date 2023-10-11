package com.example.fifteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SHActivity extends AppCompatActivity {
    private EditText etFileName,etSecAutoShoot;
    private Button btnSave,btnLoad,btnDefault;
    private RadioButton rbYes,rbNo;
    private String prefName = "prefSet";
    final private String default_fileName = "image";
    final private boolean default_isAutoFocus = true;
    final private int default_secAutoShoot = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_h);

        etFileName = findViewById(R.id.etname);
        etSecAutoShoot = findViewById(R.id.etwait);
        btnSave = findViewById(R.id.btsave);
        btnLoad = findViewById(R.id.btload);
        btnDefault = findViewById(R.id.btdefault);
        rbYes = findViewById(R.id.rbyes);
        rbNo = findViewById(R.id.rbno);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(prefName,Context.MODE_PRIVATE);
                String fileName = etFileName.getText().toString();
                boolean isAutoFocus = true;
                if (rbYes.isChecked())
                    isAutoFocus = true;
                else
                    isAutoFocus = false;
                    int secAutoShoot = 0;
                    try{
                        secAutoShoot = Integer . parseInt(etSecAutoShoot.getText().toString());
                    }catch(NumberFormatException e){
                        Toast. makeText(SHActivity.this,"请输入数字！",Toast.LENGTH_SHORT).show();
                    }
                    settings.edit( )
                            .putString("fileName",fileName)
                            .putBoolean("isAutoFocus",isAutoFocus)
                            .putInt("secAutoShoot",secAutoShoot)
                            .commit();
                Toast .makeText(SHActivity.this,"已保存!",Toast. LENGTH_SHORT).show();

            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPref();
                Toast.makeText(SHActivity.this,"已载入！",Toast.LENGTH_SHORT).show();
            }
        });
        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDefault();
                Toast.makeText(SHActivity.this,"已恢复！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void loadPref() {
        SharedPreferences settings = getSharedPreferences (prefName,Context.MODE_PRIVATE);
        String fileName = settings.getString("fileName",default_fileName);
        etFileName.setText(fileName);
        boolean isAutoFocus = settings.getBoolean("isAutoFocus", default_isAutoFocus);
        if(isAutoFocus)
            rbYes.setChecked(true);
        else
            rbNo.setChecked(true);
        int secAutoShoot = settings . getInt("secAutoShoot", default_secAutoShoot);
        etSecAutoShoot. setText(Integer . toString(secAutoShoot));
    }
    protected void loadDefault() {
        etFileName.setText(default_fileName);
        if(default_isAutoFocus)
        rbYes.setChecked(true);
        else
        rbNo.setChecked(true);
        etSecAutoShoot.setText(Integer.toString(default_secAutoShoot));
    }
}