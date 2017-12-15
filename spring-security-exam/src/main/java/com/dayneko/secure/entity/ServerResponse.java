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
    private boolean valid;

    public ServerResponse(int status, String content, boolean valid)
    {
        this.status = status;
        this.content = content;
        this.valid = valid;
    }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public boolean getValid() { return valid; }
    public void setValid(boolean valid) { this.valid = valid; }
}
