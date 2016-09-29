package com.example.junqi.cool.Bean;

/**
 * Created by user on 2016/8/26.
 */
public class LianzaiBean {
    public Data data;

    public class Data{

        public String last_update_date;
        public String hp_title;
        public String content;
        public Author author;

           public class Author{
               public String user_name;
               public String web_url;

           }
    }



}
