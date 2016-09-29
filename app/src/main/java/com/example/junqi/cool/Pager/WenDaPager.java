package com.example.junqi.cool.Pager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.WenDaBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by user on 2016/8/26.
 */
public class WenDaPager {

    TextView  ques_title,ques_content,
            answer_title,maketime,
            answer_content,charge_edt;

    Context context;
    int currentPostion;

View view;
    public WenDaPager(Context context, int currentPostion) {
        this.context = context;
        this.currentPostion = currentPostion;
    }

    public View initview(){
     view=View.inflate(context,R.layout.item_answer,null);
        return view;
    }

    public void setData(){
        RequestParams Params=new RequestParams("http://v3.wufazhuce.com:8000/api/question/update/1451/2016-08-25%2017:14:28");
        x.http().get(Params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("'", "onSuccess:_______+++++______ "+s);
                Gson gson=new Gson();
                Log.i("'", "onSuccess:_____________ "+s);
               WenDaBean wenDaBean= gson.fromJson(s,WenDaBean.class);
                ques_title= (TextView) view.findViewById(R.id.ques_title);
                ques_content= (TextView) view.findViewById(R.id.ques_content);
                answer_title= (TextView) view.findViewById(R.id.answer_title);
                maketime= (TextView) view.findViewById(R.id.maketime);
                answer_content= (TextView) view.findViewById(R.id.answer_content);
                charge_edt= (TextView) view.findViewById(R.id.charge_edt);
                Log.i("", "onSuccess:======||=====s+++++ " + wenDaBean.data.question_content);
                ques_title.setText(wenDaBean.data.question_title);
                Log.i("", "onSuccess:======||=====s+++++ "+wenDaBean.data.question_content);
                ques_content.setText(wenDaBean.data.question_content);
                Log.i("", "onSuccess:ssssssssssssssssssss+++++ "+wenDaBean.data.question_content);
                answer_title.setText(wenDaBean.data.answer_title.replace("<br>",""));
                Log.i("", "onSuccess:sssssss_____________sssssssssssss+++++ "+wenDaBean.data.question_content);
                maketime.setText(wenDaBean.data.question_makettime);
                Log.i("", "onSuccess:sssssss_____________sssssssssssss+++++ "+wenDaBean.data.question_makettime);
                answer_content.setText(wenDaBean.data.answer_content.replace("<br>",""));
                charge_edt.setText(wenDaBean.data.charge_edt.replace("<br>",""));
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("onError", "onSuccess:======||=====s+++++ ");

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
