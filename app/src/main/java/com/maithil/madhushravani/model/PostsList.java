package com.maithil.madhushravani.model;

public class PostsList {
    String name;
    String img;
    String postImg;
    String time;
    String text;
    String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PostsList(String uid,String postImg, String name, String text, String img, String time) {
        this.name = name;
        this.img = img;
        this.postImg = postImg;
        this.time = time;
        this.text = text;
        this.uid = uid;
    }

    public PostsList() {
    }
}
