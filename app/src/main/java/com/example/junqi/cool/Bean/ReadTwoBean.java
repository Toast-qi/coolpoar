package com.example.junqi.cool.Bean;

import java.util.List;

/**
 * Created by user on 2016/8/22.
 */
public class ReadTwoBean {

    public Data data;

    public class Data {
        public List<Essay> essay;
        public List<Question> question;
        public List<Serial> serial;
    }

    public class Serial {
        public Author author;
        //        内容
        public String excerpt;
        //        连载标题
        public String title;


    }

    public class Question {
        public String question_title;
        public String answer_title;
        public String answer_content;
    }

    public class Essay {
        public List<Author> author;
        //        文章里面内容
        public String guide_word;
        //        中辣
        public String hp_title;
    }

    public class Author{
        //          作者的名字
        public String user_name;

    }

}
