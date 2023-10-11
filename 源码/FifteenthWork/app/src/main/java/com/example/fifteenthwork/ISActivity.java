package com.example.fifteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISActivity extends AppCompatActivity {
    private EditText etNote;
    private TextView tvNote ;
    private Button btnSave,btnAppend,btnOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_s);

        etNote = findViewById(R.id.etNo);
        tvNote = findViewById(R.id.tvNO);
        btnSave = findViewById(R.id.btSave);
        btnAppend = findViewById(R.id.btnAppent);
        btnOpen = findViewById(R.id.btnOpen);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput("note.txt", Context.MODE_PRIVATE);
                    fos.write(etNote.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e) {
                    Log.e("InternalStorageEx", e.toString());
                }
                tvNote.setText("文件已保存: ");
            }
        });

        btnAppend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput("note.txt", Context .MODE_APPEND);
                    fos .write(etNote. getText(). toString().getBytes());
                    fos.close();
                } catch (IOException e) {
                    Log.e("InternalStorageEx", e.toString());
                }
                tvNote. setText("文件已波加: ");
            }
        });

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis = null;
                StringBuilder sb = new StringBuilder();
                try {
                    fis = openFileInput("note.txt");
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    String str = "";
                    while ((str = br.readLine()) != null) {
                        sb.append(str);
                    }
                        br.close();
                        isr.close();
                        fis.close();
                } catch (IOException e) {
                    Log.e("InternalStorageEx", e.toString());
                }
                tvNote.setText(sb);
            }
        });
    }
}