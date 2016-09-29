package com.example.junqi.cool.Pager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.LianzaiBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by user on 2016/8/26.
 */
public class QuestionPager {
    ImageView lianzai_yuan1;
    TextView lianzai_author,lianzai_date,lianzai_content;
    int currentPostion;
    Context context;
    View view;
    public QuestionPager(int currentPostion, Context context) {
        this.currentPostion = currentPostion;
        this.context = context;
    }
 public View initview(){
     view=View.inflate(context,R.layout.item_lianzai,null);
     return view;
 }
    public void setData(){
        RequestParams params=new RequestParams("http://v3.wufazhuce.com:8000/api/serialcontent/155");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("nnnnnnnn'", "onSuccess: "+s);
                Gson gson=new Gson();
                Log.i("nnnnnnnn'", "4444444444: ");
                LianzaiBean lianzai=gson.fromJson(s,LianzaiBean.class);
                Log.i("nnnnnnnn'", "onSuccess: ");
                lianzai_yuan1= (ImageView) view.findViewById(R.id.lianzai_yuan1);
                Log.i("nnnnnnnn'", "999999999999: ");

                lianzai_author= (TextView) view.findViewById(R.id.lianzai_author);
                Log.i("nnnnnnnn'", "111111111: ");
                lianzai_date= (TextView) view.findViewById(R.id.lianzai_date);
                Log.i("nnnnnnnn'", "55555555555: ");

                lianzai_content= (TextView) view.findViewById(R.id.lianzai_content);

                Glide.with(context).load(lianzai.data.author.web_url).into(lianzai_yuan1);
                lianzai_author.setText(lianzai.data.author.user_name);
                Log.i("'", "onSuccess: ttttt++++++++++++++++++++++++"+lianzai.data.author);
                lianzai_date.setText(lianzai.data.last_update_date);
                Log.i("", "onSuccess:dddddddddddd "+lianzai.data.last_update_date);
                lianzai_content.setText((lianzai.data.content).replace("<br>",""));
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
