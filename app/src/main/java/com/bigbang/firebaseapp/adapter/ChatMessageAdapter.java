package com.bigbang.firebaseapp.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bigbang.firebaseapp.model.ChatMessage;

import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.ChatMessageViewHolder>{

    private List<ChatMessage>chatMessages;

    public ChatMessageAdapter(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    @NonNull
    @Override
    public ChatMessageAdapter.ChatMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatMessageAdapter.ChatMessageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    public class ChatMessageViewHolder extends RecyclerView.ViewHolder {
        public ChatMessageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
