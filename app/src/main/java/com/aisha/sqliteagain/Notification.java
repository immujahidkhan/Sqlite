package com.aisha.sqliteagain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Aisha on 10/02/2018.
 */

public class Notification {

    int id;
    String title;
    String details;
    String dateTime;
    private byte[] image;

    public Notification(int id, String title, String details, String dateTime, byte[] image) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.dateTime = dateTime;
        this.image = image;
    }



    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}