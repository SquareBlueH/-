package com.example.sixthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CTMENUActivity extends AppCompatActivity {
    private TextView cttv;
    private Button btpush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_t_m_e_n_u);

        cttv=findViewById(R.id.cttv_c);
        btpush=findViewById(R.id.btpush_b);
        //注册menu
        registerForContextMenu(btpush);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.ctmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.apple) {
            cttv.setText("你选了苹果！");
            return true;
        }
        else if (id == R.id.banana) {
            cttv.setText("你选了春笋！");
            return true;
        }
        else if (id == R.id.pear) {
            cttv.setText("你选择了梨！");
            return true;
        }
        else if (id == R.id.pitch) {
            cttv.setText("你选了桃子！");
            return true;
        }return super.onContextItemSelected(item);
    }

}