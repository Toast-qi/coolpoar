package com.example.junqi.cool.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.junqi.cool.R;
import com.example.junqi.cool.Dao.DbHelper;
import com.example.junqi.cool.Dao.StudentDao;

public class Login_zhuceActivity extends Activity {
        DbHelper dbHelper;
       StudentDao studentdao;
        Button login_zhuce_xiyibu;
          EditText login_zhuce_haoma,login_zhuce_duanxin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login_zhuce);
        login_zhuce_xiyibu= (Button) findViewById(R.id.login_zhuce_xiyibu);
        login_zhuce_haoma= (EditText) findViewById(R.id.login_zhuce_haoma);
        login_zhuce_duanxin= (EditText) findViewById(R.id.login_zhuce_duanxin);
        studentdao = new StudentDao(this);


        login_zhuce_xiyibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=login_zhuce_haoma.getText().toString();
                String str11= login_zhuce_duanxin.getText().toString();
                studentdao.insert(str1,str11);
                 Intent intent=new Intent(Login_zhuceActivity.this,Login_dengluActivity.class);

               if(login_zhuce_haoma.getText().toString().length()==11){
                   Toast.makeText(Login_zhuceActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                   startActivity(intent);
               }else {
                   Toast.makeText(Login_zhuceActivity.this,"请输入正确的11手机号码",Toast.LENGTH_SHORT).show();

               }


            }
        });

//    private  void inint(){
//        dbHelper=new DbHelper(this,"student.db",null,1);
//        studentdao=new StudentDao(this);
//    }
//    private void setData() {
//
//        Cursor cursor = studentdao.query("10086100100");
//        while (cursor.moveToNext()) {
//            Log.i("query", cursor.getString(1));
//            Log.i("query", cursor.getString(2));
////
//        }
//        Cursor cursor1 = studentdao.queryAll();
//        while (cursor1.moveToNext()) {
//            Log.i("queryALL", cursor1.getString(1));
//            Log.i("querAll", cursor1.getString(2));

//
        }


}

