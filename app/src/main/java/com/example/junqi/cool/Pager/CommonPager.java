package com.example.junqi.cool.Pager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.junqi.cool.Activity.LoginActivity;
import com.example.junqi.cool.Activity.ShareActivity;
import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.Homebean;
import com.example.junqi.cool.Dao.MeanDao;
import com.example.junqi.cool.Utils.HttpUtils;
import com.example.junqi.cool.Utils.ParseUtils;

/**
 * Created by user on 2016/8/13.
 */
public class CommonPager extends BasePager {
    //    中间大图片
    private ImageView image;
    //    VOL.
    private TextView home_tv1;
    //晚安作品。。
    private TextView ho_title;
    //    文件中文字部分
    private TextView ho_tv2;
    //   年月日 地球
    private TextView home_tv_earth;
    private ImageView home_im_earth;
    private Homebean homebean;
      private  ImageView home_diary;
     private  ImageView home_share;
    View view1;
     MeanDao meanDao;
    public CommonPager(Context context) {
        super(context);
        this.context = context;
    }

    Bitmap bitmap = null;
//    Handler handler = new Handler() {
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Bitmap bitmap = (Bitmap) msg.obj;
//            image.setImageBitmap(bitmap);
//            image.setScaleType(ImageView.ScaleType.FIT_XY);
//            Log.i("", "" + msg.obj + "");
//        }
//    };

    @Override
    public View initView() {
        Log.i("initview", "initview: ");
        view = View.inflate(context, R.layout.ho_fragment_one, null);
        image = (ImageView) view.findViewById(R.id.frag_one_iv);
        ho_title = (TextView) view.findViewById(R.id.ho_title);
        ho_tv2 = (TextView) view.findViewById(R.id.ho_tv2);
        home_tv1 = (TextView) view.findViewById(R.id.home_tv1);
        home_tv_earth = (TextView) view.findViewById(R.id.home_tv_earth);
        home_im_earth = (ImageView) view.findViewById(R.id.home_im_earth);
        home_share= (ImageView) view.findViewById(R.id.home_share);
        home_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ShareActivity.class);
                    context.startActivity(intent);

            }
        });
        home_diary= (ImageView) view.findViewById(R.id.home_diary);
        home_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }
        });
        return view;

    }

    @Override
    public void setData(String urll) {
        Log.e("TAG", "doInBackground----------------: " + urll);
       meanDao=new MeanDao(context);
        setDBData();
        new MyAsyncTask(urll).execute();

    }

    private void setUIData(){
        ho_title.setText(homebean.data.hp_author);
        ho_tv2.setText(homebean.data.hp_content);
        home_tv1.setText(homebean.data.hp_title);

        Log.e("----------", "======================: " + homebean.data.hp_makettime);
        home_tv_earth.setText(homebean.data.hp_makettime);
        Glide.with(context).load(homebean.data.hp_img_original_url).into(image);
    }

    private  void setDBData(){
      String json= meanDao.query("1");
        Log.e("json", "setDBData: " + json);
        homebean=ParseUtils.parseHomeJson(json);
        if(homebean != null){
            setUIData();
        }
    }

    class MyAsyncTask extends AsyncTask<String, String, Homebean> {
        public String urll;

        public MyAsyncTask(String urll) {
            this.urll = urll;
        }

        @Override
        protected Homebean doInBackground(String... strings) {

            String result = HttpUtils.httpGet(urll);
            Log.e("result", "doInBackground: "+result);
            if (!TextUtils.isEmpty(result)){
                meanDao.deleteAll();
                meanDao.insert(result,"12","1");
                Log.e("TAG", "doInBackground------123456----------: " + result);
                homebean = ParseUtils.parseHomeJson(result);
                Log.e("TAG", "doInBackgr=====----------: " + homebean.data.hp_title);
//            bitmap = HttpUtils.httpGetMap(homebean.data.hp_img_original_url);
                Log.e("", ""+homebean.data.hp_img_original_url);
            }


            return homebean;
        }

        @Override
        protected void onPostExecute(Homebean homebean) {

            if(homebean != null){
                setUIData();
            }
        }
    }



}