package com.example.junqi.cool.Utils;

import com.example.junqi.cool.Bean.Homebean;

import org.json.JSONObject;

/**
 * Created by user on 2016/8/17.
 */
public class ParseUtils {
    //        解析json数据
     public static Homebean parseHomeJson(String json){
 //          把json字符串转换成JaonObject对象
             try {
                 JSONObject object=new JSONObject(json);
//                第二步 需要一个javabean对象
                 Homebean homebean=new Homebean();
                 homebean.data=homebean.new Data();
                 JSONObject dataobject=object.getJSONObject("data");
                 homebean.data.hp_author=dataobject.getString("hp_author");
                 homebean.data.hp_content=dataobject.getString("hp_content");
                 homebean.data.hp_img_original_url=dataobject.getString("hp_img_original_url");
                 homebean.data.last_update_date=dataobject.getString("last_update_date");
                 homebean.data.praisenum=dataobject.getInt("praisenum");
                 homebean.data.sharenum=dataobject.getInt("sharenum");
                 homebean.data.hp_title=dataobject.getString("hp_title");
                 homebean.data.hp_makettime=dataobject.getString("hp_makettime");
                 return homebean;
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return null;
         }
     }

