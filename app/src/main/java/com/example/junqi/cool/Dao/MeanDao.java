package com.example.junqi.cool.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by user on 2016/9/1.
 */
public class MeanDao extends DBDao{
//    Context context;
//    DbHelper dbHelper;

    public MeanDao(Context context) {
        super(context);
//        this.context = context;
//        dbHelper=new DbHelper(context,"menu.db",null,2);

    }

    public  void insert(String json,String date, String page){
//        获取数据库写的权限 一般都是更新
        SQLiteDatabase sqLiteDatabase= dbHelper.getWritableDatabase();
        String sql="insert into menu(json,date,page)values(?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{json,date,page});
//        ContentValues values=new ContentValues();
//        values.put("num",num);
//        values.put("name",name);
//        sqLiteDatabase.insert("student",null,values);
//        sqLiteDatabase.close();
    }

    public String query(String page){
        String result="";
        SQLiteDatabase sqLiteDatabase= dbHelper.getReadableDatabase();
        String sql="select * from menu where page=?";
        Cursor cursor= sqLiteDatabase.rawQuery(sql,new String[]{page});
        while (cursor.moveToNext()) {
           result= cursor.getString(0);
        }
        return result;
    }

    public Cursor queryAll(){
        SQLiteDatabase sqLiteDatabase= dbHelper.getReadableDatabase();
        String sql="select * from menu ";
        return  sqLiteDatabase.rawQuery(sql,null);
    }
    public void deleteAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("menu",null,null);
        db.close();
    }


}
