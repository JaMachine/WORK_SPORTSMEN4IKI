package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class LoadingActivity extends AppCompatActivity {
    String fetchedData = "x";
    WebView loadingData;
    RelativeLayout loadingScreen;

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
                        }
                    }
                });

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingData.loadUrl(fetchedData);
                loadingScreen.setVisibility(View.GONE);
            }
        }, 1000);


    }
}