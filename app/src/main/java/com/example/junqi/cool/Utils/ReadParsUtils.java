package com.example.junqi.cool.Utils;

import com.example.junqi.cool.Bean.ReadBean;

import org.json.JSONObject;

/**
 * Created by user on 2016/8/20.
 */
public class ReadParsUtils {
    public static ReadBean ParseReadBean(String json){

        try {JSONObject object=new JSONObject();
            ReadBean readBean=new ReadBean();
            readBean.data=readBean.new Read_Data();

            JSONObject dataobject=object.getJSONObject("data");
            readBean.data.bgcolor=dataobject.getString("bgcolor");
            readBean.data.bottom_text=dataobject.getString("bottom_text");
            readBean.data.cover=dataobject.getString("cover");
            readBean.data.pv_url=dataobject.getString("pv_url");
            readBean.data.title=dataobject.getString("title");

            return readBean;


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
