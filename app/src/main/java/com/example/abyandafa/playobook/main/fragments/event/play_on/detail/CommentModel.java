package com.example.abyandafa.playobook.main.fragments.event.play_on.detail;

/**
 * Created by Abyan Dafa on 27/10/2018.
 */

public class CommentModel {
    private String user;
    private String text;
    private String time;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CommentModel(String user, String text, String time) {
        this.user = user;
        this.text = text;
        this.time = time;
    }
}
