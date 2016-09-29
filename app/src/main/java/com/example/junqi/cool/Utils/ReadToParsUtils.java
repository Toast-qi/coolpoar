package com.example.junqi.cool.Utils;

import android.util.Log;

import com.example.junqi.cool.Bean.ReadTwoBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 2016/8/23.
 */
public class ReadToParsUtils {



    public  ReadTwoBean Json(String json) {
          try {
              JSONObject object = new JSONObject(json);
              ReadTwoBean readTwoBean = new ReadTwoBean();
              readTwoBean.data = readTwoBean.new Data();
              JSONObject dataobject = object.getJSONObject("data");
              Log.e("dataobject", "Json: "+dataobject);
              JSONArray essayList = dataobject.getJSONArray("essay");
              readTwoBean.data.essay = new ArrayList<>();
              for (int i = 0; i < essayList.length(); i++) {
                  ReadTwoBean.Essay essayData=readTwoBean.new Essay();
                  JSONArray arrayAuthor = essayList.getJSONArray(i);
                  essayData.author = new ArrayList<>();
                  JSONObject object0 = arrayAuthor.getJSONObject(0);
                  essayData.author.get(0).user_name = object0.getString("user_name");
                  readTwoBean.data.essay.add(essayData);
              }
return readTwoBean;
          } catch (JSONException e) {
              e.printStackTrace();
          }
          return null;
      }

}
