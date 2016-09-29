package com.example.junqi.cool.Bean;

import java.util.List;

/**
 * Created by user on 2016/8/24.
 */
public class DuanPian {
    public Data data;

    public class Data {

        public String last_update_date;
        public String hp_title;
        public String hp_content;


        public List<Author> author;
    }

    public class Author {
        public String user_name;
        public String web_url;

    }

}
