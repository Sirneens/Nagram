package org.telegram.messenger;

import android.content.Context;
import org.telegram.messenger.database.AppDatabase;
import org.telegram.messenger.database.entities.DeletedMessage;
import java.util.List;

public class DeletedMessagesManager {
    private final AppDatabase database;

    public DeletedMessagesManager(Context context) {
        database = AppDatabase.getInstance(context);
    }

    public List<DeletedMessage> getDeletedMessagesForAccount(int accountId) {
        return database.deletedMessageDao().getDeletedMessagesForAccount(accountId);
    }

    public List<DeletedMessage> getDeletedMessagesForDialog(long dialogId) {
        return database.deletedMessageDao().getDeletedMessagesForDialog(dialogId);
    }
}
