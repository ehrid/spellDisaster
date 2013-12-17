package com.example.spelldisaster.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.spelldisaster.R;
import com.example.spelldisaster.interfaces.BaseInterfaceActivity;

/**
 * @author horodysk
 */
public class SplashScreanActivity extends Activity {

    private static final int TIME = 4 * 1000;// 4 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(SplashScreanActivity.this, BaseInterfaceActivity.class);
                startActivity(intent);

                finish();

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        }, TIME);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // not needed
            }
        }, TIME);

    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

}
