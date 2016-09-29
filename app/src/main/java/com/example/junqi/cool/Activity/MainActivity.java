package com.example.junqi.cool.Activity;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.junqi.cool.Fragment.HomeFragment;
import com.example.junqi.cool.Fragment.MovieFragment;
import com.example.junqi.cool.Fragment.MusicFragment;
import com.example.junqi.cool.Fragment.ReadFragment;
import com.example.junqi.cool.R;

import static com.example.junqi.cool.R.drawable.disc_pause_gif;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    ImageView main_title1,main_person3;
    TextView main_title2;
    RadioButton home1,read2,music3,movie4;
            Fragment homeFrag,readFrag,musicFrag,movieFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        main_title1= (ImageView) findViewById(R.id.main_title1);
        main_title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        main_title2= (TextView) findViewById(R.id.main_title2);

        main_person3= (ImageView) findViewById(R.id.main_person3);
        main_person3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("onClick","MainActivity");
                Intent intent1=new Intent(MainActivity.this,ThreeActivity.class);
                startActivity(intent1);
            }
        });
        home1= (RadioButton) findViewById(R.id.main_radio_home);
        read2= (RadioButton) findViewById(R.id.main_radio_read);
        music3= (RadioButton) findViewById(R.id.main_radio_music);
        movie4= (RadioButton) findViewById(R.id.main_radio_movie);

        home1.setOnClickListener(this);
        read2.setOnClickListener(this);
        music3.setOnClickListener(this);
        movie4.setOnClickListener(this);



        homeFrag=new HomeFragment();
        readFrag=new ReadFragment();
        musicFrag=new MusicFragment();
        movieFrag=new MovieFragment();
        switchFragment(homeFrag);


    }
    public void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fram_layout,fragment).commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_radio_home:
                main_title2.setText("ONE");
                switchFragment(homeFrag);

                break;
            case R.id.main_radio_read:
                switchFragment(readFrag);
                main_title2.setText("阅读");
                break;
            case R.id.main_radio_music:
                switchFragment(musicFrag);
                main_title2.setText("音乐");
                break;
            case R.id.main_radio_movie:
                main_title2.setText("电影");
                switchFragment(movieFrag);
                break;
        }
    }
}
