package com.example.allinone.elaniadnovel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class webhtml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webhtml);
        WebView webView =(WebView)findViewById(R.id.webview);

        Intent data=getIntent();

        int page=data.getExtras().getInt("page");
        page++;
       webView.loadUrl("file:///android_assets/html/html"+page);
    }
}
