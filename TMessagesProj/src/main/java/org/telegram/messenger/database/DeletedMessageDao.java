package org.telegram.messenger.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import org.telegram.messenger.database.entities.DeletedMessage;
import java.util.List;

@Dao
public interface DeletedMessageDao {
    @Insert
    void insert(DeletedMessage deletedMessage);

    @Query("SELECT * FROM DeletedMessage WHERE accountId = :accountId")
    List<DeletedMessage> getDeletedMessagesForAccount(int accountId);

    @Query("SELECT * FROM DeletedMessage WHERE dialogId = :dialogId")
    List<DeletedMessage> getDeletedMessagesForDialog(long dialogId);
}
