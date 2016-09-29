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

import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.junqi.cool.Adapter.NetworkImageHolderView;
import com.example.junqi.cool.R;
import com.example.junqi.cool.Pager.ReadPager;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/8/7.
 */
public class ReadFragment extends Fragment {
    public List<String> listurl,listurl2;
    public List<ReadPager> listdata1;
    private ViewPager viewPager;
    List<ReadPager> list2;
    View view;
    private ConvenientBanner banner;
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    private List<String> networkImages = new ArrayList<>();
     View readview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.read_layout, null);


//        RequestParams params=new RequestParams("http://v3.wufazhuce.com:8000/api/reading/index/");
//        /***
//         * 回调接口里面的方法都是UI线程方法
//         * 可以直接更新UI界面
//         * */
//        x.http().get(params, new Callback.CommonCallback<String>(){
//
//            @Override
//            public void onSuccess(String s) {
//                Log.i("onSuccess", "onSuccess: "+s);
//                Gson gson=new Gson();
//                ReadTwoBean readTwoBean=gson.fromJson(s,ReadTwoBean.class);
//                Log.i("readTwoBean", "onSuccess:---------- "+readTwoBean.data.essay);
//            }
//
//            @Override
//            public void onError(Throwable throwable, boolean b) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException e) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//      1、初始化fragment布局中的所有控件（轮播图控件banner    ViewPager）
        initView(view);
//      2、添加网络图片的路径到一个list集合里边  （listurl）
        initData();
//       3、 改轮播图控件设置数据
        setBannerdata();
//       4、 给viewpager设置数据
        setVpData();
        return view;
    }


    private void initView(View view) {
        banner = (ConvenientBanner) view.findViewById(R.id.banner);
        viewPager = (ViewPager) view.findViewById(R.id.read_vpager1);
    }

    private void setBannerdata() {
        initImageLoader();
        banner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, listurl).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置翻页的效果，不需要翻页效果可用不设
                .setPageTransformer(ConvenientBanner.Transformer.CubeInTransformer);
    }

    public void initData() {
        listurl = new ArrayList<>();
//        阅读上半部分的接口地址
        listurl.add("http://image.wufazhuce.com/FhC1YR69DL8eJwJX04yYQtb4H8v-");
        listurl.add("http://image.wufazhuce.com/FlxLJaKp023M1g4oFIsaKyulB3uo");
        listurl.add("http://image.wufazhuce.com/Fs_pmdYjetPtBgVUup5jqc57Wh0g");
        listurl.add("http://image.wufazhuce.com/Ft6gQo2AdT-4Z4A9wFz_EfVC1qkh");
        listurl.add("http://image.wufazhuce.com/FtBfxmeQlE9q4KkrOL2mO2Cl0DIW");
        listurl2=new ArrayList<>();
//        阅读下半部分三个item的接口地址
        listurl2.add("http://v3.wufazhuce.com:8000/api/reading/index/");


    }

    private void setVpData() {
        list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list2.add(new ReadPager(getContext(), i));
        }
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list2!=null?list2.size():0;

            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
//
                Log.e("TAG", "instantiateItem: "+position);
                ReadPager readPager = list2.get(position);
                readview = readPager.getView();
                container.addView(readview);
                readPager.setData(listurl2.get(0));
                return readview;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ReadPager readPager = list2.get(position);
                readview = readPager.getView();
                container.removeView(readview);
            }
        });
    }


    //初始化网络图片缓存库
    private void initImageLoader() {
        //网络图片例子,结合常用的图片缓存库UIL,你可以根据自己需求自己换其他网络图片库
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
                showImageForEmptyUri(R.drawable.ic_default_adimage)
                .cacheInMemory(true).cacheOnDisk(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getActivity()).defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
               ImageLoader.getInstance().init(config);
    }


    // 开始自动翻页
    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        banner.startTurning(2000);
    }
    // 停止自动翻页
    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        banner.stopTurning();
    }
}
