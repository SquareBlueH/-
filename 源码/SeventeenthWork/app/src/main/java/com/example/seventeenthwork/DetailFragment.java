package com.example.seventeenthwork;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DetailFragment extends Fragment {
    private int postition;


    public DetailFragment(int postition) {
        this.postition = postition;
    }
    public int getIndex(){
        return postition;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        if (container == null){
            return null;
        }
        View view = inflater.inflate(R.layout.detail_fragment,container,false);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(Resort.Countrys[postition].getImageId());
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(Resort.Countrys[postition].getDescription());

        return view;
    }
    public DetailFragment (){

    }
}


































