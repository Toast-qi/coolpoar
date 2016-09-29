package com.example.junqi.cool.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.junqi.cool.R;

import java.net.URI;

public class WebViewActivity extends Activity {
    WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_web_view);
         Intent intent=getIntent();
        String s = intent.getStringExtra("url");
        webview= (WebView) findViewById(R.id.webview_movie);
        webview.loadUrl(s);

//        解决代码不能js问题
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webview.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(webview.canGoBack()){
//              判断是否可以回退
                webview.goBack();
                return true;
            }

        }

        return super.onKeyDown(keyCode, event);
    }
}