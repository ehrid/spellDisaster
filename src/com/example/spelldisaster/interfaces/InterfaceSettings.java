package com.example.spelldisaster.interfaces;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.spelldisaster.R;

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

    private static final String _PREFS = "spellDisaster_settings";

    private SharedPreferences _mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflated = initializeDialogBody();
        initializeLabels(inflated);
        initializeSwithces(inflated);
        setSwithcesValues();
        setSwithcesListener();
        setLabelsFont();
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

    private void setSwithcesValues() {
        _mPrefs = getSharedPreferences(_PREFS, 0);

        boolean sound = _mPrefs.getBoolean("sound", true);
        boolean voice = _mPrefs.getBoolean("voice", true);
        boolean mic = _mPrefs.getBoolean("mic", true);

        _sound.setActivated(sound);
        _voice.setActivated(voice);
        _mic.setActivated(mic);
    }

    private void setSwithcesListener() {
        _sound.setOnClickListener(this);
        _voice.setOnClickListener(this);
        _mic.setOnClickListener(this);
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
                saveNewSoundValue();
                break;
            case R.id.settings_voice:
                saveNewVoiceValue();
                break;
            case R.id.settings_mic:
                saveNewMicValue();
                break;
        }
    }

    private void saveNewSoundValue() {
        Editor e = _mPrefs.edit();
        e.putBoolean("sound", _sound.isChecked());
        e.commit();
    }

    private void saveNewVoiceValue() {
        Editor e = _mPrefs.edit();
        e.putBoolean("voice", _voice.isChecked());
        e.commit();
    }

    private void saveNewMicValue() {
        Editor e = _mPrefs.edit();
        e.putBoolean("mic", _mic.isChecked());
        e.commit();
    }
}
