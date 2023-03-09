package com.hfad.sound;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.karlotoy.perfectune.instance.PerfectTune;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TimerTask";

    TextView textView, cancel, start, timer;
    CountDownTimer cTimer = null;
    Handler handler = new Handler();
    boolean training_stop = false;
    int commandCount=0;
    int count=0;
    boolean flag=false;
    int[]  type2First,type2Second,type3First,type3Second,type4First,type4Second,type5First,
            type5Second,type6First,type6Second,specialType2First,specialType2Second;
    long startTime ;

    long endTime ;
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

                    flag=true;
                  commandCount=0;
                  //  startTimer(type3First[commandCount],0 , perfectTune,type3First);
                count=0;

                playSound(perfectTune,type2First);




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
        flag=false;
       // cTimer.onFinish();
    }

    void playSound(PerfectTune perfectTune,int[] array){
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (commandCount%2==0)
                perfectTune.playTune();
                if (array[commandCount]/100==count) {
                    perfectTune.stopTune();
                    count=0;
                    commandCount++;
                }
                if (flag==false||commandCount==array.length) {
                    perfectTune.stopTune();
                    t.cancel();
                    t.purge();
                    count=0;
                    commandCount=0;
                }
                    count++;
            }
        },0,100);
    }

    void fillArray () {
        type2First = new int[]{300, 700, 300, 700, 300, 700, 1000};
        type2Second = new int[]{200, 1000, 200, 1000, 200, 1000, 1000};

        specialType2First = new int[]{300,700,300,700,300,12000,1000};
        specialType2Second = new int[]{200,1000,200,1000,200,7000,1000};

        type3First = new int[]{1000};
        type3Second = new int[]{200};

        type4First = new int[]{200, 100, 200};
        type4Second = new int[]{200, 200, 200};

        type5First = new int[]{200, 100, 200, 100, 200};
        type5Second = new int[]{200, 200, 200, 1000, 1000};

        type6First = new int[]{200,100,200,100,1000};
        type6Second = new int[]{200,200,200,1000,1000};
    }
}
