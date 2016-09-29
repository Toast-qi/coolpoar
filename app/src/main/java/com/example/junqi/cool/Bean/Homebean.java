package com.example.junqi.cool.Bean;



/**
 * Created by user on 2016/8/9.
 */
public class Homebean {
   public Data data;
/***定义内部类
 * 是因为Data是一个jsonObject
 * 每一个jaonObject需要对应一个类型
 *
 * 在json数据中如果有jsonArray，就使用List集合的形式保存数据
 * List<>list;
 * */
    public class  Data{
        public String hp_author;
        public String hp_content;
        public  String hp_img_original_url;
        public  String last_update_date;
        public  String hp_makettime;
        public  int praisenum;
        public  int sharenum;
        public  String hp_title;








}

}
