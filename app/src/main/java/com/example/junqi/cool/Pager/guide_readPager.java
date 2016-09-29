package com.example.junqi.cool.Pager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.junqi.cool.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/9/3.
 */
public class guide_readPager {
    View view, view1;
    Context context;
    int currentPositon;
    ImageView imageView, imageView1;
    List<View> listt;

    private static Bitmap small1(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(0.05f, 0.40f); //长和宽放大缩小的比例
        Bitmap Bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return Bmp;
    }
    private static Bitmap small2(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(0.05f, 0.40f); //长和宽放大缩小的比例
        Bitmap Bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return Bmp;
    }


    public guide_readPager(Context context, int currentPositon) {
        this.context = context;
        this.currentPositon = currentPositon;
    }

    public List initview1() {
        listt = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.activity_guide__read, null);
        imageView = (ImageView) view.findViewById(R.id.guide_read_img);
        view1 = inflater.inflate(R.layout.activity_guide_music, null);
        imageView1 = (ImageView) view1.findViewById(R.id.guide_music_music);
        listt.add(view);
        listt.add(view1);
        return listt;
    }

    public void setDaata() {
            switch (currentPositon) {
                case 0:
                    setDaata1();
                    break;
                case 1:
                    setDaata2();
                    break;
            }
    }

    //第一页
    public  void setDaata1() {
        AnimationDrawable drawable = new AnimationDrawable();
        for (int i = 1; i < 57; i++) {
            int id = context.getResources().getIdentifier("reading_guide_" + i, "drawable", context.getPackageName());
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id);
            Bitmap resizeBmp = small1(bitmap);
            Drawable drawable1 = new BitmapDrawable(resizeBmp);
            drawable.addFrame(drawable1, 80);

//            Drawable frame1 = context.getResources().getDrawable(id);
//            drawable.addFrame(frame1, 100);

        }
        drawable.setOneShot(true);
        imageView.setBackgroundDrawable(drawable);
        drawable.start();
    }

    //第二页
    public void setDaata2() {
        AnimationDrawable drawable1 = new AnimationDrawable();
        for (int i = 1; i < 68; i++) {
            int id = context.getResources().getIdentifier("music_guide_" + i, "drawable", context.getPackageName());
            Bitmap bitmap1 = BitmapFactory.decodeResource(context.getResources(), id);
            Bitmap resizeBmp = small2(bitmap1);
            Drawable drawable2 = new BitmapDrawable(resizeBmp);
            drawable1.addFrame(drawable2, 80);

//     Drawable frame = context.getResources().getDrawable(id);
//            drawable1.addFrame(frame, 100);
        }
        drawable1.setOneShot(true);
        imageView1.setBackgroundDrawable(drawable1);

        drawable1.start();
    }


}
