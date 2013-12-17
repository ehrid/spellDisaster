package com.example.spelldisaster.loading;

import android.content.Intent;
import android.os.Bundle;

import com.example.spelldisaster.R;
import com.example.spelldisaster.activities.MainActivity;

/**
 * @author horodysk
 */
public class LogoUnity extends BaseSplashscreanActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLogo(R.drawable.logo_unity);
    }

    @Override
    void startActivity() {
        Intent intent = new Intent(LogoUnity.this, MainActivity.class);
        startActivity(intent);
    }

}
