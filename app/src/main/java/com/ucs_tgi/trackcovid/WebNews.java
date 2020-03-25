package com.ucs_tgi.trackcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_news);
        WebView mywebview =  findViewById(R.id.covid_news_global);
        mywebview.loadUrl("https://www.worldometers.info/coronavirus/");
    }
}
