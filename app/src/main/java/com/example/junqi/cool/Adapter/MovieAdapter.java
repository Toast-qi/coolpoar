package com.example.junqi.cool.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.MovieBean;
import com.example.junqi.cool.Bean.MyHolder;

/**
 * Created by user on 2016/8/15.
 */
public class MovieAdapter extends BaseAdapter{

//    List<MovieBean> list;
//    List<Bean1>list;
    Context context;
//    public ImageView movie_img;
//    public TextView movie_textview;
    View view;
     MovieBean movieBean;
    public MovieAdapter(MovieBean movieBean, Context context) {

        this.context=context;
//        this.list=list;
        this.movieBean = movieBean;
    }


    @Override
    public int getCount() {
        return movieBean.data.size();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder holder;
        if (view==null){
                    view=View.inflate(context, R.layout.item_movie,null);
                    holder=new MyHolder();
                    holder.image1= (ImageView) view.findViewById(R.id.movie_img);
                    holder.textview= (TextView) view.findViewById(R.id.movie_textview);

                    view.setTag(holder);
                }else {
                    holder= (MyHolder) view.getTag();

                }

          Glide.with(context).load(movieBean.data.get(i).cover).into(holder.image1);
          holder.textview.setText(movieBean.data.get(i).score);
////                  Bean1 bean1= (Bean1) getItem(0);
//                    MovieBean  movieBean= (MovieBean) getItem(0);
//                    holder.image1.setBackgroundResource(movieBean.image1);
//



        return view;
    }
}





//
//
//    public void initData(){
//        final RequestParams params=new RequestParams("");
//        x.http().get(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String s) {
//                Gson gson=new Gson();
//                MovieBean movieBean=gson.fromJson(s,MovieBean.class);
//                movie_textview= (TextView) view.findViewById(R.id.movie_textview);
//                movie_img= (ImageView) view.findViewById(R.id.movie_img);
//
//                Glide.with(context).load(movieBean.data.get(0).cover).into(movie_img);
//                movie_textview.setText(movieBean.data.get(0).score);
//                if (view==null){
//                    view=View.inflate(context, R.layout.item_movie,null);
//                    holder=new MyHolder();
//                    holder.image1=  view.findViewById(R.id.movie_img);
//                    holder.textview=view.findViewById(R.id.movie_textview);
//
//                    view.setTag(holder);
//                }else {
//                    holder= (MyHolder) view.getTag();
//                }
//                Bean1 bean1= (Bean1) getItem(0);
//                holder.image1.setBackgroundResource(bean1.image1);
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
//
//    }
//
//}



