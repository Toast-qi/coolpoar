package com.example.junqi.cool.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 2016/8/30.
 */
public class StudentDao {
      Context context;
      DbHelper dbHelper;
     public StudentDao(Context context) {
        this.context=context;
         dbHelper=new DbHelper(context,"student.db",null,1);
    }

    //     往student表中  插入数据方法
    public  void insert(String num,String name){
//        获取数据库写的权限 一般都是更新
        SQLiteDatabase sqLiteDatabase= dbHelper.getWritableDatabase();
        String sql="insert into student(num,name)values(?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{num,name});
//        ContentValues values=new ContentValues();
//        values.put("num",num);
//        values.put("name",name);
//        sqLiteDatabase.insert("student",null,values);
//        sqLiteDatabase.close();
    }

    //    查询数据库方法,  使用数据库读数据库权限的时候，不能调用sqLiteDatabase.close();
    public Cursor query(String num,String name){
        SQLiteDatabase sqLiteDatabase= dbHelper.getReadableDatabase();
        String sql="select*from student where num=?and name=?";
        return sqLiteDatabase.rawQuery(sql,new String[]{num,name});
    }

    public Cursor queryAll(){
        SQLiteDatabase sqLiteDatabase= dbHelper.getReadableDatabase();
        String sql="select*from student ";
        return  sqLiteDatabase.rawQuery(sql,null);
    }

}


