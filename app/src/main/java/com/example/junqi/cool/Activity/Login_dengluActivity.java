package com.example.junqi.cool.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junqi.cool.R;
import com.example.junqi.cool.Dao.StudentDao;

public class Login_dengluActivity extends Activity {
    TextView login_zhuce_zhuce;
    EditText login_edithaoma, login_editmima;
    StudentDao studentdao;
    Button login_denglu_denglu;

//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login_denglu);

        studentdao = new StudentDao(this);
        login_edithaoma = (EditText) findViewById(R.id.login_edithaoma);
        login_editmima = (EditText) findViewById(R.id.login_editmima);
        login_denglu_denglu = (Button) findViewById(R.id.login_denglu_denglu);
        login_denglu_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Login_dengluActivity.this, MainActivity.class);
                Cursor cursor = studentdao.query(login_edithaoma.getText().toString().trim(), login_editmima.getText().toString().trim());
                if (login_edithaoma.getText().toString().length()==11) {
                    if (cursor.moveToNext()) {
                        startActivity(intent1);
                        Toast.makeText(Login_dengluActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Login_dengluActivity.this, "您输入的账号或密码有误", Toast.LENGTH_SHORT).show();
                    }
                }else {


                    Toast.makeText(Login_dengluActivity.this, "请输入正确11位手机号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        login_zhuce_zhuce = (TextView) findViewById(R.id.login_zhuce_zhuce);
        login_zhuce_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_dengluActivity.this, Login_zhuceActivity.class);
                startActivity(intent);
                String str1 = login_edithaoma.getText().toString();
                String str2 = login_editmima.getText().toString();
                studentdao.query(str1, str2);


//                break;

            }
        });
    }

}
//        setData();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
////        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
//    }
//
////    private void setData() {
////
////        Cursor cursor = studentdao.query(login_edithaoma.getText().toString(),"");
////        while (cursor.moveToFirst()) {
////            Log.i("query", cursor.getString(1));
////            Log.i("query", cursor.getString(2));
//////
////        }
////        Cursor cursor1 = studentdao.queryAll();
////        while (cursor1.moveToNext()) {
////            Log.i("queryALL", cursor1.getString(1));
////            Log.i("querAll", cursor1.getString(2));
////
//
//        }
