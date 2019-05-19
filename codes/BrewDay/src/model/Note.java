package model;

import java.util.Date;

public class Note {
    private String title;
    private String content;
    private Date date;

    Note(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
