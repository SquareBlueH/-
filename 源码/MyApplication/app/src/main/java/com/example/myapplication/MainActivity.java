package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView2);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if (id==R.id.s){
            Toast.makeText(MainActivity.this,item.getItemId(),Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.j){
            Toast.makeText(MainActivity.this,item.getItemId(),Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.r){
            Toast.makeText(MainActivity.this,item.getItemId(),Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.opm, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }
}