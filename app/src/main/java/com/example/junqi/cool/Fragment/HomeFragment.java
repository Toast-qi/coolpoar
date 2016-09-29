package com.example.junqi.cool.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junqi.cool.R;
import com.example.junqi.cool.Pager.CommonPager;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 2016/8/6.
 */
public class HomeFragment extends Fragment {
    public List<CommonPager> listdata;
    private MyHomeAdapter adapter;
    public List<String> listurl;
    private ViewPager viewpager;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentview = inflater.inflate(R.layout.home_layout, null);
        initView(fragmentview);

        initData();

        return fragmentview;
    }

        private void initView(View fragmentview) {
            viewpager = (ViewPager) fragmentview.findViewById(R.id.viewpager);
        }

        private void initData() {


            listurl = new ArrayList<String>();
            listurl.add("http://v3.wufazhuce.com:8000/api/hp/detail/1436");
            listurl.add("http://v3.wufazhuce.com:8000/api/hp/detail/1435");
            listurl.add("http://v3.wufazhuce.com:8000/api/hp/detail/1434");
            listurl.add("http://v3.wufazhuce.com:8000/api/hp/detail/1433");
            listurl.add("http://v3.wufazhuce.com:8000/api/hp/detail/1432");
            listurl.add("http://v3.wufazhuce.com:8000/api/hp/detail/1431");
            listurl.add("http://v3.wufazhuce.com:8000/api/hp/detail/1430");

            listdata = new ArrayList<CommonPager>();
            for (int i = 0; i <7; i++) {
                CommonPager commonPager = new CommonPager(getActivity());
                listdata.add(commonPager);
            }
            adapter = new MyHomeAdapter();
            viewpager.setAdapter(adapter);
            viewpager.setCurrentItem(0);

        }

        private class MyHomeAdapter extends PagerAdapter {


            @Override
            public int getCount() {
                Log.e("TAG", "getCount:111111111" +listdata.size() );
                return listdata != null ? listdata.size() : 0;
            }



            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(listdata.get(position).getView());
                listdata.get(position).setData(listurl.get(position));
                return listdata.get(position).getView();
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        }

    }

