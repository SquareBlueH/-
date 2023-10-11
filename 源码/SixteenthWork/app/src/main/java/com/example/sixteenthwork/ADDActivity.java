package com.example.sixteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ADDActivity extends AppCompatActivity {

    private EditText etId,etName,etPhoneNo,etAddress;
    private Button btnInsert,btnClear;
    private SitesDBHlp dbHlp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_d);

        etId = findViewById(R.id.etid);
        etName = findViewById(R.id.etname);
        etPhoneNo = findViewById(R.id.etphone);
        etAddress = findViewById(R.id.etaddress);
        btnInsert = findViewById(R.id.btnadd);
        btnClear = findViewById(R.id.btnclean);

        dbHlp = new SitesDBHlp(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString().trim();
                String name = etName.getText().toString().trim();
                String phoneNo = etPhoneNo.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                StringBuilder sb = new StringBuilder();
                Site site = new Site(id, name, phoneNo, address);
                long rowId = dbHlp.insertDB(site);
                if (rowId != -1) {
                    sb.append("插入成功！");
                } else {
                    sb.append("插入失败！");
                }
                Toast.makeText(ADDActivity.this, sb, Toast.LENGTH_SHORT).show();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etId.setText("");
                etName.setText("");
                etPhoneNo.setText("");
                etAddress.setText("");
            }
        });
    }
    @Override
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