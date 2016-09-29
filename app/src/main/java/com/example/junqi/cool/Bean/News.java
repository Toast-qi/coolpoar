package com.example.junqi.cool.Bean;

/**
 * Created by user on 2016/8/13.
 */
public class News {

    private int img;
    private String title;
    private  String info;
    private  String neirong;

    public News(int img, String title, String info,String neirong) {
        this.img = img;
        this.title = title;
        this.info = info;
        this.neirong=neirong;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public String getNeirong(){
        return neirong;
    }
}
