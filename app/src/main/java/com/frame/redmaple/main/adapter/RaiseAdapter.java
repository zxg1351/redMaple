package com.frame.redmaple.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yaguit.AbViewUtil;
import com.frame.redmaple.R;
import com.frame.redmaple.base.common.CommonAdapter;

import java.util.List;

import static com.frame.redmaple.R.id.imageView;

/**
 * 募集中 列表适配器
 * author：ZK
 * Date：2017/7/30 16:21
 */
public class RaiseAdapter extends CommonAdapter {
    private Context mContext;

    private List<String> data;

    private List<Integer> imageList;

    private LayoutInflater mLayoutInflater;

    private boolean idOpen = false;

    public RaiseAdapter(Context context, List<String> data, List<Integer> imageList) {
        this.mContext = context;
        this.data = data;
        this.imageList = imageList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        if (null != data && position < getCount()) {
            return data.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RaiseAdapter.ViewHolder viewHolder = null;
        if (null == convertView) {
            convertView = mLayoutInflater.inflate(R.layout.item_home, null);
            viewHolder = new RaiseAdapter.ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_home);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.id_num);
            AbViewUtil.scaleContentView((LinearLayout) convertView.findViewById(R.id.rootLayout));
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (RaiseAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(data.get(position));
//        viewHolder.imageView.setText(mList.get(position).getAmount() + "");
        if (imageList.size() == 0) {

        } else {

            Glide.with(mContext).load(imageList.get(position)).into(viewHolder.imageView);
        }
        return convertView;
    }

    static class ViewHolder {

        TextView textView;
        ImageView imageView;
    }
}
