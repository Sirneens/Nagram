package org.telegram.messenger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.telegram.messenger.database.entities.DeletedMessage;
import java.util.List;

public class DeletedMessagesAdapter extends RecyclerView.Adapter<DeletedMessagesAdapter.ViewHolder> {

    private final Context context;
    private final List<DeletedMessage> deletedMessages;

    public DeletedMessagesAdapter(Context context, List<DeletedMessage> deletedMessages) {
        this.context = context;
        this.deletedMessages = deletedMessages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.deleted_message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DeletedMessage message = deletedMessages.get(position);
        holder.messageContentTextView.setText(message.getMessageContent());
        holder.messageMetadataTextView.setText("Deleted on: " + message.getDeletedTimestamp());
    }

    @Override
    public int getItemCount() {
        return deletedMessages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView messageContentTextView;
        TextView messageMetadataTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageContentTextView = itemView.findViewById(R.id.messageContentTextView);
            messageMetadataTextView = itemView.findViewById(R.id.messageMetadataTextView);
        }
    }
}
