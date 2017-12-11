package com.dayneko.secure.entity;

/**
 * CODE: 5000 - OK
 * CODE: 6000 - InvalidValues
 * CODE: 7000 - ERROR
 */

public class ServerResponse
{
    private int status;
    private String content;

    public ServerResponse(int status, String content)
    {
        this.status = status;
        this.content = content;
    }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
