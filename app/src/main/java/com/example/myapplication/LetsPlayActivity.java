package com.example.myapplication;

import static android.graphics.Typeface.createFromAsset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class LetsPlayActivity extends AppCompatActivity {

    Sportsman gym;
    TextView move_disp, time_disp;
    int correctAnswer = 669, move = 14, points = 0, matchTime = 180, oneSecond = 1000;
    ArrayList<Integer> sportsmanIndex;
    RelativeLayout gameOverScreen;
    ImageView
            closeGame,
            information,
            finaleMessage,
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

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_play);
        move_disp = findViewById(R.id.move_disp);
        time_disp = findViewById(R.id.time_disp);
        finaleMessage = findViewById(R.id.final_message);
        gameOverScreen = findViewById(R.id.game_over_screen);
        time_disp.setTypeface(createFromAsset(getAssets(), "fonts/montserrat_bold.ttf"));
        move_disp.setTypeface(createFromAsset(getAssets(), "fonts/montserrat_bold.ttf"));
        sportsman = findViewById(R.id.sportsman);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score3 = findViewById(R.id.score3);
        information = findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        score4 = findViewById(R.id.score4);
        score5 = findViewById(R.id.score5);
        score6 = findViewById(R.id.score6);
        shadow1 = findViewById(R.id.shadow1);
        final Handler handler = new Handler();
        int moveTimer = 669;
        shadow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 1) {
                    score1.setImageResource(R.drawable.yes);
                    points++;
                } else {
                    score1.setImageResource(R.drawable.no);
                }
                score1.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        playNextMove();
                    }
                }, moveTimer);
            }
        });
        shadow2 = findViewById(R.id.shadow2);
        shadow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 2) {
                    points++;
                    score2.setImageResource(R.drawable.yes);
                } else {
                    score2.setImageResource(R.drawable.no);
                }
                score2.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        playNextMove();
                    }
                }, moveTimer);
            }
        });
        shadow3 = findViewById(R.id.shadow3);
        shadow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 3) {
                    score3.setImageResource(R.drawable.yes);
                    points++;
                } else {
                    score3.setImageResource(R.drawable.no);
                }
                score3.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        playNextMove();
                    }
                }, moveTimer);
            }
        });
        shadow4 = findViewById(R.id.shadow4);
        gameOverScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });
        shadow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 4) {
                    points++;
                    score4.setImageResource(R.drawable.yes);
                } else {
                    score4.setImageResource(R.drawable.no);
                }
                score4.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        playNextMove();
                    }
                }, moveTimer);
            }
        });
        shadow5 = findViewById(R.id.shadow5);
        shadow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 5) {
                    points++;
                    score5.setImageResource(R.drawable.yes);
                } else {
                    score5.setImageResource(R.drawable.no);
                }
                score5.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        playNextMove();
                    }
                }, moveTimer);
            }
        });
        shadow6 = findViewById(R.id.shadow6);
        shadow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 6) {
                    points++;
                    score6.setImageResource(R.drawable.yes);
                } else {
                    score6.setImageResource(R.drawable.no);
                }
                score6.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        playNextMove();
                    }
                }, moveTimer);
            }
        });
        sportsmanIndex = new ArrayList<>();
//        for (int i = 1; i < 16; i++) {
//            sportsmanIndex.add(i);
//        }
        sportsmanIndex.add(1);
        sportsmanIndex.add(2);
        sportsmanIndex.add(3);
        sportsmanIndex.add(4);
        sportsmanIndex.add(5);
        sportsmanIndex.add(6);
        sportsmanIndex.add(7);
        sportsmanIndex.add(8);
        sportsmanIndex.add(9);
        sportsmanIndex.add(10);
        sportsmanIndex.add(11);
        sportsmanIndex.add(11);
        sportsmanIndex.add(12);
        sportsmanIndex.add(13);
        sportsmanIndex.add(14);
        sportsmanIndex.add(15);
        gym = new Sportsman();
        newGame();


    }

    void newGame() {
        Collections.shuffle(sportsmanIndex);
        playNextMove();
        matchTime = 180;
        points = 0;
        move = 14;
        move_disp.setText("15/15");
        gameOverScreen.setVisibility(View.GONE);
        startTimer();
    }

    void playNextMove() {
        move_disp.setText((move) + "/15");
        score1.setVisibility(View.GONE);
        score2.setVisibility(View.GONE);
        score3.setVisibility(View.GONE);
        score4.setVisibility(View.GONE);
        score5.setVisibility(View.GONE);
        score6.setVisibility(View.GONE);
        if (move >= 0) {
            TypedArray newcomer = gym.get(this, sportsmanIndex.get(sportsmanIndex.get(move)));
            ArrayList<Integer> random = new ArrayList<>();
            random.add(1);
            random.add(2);
            random.add(3);
            random.add(4);
            random.add(5);
            random.add(6);
            Collections.shuffle(random);
            sportsman.setImageResource(newcomer.getResourceId(0, 0));
            shadow1.setImageResource(newcomer.getResourceId(random.get(0), 0));
            shadow2.setImageResource(newcomer.getResourceId(random.get(1), 0));
            shadow3.setImageResource(newcomer.getResourceId(random.get(2), 0));
            shadow4.setImageResource(newcomer.getResourceId(random.get(3), 0));
            shadow5.setImageResource(newcomer.getResourceId(random.get(4), 0));
            shadow6.setImageResource(newcomer.getResourceId(random.get(5), 0));
            for (int i = 0; i < random.size(); i++) {
                if (random.get(i) == 1) {
                    correctAnswer = i + 1;
                }
            }
            move--;
        } else {
            gameOver();
        }
    }

    void startTimer() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (matchTime == 180) time_disp.setText("03:00");
                if (matchTime < 180 && matchTime > 119) {
                    time_disp.setText("02:" + (matchTime - 120));
                    if ((matchTime - 120) < 10) time_disp.setText("02:0" + (matchTime - 120));
                }
                if (matchTime < 120 && matchTime > 59) {
                    time_disp.setText("01:" + (matchTime - 60));
                    if ((matchTime - 60) < 10) time_disp.setText("01:0" + (matchTime - 60));
                }
                if (matchTime < 60) {
                    time_disp.setText("00:" + matchTime);
                    if (matchTime < 10) time_disp.setText("00:0" + matchTime);
                }
                matchTime--;
                if (matchTime > 0) startTimer();

                if (matchTime < 1) gameOver();

            }
        }, oneSecond);
    }

    void gameOver() {
        gameOverScreen.setVisibility(View.VISIBLE);
        if (points < 8) finaleMessage.setImageResource(R.drawable.try_again);
        else finaleMessage.setImageResource(R.drawable.great);
    }


}