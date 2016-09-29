package com.example.junqi.cool.Bean;

import java.util.List;

/**
 * Created by user on 2016/8/27.
 */
public class MusicBean2 {
      public List<Data> data;

      public class Data{
          public String cover;
          public String title;
          public Author author;

          public class Author{

              public String user_name;
          }
      }

}
