package com.example.fifteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ESActivity extends AppCompatActivity {
    private ImageView ivPhoto;
    private Button btnSavePublic,btnSavePerivate;
    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_s);

        //在公有区按钮事件中获取公有区照片文件夹路径，并在那里创建图片文件。
        ivPhoto = findViewById(R.id.esphoto);
        ivPhoto.setImageDrawable(getResources().getDrawable(R.drawable.one));
        btnSavePublic = findViewById(R.id.btnSavePublic);
        btnSavePerivate = findViewById(R.id.btnSavePerivate);
        tvMsg = findViewById(R.id.tvmsg);

        btnSavePublic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File file = new File(path,"one.png");
                createFile(file);
            }
        });

        //在私有区按钮事件中获取私有区照片文件夹路径，并在那里创建图片文件
        btnSavePerivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File path = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                File file = new File(path,"one.png");
                createFile(file);

            }
        });
    }

    //创建图片文件代码
    protected void createFile(File file){
        File parentPath = file.getParentFile();
        if (!isSDExist()){
            Toast.makeText(this,"找不到SD卡！",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            if (!parentPath.exists())
                parentPath.mkdirs();
            if (file.exists())
                file.delete();
            InputStream inputStream = getResources().openRawResource(R.drawable.one);
            OutputStream outputStream = new FileOutputStream(file);
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            outputStream.write(data);
            tvMsg.setText("文件已存储至"+file.toString());
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            Log.e("ExternalStorageEx",e.toString());
        }
        String[] paths = {file.toString()};
        callMediaScanner(paths);
    }

    //判断SD卡是否挂载和扫描刷新媒体文件的代码
    private void callMediaScanner(String[] paths) {
        MediaScannerConnection.scanFile(this,paths,null, new MediaScannerConnection.OnScanCompletedListener(){
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorageEx","Scanned"+path+":");
                Log.i("ExternalStorageEx","-> uri="+uri);
            }
        });
    }

    private boolean isSDExist() {
        String string = Environment.getExternalStorageState();

        if (string.equals(Environment.MEDIA_MOUNTED))
            return true;
        else
            return false;
    }
}