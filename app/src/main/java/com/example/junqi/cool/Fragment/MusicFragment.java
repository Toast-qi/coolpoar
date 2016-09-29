package com.example.junqi.cool.Fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.junqi.cool.R;
import com.example.junqi.cool.Pager.MusicPager;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment {

    ViewPager viewPager;
    View view;
    List<MusicPager>list;
    List<String>listurl;
    List<String>listurl1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=View.inflate(getActivity(),R.layout.activity_music_fragment,null);
        inittview();
        settData();
        return view;
}
    public void inittview(){
        viewPager= (ViewPager) view.findViewById(R.id.music_viewpager);
    }
    public void settData(){
        listurl1=new ArrayList<>();
        listurl1.add("http://v3.wufazhuce.com:8000/api/related/music/930");
        listurl1.add("http://v3.wufazhuce.com:8000/api/related/music/926");
        listurl1.add("http://v3.wufazhuce.com:8000/api/related/music/938");
        listurl1.add("http://v3.wufazhuce.com:8000/api/related/music/943");


         listurl=new ArrayList<>();
         listurl.add("http://v3.wufazhuce.com:8000/api/music/detail/930");
         listurl.add("http://v3.wufazhuce.com:8000/api/music/detail/931");
         listurl.add("http://v3.wufazhuce.com:8000/api/music/detail/938");
         listurl.add("http://v3.wufazhuce.com:8000/api/music/detail/943");

        list=new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            list.add(new MusicPager(getActivity(),i,listurl.get(i),listurl1.get(i)));
        }
          viewPager.setAdapter(new PagerAdapter() {
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
                  view=list.get(position).inittview();
                  container.addView(view);
                  list.get(position).initData();
                  list.get(position).ininDaata();
                  return view;
              }

              @Override
              public void destroyItem(ViewGroup container, int position, Object object) {
                  view=list.get(position).inittview();
                  list.get(position).initData();
                  list.get(position).ininDaata();
                 container.removeView(view);
              }
          });
    }

    public void setList(){

         class Myadapter extends BaseAdapter{
             private Context context;
             private int currentPostion;
            MusicPager.MusicHolder holder;

             public Myadapter(int currentPostion, Context context) {
                 this.currentPostion = currentPostion;
                 this.context = context;
//                 this.holder=holder;
             }

             @Override
             public int getCount() {
                 return list.size();
             }

             @Override
             public Object getItem(int i) {
                 return null;
             }

             @Override
             public long getItemId(int i) {
                 return i;
             }

             @Override
             public View getView(int i, View view, ViewGroup viewGroup) {
//                 MusicPager.MusicHolder holder=new MusicPager.MusicHolder()
                 if (view==null) {
                     view = View.inflate(context, R.layout.item_music_listview, null);
                     holder.music_liview_imag1 = (ImageView) view.findViewById(R.id.music_liview_imag1);
                     holder.music_image_heart = (ImageView) view.findViewById(R.id.music_image_heart);
                     holder.music_listview_author = (TextView) view.findViewById(R.id.music_listview_author);
                     holder.music_liview_comment = (TextView) view.findViewById(R.id.music_liview_comment);
                     holder.musci_liview_dianzan = (TextView) view.findViewById(R.id.musci_liview_dianzan);
                     view.setTag(view);
                 }else{
                     holder= (MusicPager.MusicHolder) view.getTag();
                 }
                 if (i==0){

                 }

                 return view;
             }
         }
    }

}
