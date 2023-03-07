package com.hfad.sound;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.karlotoy.perfectune.instance.PerfectTune;


public class MainActivity extends AppCompatActivity {

    TextView textView, cancel, start, timer;
    CountDownTimer cTimer = null;
    Handler handler = new Handler();
    boolean training_stop = false;
    int commandCount=0;
    int[]  type2First,type2Second,type3First,type3Second,type4First,type4Second,type5First,
            type5Second,type6First,type6Second,specialType2First,specialType2Second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        PerfectTune perfectTune = new PerfectTune();
        perfectTune.setTuneFreq(1400);
        //      perfectTune.playTune();
        fillArray ();
        textView = findViewById(R.id.ttttt);
        cancel = findViewById(R.id.t2);
        start = findViewById(R.id.t3);
        timer = findViewById(R.id.timer);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                training_stop = true;
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canselTimer();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                  commandCount=0;
                    startTimer(type5Second[commandCount],0 , perfectTune,type5Second);


            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commandCount=0;
                startTimer(type5First[commandCount],0 , perfectTune,type5First);
            }
        });
    }

    void startTimer(long mil,int flag, PerfectTune perfectTune, int[] array) {

        if (flag==0)
        perfectTune.playTune();
        cTimer = new CountDownTimer(mil, 100) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                if (commandCount!=-1) { // отмена работы таймера если пользователь остановил треннировку
                     perfectTune.stopTune();
                commandCount++;
                    if (array.length > commandCount) {
                        startTimer(array[commandCount], commandCount % 2, perfectTune, array);
                    }
                }
                else {
                    perfectTune.stopTune();
                    cTimer.cancel();
                }

            }
        };
        cTimer.start();
    }

    void canselTimer(){
        commandCount=-1;
        cTimer.onFinish();
    }

    void fillArray () {
        type2First = new int[]{300, 700, 300, 700, 300, 700, 1000};
        type2Second = new int[]{200, 1000, 200, 1000, 200, 1000, 1000};

        specialType2First = new int[]{300,700,300,700,300,12000,1000};
        specialType2Second = new int[]{200,1000,200,1000,200,7000,1000};

        type3First = new int[]{200};
        type3Second = new int[]{200};

        type4First = new int[]{200, 100, 200};
        type4Second = new int[]{200, 200, 200};

        type5First = new int[]{200, 100, 200, 100, 200};
        type5Second = new int[]{200, 200, 200, 1000, 1000};

        type6First = new int[]{200,100,200,100,1000};
        type6Second = new int[]{200,200,200,1000,1000};
    }
}
