package de.andreasschrade.androidtemplate.ui;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

import de.andreasschrade.androidtemplate.R;
import de.andreasschrade.androidtemplate.ui.base.BaseActivity;
import de.andreasschrade.androidtemplate.ui.base.ChangePassActivity;
import de.andreasschrade.androidtemplate.ui.base.LoginActivity;

/**
 * This Activity provides several settings. Activity contains {@link PreferenceFragment} as inner class.
 *
 * Created by Andreas Schrade on 14.12.2015.
 */
public class SettingsActivity extends BaseActivity {
    private Button button_cp;
    private Button button_lg;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupToolbar();
        button_cp =(Button)findViewById(R.id.button_cp);
        button_cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_cp();
            }
        });
        button_lg =(Button)findViewById(R.id.button_lg);
        button_lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                log_out();
            }
        });

    }

    private void log_out(){
        FirebaseAuth.getInstance().signOut();
        finishAffinity();
        Intent y =new Intent(this,LoginActivity.class);
        startActivity(y);
    }
    private void setupToolbar() {
        final ActionBar ab = getActionBarToolbar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openDrawer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void open_cp(){
        Intent i =new Intent(SettingsActivity.this,ChangePassActivity.class);
        startActivity(i);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return R.id.nav_settings;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }

    public static class SettingsFragment extends PreferenceFragment {
        public SettingsFragment() {}

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_prefs);
        }
    }
}
