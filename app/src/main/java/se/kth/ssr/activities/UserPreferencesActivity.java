package se.kth.ssr.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import se.kth.ssr.R;

/**
 * Created by argychatzi on 7/11/14.
 */
public class UserPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preferences);
    }
}
