package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class LetsPlayActivity extends AppCompatActivity {

    ImageView
            sportsman,
            shadow1,
            shadow2,
            shadow3,
            shadow4,
            shadow5,
            shadow6,
            score1,
            score2,
            score3,
            score4,
            score5,
            score6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_play);
        sportsman = findViewById(R.id.sportsman);
        shadow1 = findViewById(R.id.shadow1);
        shadow2 = findViewById(R.id.shadow2);
        shadow3 = findViewById(R.id.shadow3);
        shadow4 = findViewById(R.id.shadow4);
        shadow5 = findViewById(R.id.shadow5);
        shadow6 = findViewById(R.id.shadow6);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score3 = findViewById(R.id.score3);
        score4 = findViewById(R.id.score4);
        score5 = findViewById(R.id.score5);
        score6 = findViewById(R.id.score6);

    }
}