package com.example.sixthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class OPMENUActivity extends AppCompatActivity {
    private TextView optv,dep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_p_m_e_n_u);

        optv = findViewById(R.id.optv);
        dep=findViewById(R.id.majormenu111);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.majormenu1) {
            optv.setText("你选择了计算机系计算机应用专业");
            return true;
        } else if (id == R.id.majormenu2) {
            optv.setText(item.getTitle());
            return true;
        }
        else if (id == R.id.majormenu11) {
            optv.setText(item.getTitle());
            return true;
        }
        else if (id == R.id.majormenu22) {
            optv.setText(item.getTitle());
            return true;
        }
        else if (id == R.id.majormenu33) {
            optv.setText(item.getTitle());
            return true;
        }
        else if (id == R.id.majormenu111) {
            optv.setText("你选择了摆烂专业");
            Toast.makeText(OPMENUActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}