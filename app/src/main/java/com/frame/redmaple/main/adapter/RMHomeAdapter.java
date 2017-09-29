package com.frame.redmaple.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.frame.redmaple.R;
import com.frame.redmaple.base.HomeBean;

import java.util.List;

/**
 * 首页
 */

public class RMHomeAdapter extends RecyclerView.Adapter<RMHomeAdapter.MyViewHolder> {

    private Context mContext;

    private List<String> data;

    private List<Integer> imageList;
    private List<HomeBean> homeBeanList;

    public RMHomeAdapter(Context mContext, List<String> data, List<Integer> imageList) {
        this.mContext = mContext;
        this.data = data;
        this.imageList = imageList;
    }


    public RMHomeAdapter(Context mContext, List<HomeBean> homeBean) {
        this.mContext = mContext;
        this.homeBeanList = homeBean;
    }


    @Override
    public RMHomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home, parent, false));


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RMHomeAdapter.MyViewHolder holder, int position) {


        holder.textView.setText(data.get(position));
        Glide.with(mContext).load(imageList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.id_num);
            imageView = itemView.findViewById(R.id.iv_home);
        }
    }
}
