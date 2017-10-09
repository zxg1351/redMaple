package com.frame.redmaple.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frame.redmaple.R;

import java.util.List;

/**
 * 案例适配器
 */
public class RMCaseAdapter extends RecyclerView.Adapter<RMCaseAdapter.MyViewHolder> {

    private Context mContext;

    private List<String> data;


    public RMCaseAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;
    }

    public interface OnItemClickLitener {

        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);


    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setmOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public RMCaseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_case, parent, false));


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final RMCaseAdapter.MyViewHolder holder, int position) {

        holder.textView.setText(data.get(position));


        if (mOnItemClickLitener != null) {


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.id_num);

        }
    }
}
