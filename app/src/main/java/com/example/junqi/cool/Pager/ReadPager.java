package com.example.junqi.cool.Pager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.junqi.cool.Activity.ReadDpActivity;
import com.example.junqi.cool.Activity.ReadLianZai;
import com.example.junqi.cool.Activity.WenDaActivity;
import com.example.junqi.cool.Adapter.MyAdapter;
import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.News;
import com.example.junqi.cool.Bean.ReadTwoBean;
import com.example.junqi.cool.Utils.HttpUtils;
import com.google.gson.Gson;

import java.util.List;
public class ReadPager extends BasePager {
    private ListView lv;
    ReadTwoBean readTwoBean;
    private int currentPosition = 0;
    public ReadPager(Context context, int currentPosition) {
        super(context);
        this.currentPosition = currentPosition;

    }
    ListView listview;
    MyAdapter adapter;
    List<News> list;


    @Override
    public View initView() {
        Log.i("", "initView: =============++++++++++==========");
        view=View.inflate(context, R.layout.listview_read,null);
        listview = (ListView) view.findViewById(R.id.read_listview);
        Log.i("", "initView: =======================");
        return view;
    }
    @Override
    public void setData(String url){
        new MyAsyncTask().execute();
   }

    class MyAsyncTask extends AsyncTask<String, String, String>{

        public MyAsyncTask() {
        }
        @Override
        protected String doInBackground(String... strings) {
         String result= HttpUtils.httpGet("http://v3.wufazhuce.com:8000/api/reading/index/");
//           readTwoBean= new ReadToParsUtils().Json(result);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            Log.i("TAG1", "onPostExecute: " + s);
            readTwoBean=new ReadTwoBean();
            readTwoBean =  gson.fromJson(s, ReadTwoBean.class);
            Log.i("readTwoBean", "-----------。；模拟，: " + readTwoBean);
            Log.i("readTwoBean", "onPostExecute: " + readTwoBean.data.essay.get(0).hp_title);

            //传递的参数
            adapter = new MyAdapter(context, readTwoBean, currentPosition);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent=new Intent(context,ReadDpActivity.class);
//                context.startActivity(intent);

             switch (i){
                 case 0:
                     Intent intent=new Intent(context,ReadDpActivity.class);
                     context.startActivity(intent);
                     break;
                 case 1:
                     Intent intent1=new Intent(context, ReadLianZai.class);
                     context.startActivity(intent1);
                     break;
                 case 2:
                     Intent intent2=new Intent(context, WenDaActivity.class);
                     context.startActivity(intent2);
                     break;
             }





            }
        });
            super.onPostExecute(s);
        }
    }
//    @Override
//    public void setData() {
        //       listview在这里写
//        adapter = new MyAdapter(context,null );
//        listview.setAdapter(adapter);
//    }
//    private List<News> getData() {
//        list=new ArrayList<>();
//        News new1=new News(R.drawable.duanpian,"山茶花下","花开花落又是一季","里面的内容");
//        News new2=new News(R.drawable.lianzia,"这是一个大标题","庄生晓梦迷蝴蝶","里面的内容2");
//        News new3=new News(R.drawable.wenda,"又是一个大标题","此情可待成追忆","里面的内容3");
//
//        list.add(new1);
//        list.add(new2);
//        list.add(new3);
//        return list;
//    }

}
