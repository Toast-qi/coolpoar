package com.example.junqi.cool.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;


import com.example.junqi.cool.R;
import com.example.junqi.cool.Utils.ConstantUtils;

public class SplashActivity extends Activity {

    Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            SharedPreferences preferences = getSharedPreferences(ConstantUtils.SHARED_NAME, MODE_PRIVATE);
            boolean isFirstLogin = preferences.getBoolean(ConstantUtils.IS_FIRST_LOGIN, true);
            if(isFirstLogin){
                Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                startActivity(intent);
                finish();
            }else{
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setData();
    }

    private void setData(){
//     实现倒数三秒跳转,延迟发送消息功能
        handler.sendEmptyMessageDelayed(0,2000);
    }

}