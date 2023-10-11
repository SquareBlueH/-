package com.example.tenthwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MemberAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    List<Member> memberList;

    public MemberAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        memberList = new ArrayList<>();
        memberList.add(new Member("中国", R.drawable.cn));
        memberList.add(new Member("美国", R.drawable.us));
        memberList.add(new Member("英国", R.drawable.en));
        memberList.add(new Member("瑞士", R.drawable.sw));
}

    @Override
    public int getCount() {
        return memberList.size();
    }

    @Override
    public Object getItem(int position) {
        return memberList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list, parent, false);
        Member member = memberList.get(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.img);
        TextView textView = (TextView) convertView.findViewById(R.id.tv);
        imageView.setImageResource(member.getImageid());
        textView.setText(member.getName());
        return convertView;
    }
}

