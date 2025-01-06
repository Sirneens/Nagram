package org.telegram.messenger.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppConfig {
    private static final String SAVE_DELETED_MESSAGES_KEY = "save_deleted_messages";
    private static SharedPreferences preferences;

    public static void init(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean isSaveDeletedMessagesEnabled() {
        return preferences.getBoolean(SAVE_DELETED_MESSAGES_KEY, false);
    }

    public static void setSaveDeletedMessages(boolean enabled) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(SAVE_DELETED_MESSAGES_KEY, enabled);
        editor.apply();
    }
}
