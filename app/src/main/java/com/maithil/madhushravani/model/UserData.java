package com.maithil.madhushravani.model;

public class UserData {
    String Name,post,imgUrl,time;

    public UserData() {
    }

    public UserData(String name, String post, String imgUrl, String time) {
        Name = name;
        this.post = post;
        this.imgUrl = imgUrl;
        this.time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
