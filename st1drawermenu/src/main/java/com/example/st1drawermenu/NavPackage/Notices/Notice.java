package com.example.st1drawermenu.NavPackage.Notices;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-02-09.
 */

public class Notice implements Serializable {

    int id;
    String notice;
    String name;
    String date;
    String imagUrl;

    public Notice() {
    }

    public Notice(int id, String notice, String name, String date, String imagUrl) {
        this.id = id;
        this.notice = notice;
        this.name = name;
        this.date = date;
        this.imagUrl = imagUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImagUrl() {
        return imagUrl;
    }

    public void setImagUrl(String imagUrl) {
        this.imagUrl = imagUrl;
    }
}
