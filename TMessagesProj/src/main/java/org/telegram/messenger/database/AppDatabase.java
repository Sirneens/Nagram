package org.telegram.messenger.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import org.telegram.messenger.database.entities.DeletedMessage;

@Database(entities = {DeletedMessage.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DeletedMessageDao deletedMessageDao();
}
