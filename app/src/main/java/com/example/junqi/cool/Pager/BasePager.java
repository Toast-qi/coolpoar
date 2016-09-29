package com.example.junqi.cool.Pager;

import android.content.Context;
import android.view.View;

/**
 * Created by user on 2016/8/13.
 */
public abstract class BasePager {
    Context context;
    View view,view1;

    public BasePager(Context context) {
        this.context = context;
        view = initView();

    }

    public View getView(){
        return view;
    }

    public abstract View initView();
//    public  abstract View  inintboom();

    public void setData(){

    };
    public void setData(String url){

    };


}