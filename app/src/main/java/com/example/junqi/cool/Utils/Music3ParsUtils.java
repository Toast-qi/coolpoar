package com.example.junqi.cool.Utils;

import com.example.junqi.cool.Bean.MusciBean3;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by user on 2016/8/28.
 */
public class Music3ParsUtils {
    public static MusciBean3 musciBean3(String json){
        try{
            JSONObject object=new JSONObject(json);
            MusciBean3 musciBean3=new MusciBean3();
            musciBean3.data=musciBean3.new Data();
            JSONObject dataobject = object.getJSONObject("data");
            JSONArray  dataList=dataobject.getJSONArray("data1");
//               musciBean3.data.data1=new ArrayList<>();




        } catch (Exception e) {
            e.printStackTrace();
        }
             return null;
    }
}
