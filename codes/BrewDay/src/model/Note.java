package model;

import java.util.Date;

public class Note {
    private String content;
    private Date date;

    Note(String content, Date date) {
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
}
