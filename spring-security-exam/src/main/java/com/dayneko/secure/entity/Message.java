package com.dayneko.secure.entity;


import java.util.Date;

public class Message {

    private int messageId;
    private Date sendDate;
    private User messageOwner;
    private String ownerName;
    private String messageContent;

    public int getMessageId() {
        return messageId;
    }
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public User getMessageOwner() {
        return messageOwner;
    }
    public void setMessageOwner(User messageOwner) {
        this.messageOwner = messageOwner;
    }

    public String getMessageContent() {
        return messageContent;
    }
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getSendDate() {
        return sendDate;
    }
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString(){
        String name = getOwnerName();
        String content = getMessageContent();

        return name + " has send you a message with this content " + content;
    }
}