package org.telegram.messenger.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DeletedMessage {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int accountId;
    private long dialogId;
    private int messageId;
    private String messageContent;

    // Getters and setters
}
