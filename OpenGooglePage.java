package com.connect.s3a1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class OpenGooglePage extends AppCompatActivity {


    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_google_page);



        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);



        SharedPreferences pref = getApplicationContext().getSharedPreferences("SEARCHDATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
       String searchdata1= pref.getString("ed_searchdata", null);


        webView.loadUrl("https://www.google.co.in/search?q="+searchdata1);


    }

}
