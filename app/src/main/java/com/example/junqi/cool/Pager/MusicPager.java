package com.example.junqi.cool.Pager;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.MusicBean;
import com.example.junqi.cool.Bean.MusicBean2;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by user on 2016/8/27.
 */
public class MusicPager {
   ImageView music_zhutu,mu_person_iv,music_lyric,music_gantan;
    TextView mu_person_tv,mu_person_tv2,mu_person_tv5,
            mu_person_tv6,music_title,story_author,
            story_content, story_bianji;
  ImageView music_image1,music_image2,music_image3;
    TextView music_text1,music_text11,
             music_text2,music_text22,
             music_text3,music_text33;



    Context context;
    int currentPostion;
    View view;
    String url;
    String url1;

    public MusicPager(Context context, int currentPostion, String url,String url1 ) {
        this.context = context;
        this.currentPostion = currentPostion;
        this.url=url;
        this.url1=url1;
    }
    public View inittview(){
        view=View.inflate(context, R.layout.item_musiclayout,null);
        music_lyric= (ImageView) view.findViewById(R.id.music_lyric);
        music_lyric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(context, LoginActivity.class);
//                context.startActivity(intent);
            }
        });
        return view;
    }
    public void ininDaata(){
        RequestParams params1=new RequestParams(url1);
        x.http().get(params1, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson=new Gson();
                MusicBean2  musicBean2=gson.fromJson(s,MusicBean2.class);
                music_image1= (ImageView) view.findViewById(R.id.music_image1);
                music_image2= (ImageView) view.findViewById(R.id.music_image2);
                music_image3= (ImageView) view.findViewById(R.id.music_image3);
                music_text1= (TextView) view.findViewById(R.id.music_text1);
                music_text2= (TextView) view.findViewById(R.id.music_text2);
                music_text3= (TextView) view.findViewById(R.id.music_text3);
                music_text11= (TextView) view.findViewById(R.id.music_text11);
                music_text22= (TextView) view.findViewById(R.id.music_text22);
                music_text33= (TextView) view.findViewById(R.id.music_text33);

                Glide.with(context).load(musicBean2.data.get(0).cover).into(music_image1);
                Glide.with(context).load(musicBean2.data.get(1).cover).into(music_image2);
                Glide.with(context).load(musicBean2.data.get(2).cover).into(music_image3);
                music_text1.setText(musicBean2.data.get(0).title);
                music_text2.setText(musicBean2.data.get(1).title);
                music_text3.setText(musicBean2.data.get(2).title);
                music_text11.setText(musicBean2.data.get(0).author.user_name);
                music_text22.setText(musicBean2.data.get(1).author.user_name);
                music_text33.setText(musicBean2.data.get(2).author.user_name);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
    public void  initData(){
        RequestParams params=new RequestParams(url);

        x.http().get(params, new Callback.CommonCallback<String>() {
         @Override
         public void onSuccess(String s) {
             Gson gson=new Gson();
             MusicBean  musciBean1=gson.fromJson(s,MusicBean.class);
             music_zhutu= (ImageView) view.findViewById(R.id.music_zhutu);
             mu_person_iv= (ImageView) view.findViewById(R.id.mu_person_iv);
             mu_person_tv= (TextView) view.findViewById(R.id.mu_person_tv);
             mu_person_tv2= (TextView) view.findViewById(R.id.mu_person_tv2);
             mu_person_tv5= (TextView) view.findViewById(R.id.mu_person_tv5);
             mu_person_tv6= (TextView) view.findViewById(R.id.mu_person_tv6);
             music_title= (TextView) view.findViewById(R.id.music_title);
             story_author= (TextView) view.findViewById(R.id.story_author);
             story_content= (TextView) view.findViewById(R.id.story_content);
             story_bianji= (TextView) view.findViewById(R.id.story_bianji);


             Glide.with(context).load(musciBean1.data.cover).into(music_zhutu);
             Glide.with(context).load(musciBean1.data.author.web_url).into(mu_person_iv);
             mu_person_tv.setText(musciBean1.data.author.user_name);
             mu_person_tv2.setText(musciBean1.data.author.desc);
             mu_person_tv5.setText(musciBean1.data.maketime);
             mu_person_tv6.setText(musciBean1.data.title);
             music_title.setText(musciBean1.data.story_title);
             story_author.setText(musciBean1.data.story_author.user_name);
             story_content.setText(musciBean1.data.story.replace("<br>",""));
             story_bianji.setText(musciBean1.data.charge_edt);
         }

         @Override
         public void onError(Throwable throwable, boolean b) {

         }

         @Override
         public void onCancelled(CancelledException e) {

         }

         @Override
         public void onFinished() {

         }
     });
    }

    public class MusicHolder{
        public ImageView music_liview_imag1;
        public ImageView music_image_heart;
        public TextView   music_listview_author;
        public TextView music_liview_comment;
        public TextView musci_liview_dianzan;
    }
}
