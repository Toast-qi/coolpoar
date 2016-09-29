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
import com.example.junqi.cool.Pager.QuestionPager;

import java.util.ArrayList;
import java.util.List;

public class ReadLianZai extends Activity {
  ImageView lianzai_return_arrow;
    ViewPager viewPager;
    List<QuestionPager>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_read_lianzai);

        lianzai_return_arrow= (ImageView) findViewById(R.id.lianzai_return_arrow);
        lianzai_return_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ReadLianZai.this.finish();
            }
        });


        initview();
        setData();
    }

    public void initview(){
         viewPager= (ViewPager) findViewById(R.id.lianzai_viewpager);
    }

    public void setData(){
        list=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            list.add(new QuestionPager(i,this));
        }

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list != null ? list.size() : 0;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
               View view=list.get(position).initview();
               container.addView(view);
                list.get(position).setData();
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
               View view=list.get(position).initview();
               container.removeView(view);
            }
        });
    }

}
