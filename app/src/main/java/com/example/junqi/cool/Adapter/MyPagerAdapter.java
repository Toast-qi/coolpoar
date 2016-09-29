package com.example.junqi.cool.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by user on 2016/8/6.
 */
public class MyPagerAdapter extends PagerAdapter {
    List<View> list;
    public MyPagerAdapter( List<View> list) {

        this.list = list;
    }

    @Override
      public int getCount() {
          return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=list.get(position);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    public void setList(List<View> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
