package com.example.eleventhwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class GDActivity extends AppCompatActivity {
    private GridView gdv;
    private ImageSwitcher img;

    int imgid[]={R.drawable.panda1,R.drawable.panda2,R.drawable.panda3,R.drawable.panda4,R.drawable.panda5,R.drawable.panda6,R.drawable.panda7,R.drawable.panda8,R.drawable.panda9};

    class ImageApdater extends BaseAdapter{
        LayoutInflater layoutInflater;
        Context context;
        public ImageApdater(Context context){
            layoutInflater=LayoutInflater.from(context);
            this.context=context;
        }

        @Override
        public int getCount() {
            return imgid.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView=layoutInflater.inflate(R.layout.gdv_item,parent,false);
            ImageView imageView = (ImageView) convertView;
            imageView.setImageResource((imgid[position]));

            return imageView;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_d);

        gdv=findViewById(R.id.gdv_gd);
        img=findViewById(R.id.image_gd);

        gdv.setAdapter(new ImageApdater(this));
        img.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(GDActivity.this);
                return imageView;
            }
        });

        img.setInAnimation(this, android.R.anim.fade_in);
        img.setOutAnimation(this, android.R.anim.fade_out);
        img.setImageResource(imgid[0]);

        gdv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                img.setImageResource(imgid[position]);
            }
        });


    }
}