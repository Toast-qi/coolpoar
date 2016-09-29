package com.example.junqi.cool.Fragment;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.junqi.cool.Activity.WebViewActivity;
import com.example.junqi.cool.Adapter.MovieAdapter;

import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.MovieBean;
import com.google.gson.Gson;


import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


public class MovieFragment extends Fragment{
//    List<MovieBean>list;
    ListView listView;
    View view;
    MovieAdapter adapter;
    Context context;
    List<String>listurl;
    @Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          view=inflater.inflate(R.layout.activity_movie_fragment,null);
          initview();
         insetData();
         return view;
    }

    public void  insetData(){
        listurl=new ArrayList<>();
//        电影页面跳转网址~
        listurl.add("http://m.wufazhuce.com/movie/120");
        listurl.add("http://m.wufazhuce.com/movie/119");
        listurl.add("http://m.wufazhuce.com/movie/122");
        listurl.add("http://m.wufazhuce.com/movie/124");
        listurl.add("http://m.wufazhuce.com/movie/123");
        listurl.add("http://m.wufazhuce.com/movie/118");
        listurl.add("http://m.wufazhuce.com/movie/117");
        listurl.add("http://m.wufazhuce.com/movie/116");
        listurl.add("http://m.wufazhuce.com/movie/115");
        listurl.add("http://m.wufazhuce.com/movie/114");
        listurl.add("http://m.wufazhuce.com/movie/113");
        listurl.add("http://m.wufazhuce.com/movie/112");
        listurl.add("http://m.wufazhuce.com/movie/111");
    }
    public void initview(){


          RequestParams params=new RequestParams("http://v3.wufazhuce.com:8000/api/movie/list/0");
          x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String s) {
                Gson gson=new Gson();
                MovieBean movieBean=gson.fromJson(s,MovieBean.class);
                listView= (ListView) view.findViewById(R.id.movie_listview);
                adapter=new MovieAdapter(movieBean,getContext());
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String url=listurl.get(i);
                        Intent intent=new Intent(getActivity(), WebViewActivity.class);
                        intent.putExtra("url",url);
                        startActivity(intent);
                    }
                });
//                Glide.with(context).load(movieBean.data.get(0).cover).into(movie_img);
//                movie_textview.setText(movieBean.data.get(0).score);

            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });

    }



    }



//if (view==null){
//        view=View.inflate(context, R.layout.item_movie,null);
//        holder=new MyHolder();
//        holder.image1=  view.findViewById(R.id.movie_img);
//        holder.textview=view.findViewById(R.id.movie_textview);
//
//        view.setTag(holder);
//        }else {
//        holder= (MyHolder) view.getTag();
//        }
//        Glide.with(context).load(movieBean.data.get(0).cover).into(movie_img);
//        movie_textview.setText(movieBean.data.get(1).score);
