package com.example.eleventhwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RCVActivity extends AppCompatActivity {

    private RecyclerView recyclerView;//对于控件的声明
    private TextView textView;

    private class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder>{
        private Context context;
        private LayoutInflater layoutInflater;
        private List<Member> memberList;
        public MemberAdapter(Context context){
            this.context=context;
            layoutInflater=LayoutInflater.from((context));
            memberList=new ArrayList<>();
            memberList.add(new Member("生气", R.drawable.p1));
            memberList.add(new Member("抠鼻", R.drawable.p2));
            memberList.add(new Member("流汗", R.drawable.p3));
            memberList.add(new Member("调皮", R.drawable.p4));
        }

        @NonNull
        @Override
        //创建选项类
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemview=layoutInflater.inflate(R.layout.rcv_cv_item,parent,false);
            return new ViewHolder(itemview);
        }

        @Override
        //数据绑定选项类
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Member member = memberList.get(position);
            holder.getCv_iv().setImageResource(member.getImageid());
            holder.getCv_tv().setText(member.getName());
        }

        @Override
        public int getItemCount() {
            return memberList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView cv_iv;
            private TextView cv_tv;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cv_iv=itemView.findViewById(R.id.cv_image);
                cv_tv=itemView.findViewById(R.id.cv_tv);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (getAdapterPosition()==RecyclerView.NO_POSITION)return;

                        Member member =memberList.get(getAdapterPosition());
                        ImageView imageView = new ImageView(context);
                        imageView.setImageResource(member.getImageid());
                        textView.setText(member.getName());
                        Toast toast = new Toast(context);
                        toast.setView(imageView);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
            public ImageView getCv_iv(){
                //返回图片控件
                return cv_iv;
            }
            public TextView getCv_tv(){
                //返回文本控件
                return cv_tv;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_c_v);

        recyclerView=findViewById(R.id.recyclerView);
        textView=findViewById(R.id.tv_rc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new MemberAdapter(this));
        
    }
}