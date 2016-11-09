package com.warren.meng.topnews.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.warren.meng.topnews.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private boolean isback = false;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置contentFeature,可使用切换动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setReturnTransition(new Fade());
        setContentView(R.layout.activity_splash);



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                View view = SplashActivity.this.findViewById(R.id.activity_splash);


                ActivityOptionsCompat optionsCompat =
                        ActivityOptionsCompat
                                .makeSceneTransitionAnimation(SplashActivity.this,
                                        view,"share");
                SplashActivity.this.startActivity(intent,optionsCompat.toBundle());
//                SplashActivity.this.finish();
                isback = true;
            }
        }, 2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isback) {
//            Toast.makeText(SplashActivity.this,"正在退出...",Toast.LENGTH_SHORT).show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    SplashActivity.this.finish();
                }
            }, 700);
        }
    }
}
