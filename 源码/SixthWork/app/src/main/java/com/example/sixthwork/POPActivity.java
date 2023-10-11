package com.example.sixthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class POPActivity extends AppCompatActivity {
    private TextView poptv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_o_p);

        poptv=findViewById(R.id.poptv_p);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
// Inflate the menu; this adds items to the action bar if it is present .
        String currentText = poptv.getText().toString();
        if("软件技术".equals(currentText)){
            menu.clear();
            menu.add(0,501,1,"软件1班");
            menu.add(0,502,2,"软件2班");
            menu.add(0,503,3,"软件3班");
            menu.add(0,504,4,"转到计算机应用菜单");
        }
        if("计算机应用".equals(currentText)){
            menu.clear();
            menu.add(0,601,1,"计应1班");
            menu.add(0,602,2,"计应2班");
            menu.add(0,603,3,"转到软件技术菜单");
        }return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.po, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest. xml.

        int id = item.getItemId();
        if (id == 501) {
            poptv.setText("班级：软件1班");
            return true;
        } else if (id == 502) {
            poptv.setText("班级：软件2班");
            return true;
        }
        else if (id == 503) {
            poptv.setText("班级：软件3班");
            return true;
        }
        else if (id == 601) {
            poptv.setText("班级：计应1班");
            return true;
        }
        else if (id == 602) {
            poptv.setText("班级：计应2班");
            return true;
        }
        else if (id==504){
            poptv.setText("计算机应用");
            return true;
        }
        else if (id==603){
            poptv.setText("软件技术");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}



























