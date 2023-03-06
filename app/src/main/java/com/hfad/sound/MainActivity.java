package com.hfad.sound;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.karlotoy.perfectune.instance.PerfectTune;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PerfectTune perfectTune = new PerfectTune();
        perfectTune.setTuneFreq(1124);
  //      perfectTune.playTune();
        textView=findViewById(R.id.ttttt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perfectTune.playTune();
                SystemClock.sleep(200);
                perfectTune.stopTune();
                SystemClock.sleep(100);
                perfectTune.playTune();
                SystemClock.sleep(200);
                perfectTune.stopTune();
                SystemClock.sleep(100);
                perfectTune.playTune();
                SystemClock.sleep(200);
                perfectTune.stopTune();
            }
        });
        int b = 0;
        /*CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                for (int i=10000;i>0;i--) {
                    perfectTune.setTuneAmplitude(i);
                }
            }

            @Override
            public void onFinish() {
                perfectTune.stopTune();
            }
        }.start();*/

       // while (a!=0){
        //type 2
       /* perfectTune.playTune();
        SystemClock.sleep(300);
        perfectTune.stopTune();
        SystemClock.sleep(700);
        perfectTune.playTune();
        SystemClock.sleep(300);
        perfectTune.stopTune();
        SystemClock.sleep(700);
        perfectTune.playTune();
        SystemClock.sleep(300);
        perfectTune.stopTune();
        SystemClock.sleep(700);
        perfectTune.playTune();
        SystemClock.sleep(1000);
        perfectTune.stopTune();*/

        //type2b
       /* perfectTune.playTune();
        SystemClock.sleep(200);
        perfectTune.stopTune();
        SystemClock.sleep(1000);
        perfectTune.playTune();
        SystemClock.sleep(200);
        perfectTune.stopTune();
        SystemClock.sleep(1000);
        perfectTune.playTune();
        SystemClock.sleep(200);
        perfectTune.stopTune();
        SystemClock.sleep(1000);
        perfectTune.playTune();
        SystemClock.sleep(1000);
        perfectTune.stopTune();*/


        //type 5
     /*   perfectTune.playTune();
        SystemClock.sleep(200);
        perfectTune.stopTune();
        SystemClock.sleep(100);
        perfectTune.playTune();
        SystemClock.sleep(200);
        perfectTune.stopTune();
        SystemClock.sleep(100);
        perfectTune.playTune();
        SystemClock.sleep(200);
        perfectTune.stopTune();*/
          /*  perfectTune.setTuneAmplitude(10000);
            SystemClock.sleep(1000);
        perfectTune.setTuneAmplitude(100);
        SystemClock.sleep(100);
        perfectTune.stopTune();*/
        /*perfectTune.setTuneAmplitude(9000);
        SystemClock.sleep(100);
        perfectTune.setTuneAmplitude(8000);
        SystemClock.sleep(100);
        perfectTune.setTuneAmplitude(7000);
        SystemClock.sleep(100);
        perfectTune.setTuneAmplitude(6000);
        SystemClock.sleep(100);
        perfectTune.setTuneAmplitude(5000);
        SystemClock.sleep(100);
        perfectTune.setTuneAmplitude(4000);
        SystemClock.sleep(100);
        perfectTune.setTuneAmplitude(3000);
        SystemClock.sleep(100);
        perfectTune.setTuneAmplitude(2000);
        SystemClock.sleep(100);
        perfectTune.setTuneAmplitude(1000);
        SystemClock.sleep(100);*/




        //    SystemClock.sleep(1);
        //}

       // while (a != 0) {
           /* Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(77);
                    perfectTune.setTuneAmplitude(a);
                    a = a - 1;
                }
            }, 10);*/
       // }
    }
}



