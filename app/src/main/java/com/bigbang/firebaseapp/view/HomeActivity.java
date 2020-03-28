package com.bigbang.firebaseapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.bigbang.firebaseapp.R;
import com.bigbang.firebaseapp.adapter.ChatMessageAdapter;
import com.bigbang.firebaseapp.model.ChatMessage;
import com.bigbang.firebaseapp.viewmodel.ChatViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    private String username = "Katrina";
    private Observer<List<ChatMessage>> messageObservable;

    private ChatViewModel viewModel;

    @BindView(R.id.chat_message_receyclerview)
    RecyclerView chatRecyclerView;

    @BindView(R.id.message_edittext)
    EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(ChatViewModel.class);

        messageObservable = new Observer<List<ChatMessage>>() {
            @Override
            public void onChanged(List<ChatMessage> chatMessages) {
                displayMessages(chatMessages);
            }
        };
        viewModel.getChatMessages().observe(this, messageObservable);
    }

    private void displayMessages(List<ChatMessage> chatMessages) {
        ChatMessageAdapter chatMessage = new ChatMessageAdapter(chatMessages);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatRecyclerView.setAdapter(chatMessage);

    }

    @OnClick(R.id.send_button)
    public void sendMessage(View view){
        String message = "";
        if(!messageEditText.getText().toString().trim().isEmpty()) {
            message = messageEditText.getText().toString().trim();
            messageEditText.setText("");
            ChatMessage chatMessage = new ChatMessage(username, new SimpleDateFormat("MM/dd/yyyy",
                    Locale.US).format(new Date()), message);
            viewModel.sendNewMessage(chatMessage);
            Toast.makeText(this, "Message sent.", Toast.LENGTH_SHORT).show();
        }

    }
}



