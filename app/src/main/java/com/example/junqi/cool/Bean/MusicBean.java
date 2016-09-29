package com.example.junqi.cool.Bean;

/**
 * Created by user on 2016/8/27.
 */
public class MusicBean {
          public Data data;
    public class Data{
        ////            文中大图片
        public String cover;
        public String charge_edt;
        public String story_title;
        public String title;
        public String maketime;
        public String story;
        public Author author;
        public Story_author story_author;
            public class Story_author{
                public String user_name;
            }
        public class Author{

            public String web_url;
            public String user_name;
            public String desc;
        }
    }
}
