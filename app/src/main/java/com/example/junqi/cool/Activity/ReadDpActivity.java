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
import com.example.junqi.cool.Pager.EassyReadPaper;

import java.util.ArrayList;
import java.util.List;

public class ReadDpActivity extends Activity {
    public ImageView return_imag;
    ViewPager viewPager;
    List<EassyReadPaper> list;
    private ArrayList<EassyReadPaper> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.read_duanpian);
        return_imag = (ImageView) findViewById(R.id.dpian_return_arrow);
        return_imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadDpActivity.this.finish();
            }

        });
        initview();
        setData();

    }

    public void initview() {
        viewPager = (ViewPager) findViewById(R.id.duanpian_viewpager);
    }

    public void setData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new EassyReadPaper(this, i));
        }
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list != null ? list.size() : 0;

            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = list.get(position).initview();
                container.addView(view);
                list.get(position).intData();
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
