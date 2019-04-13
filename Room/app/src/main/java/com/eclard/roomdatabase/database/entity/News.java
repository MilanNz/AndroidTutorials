package com.eclard.roomdatabase.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Milan on 4/13/19.
 */
@Entity(tableName = "news")
public class News {

    // Do not forget auto increment.
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "news_title")
    private String title;

    @ColumnInfo(name = "news_description")
    private String description;

    @ColumnInfo(name = "news_body", typeAffinity = ColumnInfo.TEXT)
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}