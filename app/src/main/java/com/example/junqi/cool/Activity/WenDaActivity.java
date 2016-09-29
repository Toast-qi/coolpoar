package com.example.junqi.cool.Activity;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.junqi.cool.R;
import com.example.junqi.cool.Pager.WenDaPager;

import java.util.ArrayList;
import java.util.List;

public class WenDaActivity extends Activity {
    ImageView wenda_return_arrow;
    ViewPager viewPager;
    List<WenDaPager> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_wen_da);
        wenda_return_arrow = (ImageView) findViewById(R.id.wenda_return_arrow);
        initview();
        setData();
        wenda_return_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WenDaActivity.this.finish();
            }
        });
    }

    public void initview() {
        viewPager = (ViewPager) findViewById(R.id.wenda_viewpager);
    }

    public void setData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new WenDaPager(this, i));
        }
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = list.get(position).initview();
                list.get(position).setData();
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View view = list.get(position).initview();
                container.removeView(view);
            }
        });
    }
}
