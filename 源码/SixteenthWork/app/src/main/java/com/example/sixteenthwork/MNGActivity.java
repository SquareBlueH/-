package com.example.sixteenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MNGActivity extends AppCompatActivity {
    private TextView tvRow,tvId;
    private EditText etName,etPhoneNo,etAddress;
    private Button btnNext,btnBack,btnUpdate,btnDelete;
    private SitesDBHlp dbHlp;
    private ArrayList<Site> sites;
    private int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_n_g);

        tvRow = findViewById(R.id.tvRow);
        tvId = findViewById(R.id.tvId);
        etName = findViewById(R.id.etName);
        etPhoneNo = findViewById(R.id.etPhoneNo);
        etAddress = findViewById(R.id.etaddress);
        btnNext = findViewById(R.id.btnnaxt);
        btnBack = findViewById(R.id.btnback);
        btnUpdate = findViewById(R.id.btnupdate);
        btnDelete = findViewById(R.id.btndelete);

        if (dbHlp == null)
            dbHlp = new SitesDBHlp(this);
        sites = dbHlp.getAllSites();
        showSites(index);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if (index >= sites.size())
                    index = 0;
                showSites(index);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                if (index < 0)
                    index = sites.size() - 1;
                showSites(index);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = tvId.getText().toString().trim();
                String name = etName.getText().toString().trim();
                String phoneNo = etPhoneNo.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                if (id.length() <= 0 || name.length() <= 0) {
                    Toast.makeText(MNGActivity.this, "信息不要留空: ",Toast.LENGTH_SHORT).show();
                    return;
                }
                Site site = new Site(id, name, phoneNo, address);
                int count = dbHlp.updateDB(site);
                Toast.makeText(MNGActivity.this, count + "条记录修改成功! ", Toast.LENGTH_SHORT).show();
                sites = dbHlp.getAllSites();
                index = 0;
                showSites(index);
            }
        });
        btnDelete . setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = tvId.getText() . toString() .trim();
                int count = dbHlp. deleteDB(id);
                Toast .makeText (MNGActivity. this, count +" 条记录删除成功:" , Toast. LENGTH_SHORT). show();
                sites = dbHlp. getAllSites();
                index = 0;
                showSites(index);
            }
        });
    }
    private void showSites(int index) {
        if (sites.size() > 1) {
            tvRow.setText((index + 1) + "/" + sites.size() +
                    "(第几个/总个数)");
            tvId.setText(sites.get(index).getId());
            etName.setText(sites.get(index).getName());
            etPhoneNo.setText(sites.get(index).getPhoneNo());
            etAddress.setText(sites.get(index).getAddress());
        } else {
            tvRow.setText("0/0" + "记录为空: ");
            tvId.setText("");
            etName.setText("");
            etPhoneNo.setText("");
            etAddress.setText("");
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        if (dbHlp == null)
            dbHlp = new SitesDBHlp(this);
        sites = dbHlp.getAllSites();
        showSites(index);
    }
    @Override
    public void onPause() {
        super.onPause();
        if (dbHlp != null) {
            dbHlp.close();
            dbHlp = null;
        }
            sites.clear();
    }
}