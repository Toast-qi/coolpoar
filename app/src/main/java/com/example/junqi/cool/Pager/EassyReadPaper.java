package com.example.junqi.cool.Pager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.DuanPian;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by user on 2016/8/25.
 */
public class EassyReadPaper {
    ImageView duanpian_yuan1;
    TextView duanpian_author, duanpian_date, duanpian_content;

    int currentPosition;
    Context context;
    List<View> list;
    View view;

    public EassyReadPaper(Context context, int currentPosition) {
        this.context = context;
        this.currentPosition = currentPosition;
    }

    public View initview() {
        view = View.inflate(context, R.layout.item_duanpian, null);

        return view;
    }

    public void intData() {
        RequestParams params = new RequestParams("http://v3.wufazhuce.com:8000/api/essay/1507");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                DuanPian duanpian = gson.fromJson(s, DuanPian.class);

                duanpian_yuan1 = (ImageView) view.findViewById(R.id.duanpian_yuan1);
                duanpian_author = (TextView) view.findViewById(R.id.duanpian_author);
                duanpian_date = (TextView) view.findViewById(R.id.duanpian_date);
                duanpian_content = (TextView) view.findViewById(R.id.duanpian_content);

//                Log.i("tag", "onSuccess:===========www=============---_++ "+duanpian.data.web_url);
                Glide.with(context).load(duanpian.data.author.get(0).web_url).into(duanpian_yuan1);
//                Log.i("tag", "onSuccess:===========qqqq=============---_++ "+duanpian.data.web_url);
                duanpian_author.setText( duanpian.data.author.get(0).user_name);
                Log.i("ss", "onSuccess:========================== "+duanpian.data.author);
                duanpian_date.setText(duanpian.data.last_update_date);
                Log.i("ss", "onSuccess:========================== "+duanpian.data.last_update_date);
                duanpian_content.setText(duanpian.data.hp_content.replace("<br>",""));
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("onSucces", "onSuccess:=====================4444======================== ");
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
