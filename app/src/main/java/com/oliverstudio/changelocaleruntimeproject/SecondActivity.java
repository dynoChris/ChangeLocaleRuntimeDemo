package com.oliverstudio.changelocaleruntimeproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    private void updateView(String lang) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(LocaleHelper.IS_CHANGE_LANGUAGE, true);
        editor.apply();

        LocaleHelper.setLocale(this, lang);
        recreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idClicked = item.getItemId();
        switch (idClicked) {
            case R.id.language_en:
                updateView(LocaleHelper.ENGLISH_LANGUAGE);
                break;
            case R.id.language_vi:
                updateView(LocaleHelper.VIETNAM_LANGUAGE);
                break;
        }
        return true;
    }
}
