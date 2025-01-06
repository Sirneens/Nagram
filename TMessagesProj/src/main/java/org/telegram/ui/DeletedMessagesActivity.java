package org.telegram.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.telegram.messenger.DeletedMessagesManager;
import org.telegram.messenger.database.entities.DeletedMessage;
import java.util.List;

public class DeletedMessagesActivity extends AppCompatActivity {
    private DeletedMessagesManager deletedMessagesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleted_messages);

        deletedMessagesManager = new DeletedMessagesManager(this);

        // Example: Get deleted messages for account ID 1
        List<DeletedMessage> deletedMessages = deletedMessagesManager.getDeletedMessagesForAccount(1);

        // TODO: Display the deleted messages in a RecyclerView or ListView
    }
}
