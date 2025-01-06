package org.telegram.ui;

import android.os.Bundle;
import androidx.preference.PreferenceActivity;
import androidx.preference.PreferenceFragmentCompat;
import org.telegram.messenger.R;
import org.telegram.messenger.config.AppConfig;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);

            findPreference("save_deleted_messages").setOnPreferenceChangeListener((preference, newValue) -> {
                AppConfig.setSaveDeletedMessages((boolean) newValue);
                return true;
            });
        }
    }
}
