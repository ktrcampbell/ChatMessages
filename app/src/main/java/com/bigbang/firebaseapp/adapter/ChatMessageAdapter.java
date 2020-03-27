package com.bigbang.firebaseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bigbang.firebaseapp.R;
import com.bigbang.firebaseapp.model.ChatMessage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.ChatMessageViewHolder>{

    private List<ChatMessage>chatMessages;

    public ChatMessageAdapter(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    @NonNull
    @Override
    public ChatMessageAdapter.ChatMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.send_message_layout, parent, false);
        return new ChatMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatMessageAdapter.ChatMessageViewHolder holder, int position) {

        holder.usernameTextView.setText(chatMessages.get(position).getMessageUser());
        holder.timestampTextView.setText(chatMessages.get(position).getMessageTimeStamp());
        holder.messageTextView.setText(chatMessages.get(position).getMessageContent());

    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    public class ChatMessageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.username_textview)
        TextView usernameTextView;

        @BindView(R.id.timestamp_textview)
        TextView timestampTextView;

        @BindView(R.id.message_content_textview)
        TextView messageTextView;

        public ChatMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
