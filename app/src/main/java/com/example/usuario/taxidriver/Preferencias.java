package com.example.usuario.taxidriver;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Usuario on 28/12/2014.
 */
public class Preferencias extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);


    }
}
