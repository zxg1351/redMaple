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
 * 我的
 */

public class RMMeAdapter extends RecyclerView.Adapter<RMMeAdapter.MyViewHolder> {

    private Context mContext;

    private List<String> data;


    public RMMeAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;
    }


    @Override
    public RMMeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_me, parent, false));


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RMMeAdapter.MyViewHolder holder, int position) {


        holder.textView.setText(data.get(position));
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
        }
    }
}
