package com.example.spelldisaster.interfaces.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.spelldisaster.R;
import com.example.spelldisaster.SpellDisasterApplication;
import com.example.spelldisaster.interfaces.BaseInterfaceActivity;

/**
 * @author horodysk
 */
public class InterfaceSettings extends BaseInterfaceActivity {

    private TextView _soundLabel;

    private TextView _voiceLabel;

    private TextView _micLabel;

    private ToggleButton _sound;

    private ToggleButton _voice;

    private ToggleButton _mic;

    private SpellDisasterApplication _app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();
        initializeLabels(inflated);
        setLabelsFont();

        initializeSwithces(inflated);
        setSwithcesListener();
        setSwithcesValues();
    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_settings);
        View inflated = stub.inflate();
        return inflated;
    }

    private void initializeLabels(View inflated) {
        _soundLabel = (TextView) inflated.findViewById(R.id.settings_sound_text);
        _voiceLabel = (TextView) inflated.findViewById(R.id.settings_voice_text);
        _micLabel = (TextView) inflated.findViewById(R.id.settings_mic_text);
    }

    private void initializeSwithces(View inflated) {
        _sound = (ToggleButton) inflated.findViewById(R.id.settings_sound);
        _voice = (ToggleButton) inflated.findViewById(R.id.settings_voice);
        _mic = (ToggleButton) inflated.findViewById(R.id.settings_mic);
    }

    private void setSwithcesListener() {
        _sound.setOnClickListener(this);
        _voice.setOnClickListener(this);
        _mic.setOnClickListener(this);
    }

    private void setSwithcesValues() {
        _app = (SpellDisasterApplication) getApplication();

        _sound.setChecked(_app.getSoundValue());
        _voice.setChecked(_app.getVoiceValue());
        _mic.setChecked(_app.getMicValue());
    }

    private void setLabelsFont() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/YouRookMarbelous.ttf");
        _soundLabel.setTypeface(font);
        _voiceLabel.setTypeface(font);
        _micLabel.setTypeface(font);
    }

    @Override
    protected void onClickAction(View v) {
        switch (v.getId()) {
            case R.id.settings_sound:
                _app.setSoundValue(_sound.isChecked());
                break;
            case R.id.settings_voice:
                _app.setVoiceValue(_voice.isChecked());
                break;
            case R.id.settings_mic:
                _app.setMicValue(_mic.isChecked());
                break;
        }
    }
}
