package com.bigbang.firebaseapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bigbang.firebaseapp.R;
import com.bigbang.firebaseapp.model.ChatMessage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class HomeActivity extends AppCompatActivity {

    //instatiate db reference
    DatabaseReference reference;
    private List<ChatMessage> chatMessages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create database instance to insert new message
        reference = FirebaseDatabase.getInstance().getReference().child("messages/");

        ChatMessage sendMessage = new ChatMessage("Katrina",
                "Is this working?", "03/26/2020");

        //push new message to db
        String pushValue = reference.push().getKey();
        if (pushValue != null) {

            Log.d("TAG_K", "Success : " + pushValue);
            reference.child(pushValue).setValue(sendMessage);

        } else {
            Log.d("TAG_K", "failed to push value");
        }

        //listen for changes and update db
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
                    //This is where recycler view steps in in all its glory
                    ChatMessage message = dSnapshot.getValue(ChatMessage.class);
                    chatMessages.add(message);
                }

                printChildMessages(chatMessages);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void printChildMessages(List<ChatMessage> chatMessages) {
        for (int i = 0; i < chatMessages.size() ; i++) {
            Log.d("TAG_K", chatMessages.get(i).toString());
        }
    }
}

