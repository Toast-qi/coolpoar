package com.example.junqi.cool.Dao;

import android.content.Context;

import com.example.junqi.cool.Utils.ConstantUtils;

/**
 * Created by user on 2016/9/1.
 */
public class DBDao {
    Context context;
    DbHelper dbHelper;

    public DBDao(Context context) {
        this.context = context;
        dbHelper=new DbHelper(context,ConstantUtils.DB_NAME,null, ConstantUtils.DB_VERSION);
    }

}

