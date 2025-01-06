package org.telegram.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.telegram.messenger.DeletedMessagesManager;
import org.telegram.messenger.DeletedMessagesAdapter;
import org.telegram.messenger.database.entities.DeletedMessage;
import java.util.List;

public class DeletedMessagesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DeletedMessagesAdapter adapter;
    private DeletedMessagesManager deletedMessagesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleted_messages);

        recyclerView = findViewById(R.id.deletedMessagesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        deletedMessagesManager = new DeletedMessagesManager(this);

        // Example: Get deleted messages for account ID 1
        List<DeletedMessage> deletedMessages = deletedMessagesManager.getDeletedMessagesForAccount(1);

        if (deletedMessages.isEmpty()) {
            findViewById(R.id.emptyStateTextView).setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            findViewById(R.id.emptyStateTextView).setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            adapter = new DeletedMessagesAdapter(this, deletedMessages);
            recyclerView.setAdapter(adapter);
        }
    }
}
