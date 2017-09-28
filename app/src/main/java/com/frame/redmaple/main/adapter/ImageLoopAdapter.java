package com.frame.redmaple.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.frame.redmaple.base.util.bannerViewPage.RollPagerView;
import com.frame.redmaple.main.fragment.Fragment_Home;

import java.util.List;

/**
 * Created by Administrator on 2017/9/28.
 */

public class ImageLoopAdapter extends LoopPagerAdapter {

    private Context mContext;
    private List<String> imgList;

    public ImageLoopAdapter(RollPagerView viewPager, Context mContext, List<String> strings) {

        super(viewPager);
        this.mContext = mContext;
        this.imgList = strings;

    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Glide.with(mContext).load(imgList.get(position)).into(view);
//            view.setImageURI(Uri.parse(imgList.get(position)));
        return view;
    }

    @Override
    public int getRealCount() {
        return imgList.size();
    }
}
