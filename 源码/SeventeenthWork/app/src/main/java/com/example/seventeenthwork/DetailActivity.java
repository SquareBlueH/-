package com.example.seventeenthwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration configuration = getResources() . getConfiguration();
        if (configuration.orientation == Configuration . ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
            Bundle bundle = getIntent() . getExtras();
            int position = bundle. getInt("position");
            DetailFragment detailFragment = new DetailFragment(position);
            FragmentTransaction ft = getSupportFragmentManager(). beginTransaction();
            ft.add(android.R.id.content, detailFragment).commit();
        }
    }