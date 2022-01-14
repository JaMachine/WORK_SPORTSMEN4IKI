package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        WebView informationView = findViewById(R.id.informationView);
        informationView.setWebViewClient(new WebViewClient());
        informationView.loadUrl("https://sites.google.com/view/1047-privacy-policy-y");

    }
}