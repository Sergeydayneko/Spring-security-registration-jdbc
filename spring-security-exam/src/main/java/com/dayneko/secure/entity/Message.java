package com.dayneko.secure.entity;


import java.util.Date;

public class Message {

    private int message_id;
    private Date send_date;
    private User message_owner;
    private String ownerName;
    private String message_content;

    public int getMessage_id() {
        return message_id;
    }
    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public User getMessage_owner() {
        return message_owner;
    }
    public void setMessage_owner(User message_owner) {
        this.message_owner = message_owner;
    }

    public String getMessage_content() {
        return message_content;
    }
    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Date getSend_date() {
        return send_date;
    }
    public void setSend_date(Date send_date) {
        this.send_date = send_date;
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
        String content = getMessage_content();

        return name + " has send you a message with this content " + content;
    }
}