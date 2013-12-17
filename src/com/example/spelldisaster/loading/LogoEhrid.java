package com.example.spelldisaster.loading;

import android.content.Intent;
import android.os.Bundle;

import com.example.spelldisaster.R;

/**
 * @author horodysk
 */
public class LogoEhrid extends BaseSplashscreanActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLogo(R.drawable.logo_ehrid);
    }

    @Override
    void startActivity() {
        Intent intent = new Intent(LogoEhrid.this, LogoUnity.class);
        startActivity(intent);
    }

}
