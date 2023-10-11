package com.example.tenthwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SP1Activity extends AppCompatActivity {
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p1);

        spinner1 = findViewById(R.id.spinner1);

        String[] places = {"Australia", "Switzerland", "China", "America"};
        ArrayAdapter<String> adapterPlace = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, places);
        adapterPlace.setDropDownViewResource(R.layout.txtlayout);
        spinner1.setAdapter(adapterPlace);
        spinner1.setOnItemSelectedListener(listener);
    }

    Spinner.OnItemSelectedListener listener = new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(parent.getContext(), "Nothing Selected!", Toast.LENGTH_SHORT).show();
        }
    };
}