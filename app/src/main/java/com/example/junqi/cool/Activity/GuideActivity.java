package com.example.junqi.cool.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;


import com.example.junqi.cool.R;

import com.example.junqi.cool.Pager.guide_readPager;
import com.example.junqi.cool.Utils.ConstantUtils;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {
    ViewPager vp;
    SharedPreferences preferences;
    Button imagbtn;
    List<guide_readPager> list1;
    //    List<ImageView>list;
    View view;
    Adapter adapter;
    List<View> listt;

    //    int[] arrayImage={R.drawable.movie_qiche,R.drawable.a4,R.drawable.b3};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_guide);
//        initView();
//    }
//    private void initView() {
//        preferences = getSharedPreferences(ConstantUtils.SHARED_NAME, Activity.MODE_PRIVATE);
//        imagbtn = (Button) findViewById(R.id.guide_tv);
//        vp = (ViewPager) findViewById(R.id.guide_vp);
//        list = new ArrayList<ImageView>();
//        for (int i = 0; i < arrayImage.length; i++) {
//             ImageView imageView=new ImageView(this);
//              imageView.setBackgroundResource(arrayImage[i]);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            list.add(imageView);
//        }
//
//        imagbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences.Editor editor=preferences.edit();
//                editor.putBoolean("is_first_login",false);
//                editor.commit();
//                Intent intent=new Intent(GuideActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//        vp.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view==object;
//            }
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//              container.addView(list.get(position));
//                return list.get(position);
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//
//                container.removeView((View) object);
//            }
//        });
//        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if (position ==2) {
//                    imagbtn.setVisibility(View.VISIBLE);
//                } else {
//                    imagbtn.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//    }
//}
//     public  GuideActivity(List listt){
//       this.listt=listt;
//}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        preferences = getSharedPreferences(ConstantUtils.SHARED_NAME, Activity.MODE_PRIVATE);
        imagbtn = (Button) findViewById(R.id.guide_tv);
        vp = (ViewPager) findViewById(R.id.guide_vp);
        list1 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            guide_readPager readPager = new guide_readPager(this, i);
            list1.add(readPager);
        }

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ConstantUtils.CURRENT_PAGER = position;
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        imagbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("is_first_login", false);
                editor.commit();
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list1.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                view = (View) list1.get(position).initview1().get(position);
                container.addView(view);
                list1.get(position).setDaata();
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                view = (View) list1.get(position).initview1().get(position);
                container.removeView(view);
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 1) {
                    imagbtn.setVisibility(View.VISIBLE);
                } else {
                    imagbtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}


