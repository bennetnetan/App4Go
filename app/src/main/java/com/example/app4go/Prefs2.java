package com.example.app4go;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Prefs2 extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefs2);
        addPreferencesFromResource(R.xml.prefs);
    }
}
