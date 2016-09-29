package com.example.junqi.cool.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 2016/8/16.
 */
public class HttpUtils {

      public static String httpGet(String path){
          String result="";
          InputStream inputStream = null;
          ByteArrayOutputStream outputStream = null;
        try {
            URL url=new URL(path);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
//            确定当前请求类型，必须大写  GET  POST
            connection.setRequestMethod("GET");
//           使用输入流把服务器的数据读入到内存中
             inputStream= connection.getInputStream();
//            准备把输入流读入到输出流中
             outputStream=new ByteArrayOutputStream();
//             字节数组，每次从输入流中读取的长度
            byte[]bytes=new byte[1024];
//            判断当次读取出来的字节有多少
            int len=0;
//            把输入流中的内容全部读入到输出流中
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
             result =new String( outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        return result;
    }
}

//    静态  path:图片地址
    public static Bitmap httpGetMap(String Path) {
        Bitmap bitmap = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            URL url = new URL(Path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            outputStream = new ByteArrayOutputStream();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return bitmap;
    }
}