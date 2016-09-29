package com.example.junqi.cool.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.junqi.cool.R;

public class ThreeActivity extends Activity {
    ImageView arrows,three_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate","ThreeActivity");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_three);
        arrows= (ImageView) findViewById(R.id.img_arrows);
        arrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThreeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        three_login= (ImageView) findViewById(R.id.three_login);
        three_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThreeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
