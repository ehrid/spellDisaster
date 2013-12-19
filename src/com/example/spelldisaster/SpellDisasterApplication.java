package com.example.spelldisaster;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author horodysk
 */
public class SpellDisasterApplication extends Application {

    private static final String _PREFS = "spellDisaster_settings";

    private SharedPreferences _mPrefs;

    private static final String _SETTINGS_SOUND_LABEL = "sound";

    private static final String _SETTINGS_VOICE_LABEL = "voice";

    private static final String _SETTINGS_MIC_LABEL = "mic";

    private static final String _DIARY_CURRENT_PAGE = "diary_ppage";

    @Override
    public void onCreate() {
        super.onCreate();
        initializePreferences();
    }

    private void initializePreferences() {
        _mPrefs = getSharedPreferences(_PREFS, 0);
    }

    /**
     * Returns sound value form shared preferences
     */
    public boolean getSoundValue() {
        return _mPrefs.getBoolean(_SETTINGS_SOUND_LABEL, true);
    }

    /**
     * Returns voice value form shared preferences
     */
    public boolean getVoiceValue() {
        return _mPrefs.getBoolean(_SETTINGS_VOICE_LABEL, true);
    }

    /**
     * Returns microphone value form shared preferences
     */
    public boolean getMicValue() {
        return _mPrefs.getBoolean(_SETTINGS_MIC_LABEL, true);
    }

    /**
     * Returns current page value form shared preferences
     */
    public int getPageValue() {
        return _mPrefs.getInt(_DIARY_CURRENT_PAGE, 1);
    }

    /**
     * Sets new value for sound in shared preferences
     */
    public void setSoundValue(boolean value) {
        Editor e = _mPrefs.edit();
        e.putBoolean(_SETTINGS_SOUND_LABEL, value);
        e.commit();
    }

    /**
     * Sets new value for voice in shared preferences
     */
    public void setVoiceValue(boolean value) {
        Editor e = _mPrefs.edit();
        e.putBoolean(_SETTINGS_VOICE_LABEL, value);
        e.commit();
    }

    /**
     * Sets new value for microphone in shared preferences
     */
    public void setMicValue(boolean value) {
        Editor e = _mPrefs.edit();
        e.putBoolean(_SETTINGS_MIC_LABEL, value);
        e.commit();
    }

    /**
     * Sets new value for current page in shared preferences
     */
    public void setPageValue(int value) {
        Editor e = _mPrefs.edit();
        e.putInt(_DIARY_CURRENT_PAGE, value);
        e.commit();
    }
}
