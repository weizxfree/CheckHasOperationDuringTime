package com.example.administrator.interfacedemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 *  检查一段时间内用户有无交互
 */

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private long time=1000*5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                handler.removeCallbacks(runnable);
                break;
            case MotionEvent.ACTION_UP:
                startAD();
                break;
        }
        return super.onTouchEvent(event);
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this,"5s未操作",Toast.LENGTH_LONG).show();
        }
    };
    public void startAD() {
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, time);
    }
}
