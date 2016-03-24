package com.xiaoheifamily.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Book extends EntityBase {

    private String googleBookId;
    private String title;
    @Lob
    private String description;
    private String image;

    public String getGoogleBookId() {
        return googleBookId;
    }

    public void setGoogleBookId(String googleBookId) {
        this.googleBookId = googleBookId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}