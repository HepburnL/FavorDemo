package com.example.favordemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainItemAdapter extends RecyclerView.Adapter <MainItemAdapter.MyViewHolder>{

    private Context mContext;
    private List<MainItemBean> mList;
    private OnItemClickListener mOnItemClickListener;

    public MainItemAdapter(Context context, List<MainItemBean> list) {
        mContext = context;
        mList = list;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemVlickListener) {
        this.mOnItemClickListener = onItemVlickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mTv.setText(mList.get(position).getName());
        Glide.with(mContext).load(mList.get(position).getImageId()).into(holder.mIv);

        if(mOnItemClickListener != null){
            holder.mBgLl.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(view,layoutPosition);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mBgLl;
        ImageView mIv;
        TextView mTv;

        public MyViewHolder(View view){
            super(view);
            mBgLl = (LinearLayout)view.findViewById(R.id.bg_ll);
            mIv = (ImageView)view.findViewById(R.id.iv);
            mTv = (TextView)view.findViewById(R.id.tv);

        }
    }
}
