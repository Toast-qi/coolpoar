package com.example.junqi.cool.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.junqi.cool.R;

public class LoginActivity extends Activity {
    ImageView login_arrows;
    TextView  textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        textView= (TextView) findViewById(R.id.login_denglu);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,Login_dengluActivity.class);
                startActivity(intent);
            }
        });
        login_arrows= (ImageView) findViewById(R.id.login_arrows);
        login_arrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });
    }
}
