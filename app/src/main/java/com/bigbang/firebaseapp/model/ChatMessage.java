package com.bigbang.firebaseapp.model;

public class ChatMessage {

    private String messageUser;
    private String messageContent;
    private String messageTimeStamp;

    public ChatMessage(String messageUser, String messageContent, String messageTimeStamp) {
        this.messageUser = messageUser;
        this.messageContent = messageContent;
        this.messageTimeStamp = messageTimeStamp;
    }

    public ChatMessage() {
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "messageUser='" + messageUser + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageTimeStamp='" + messageTimeStamp + '\'' +
                '}';
    }
    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public void setMessageTimeStamp(String messageTimeStamp) {
        this.messageTimeStamp = messageTimeStamp;
    }
}
