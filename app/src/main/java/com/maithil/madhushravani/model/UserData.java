package com.maithil.madhushravani.model;

import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    String Name;
    String post;
    String imgUrl;
    String time;
    String uid;
    String downloadURL;
    public UserData() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public UserData(String name, String post, String imgUrl, String time, String uid) {
        Name = name;
        this.post = post;
        this.imgUrl = imgUrl;
        this.time = time;
        this.uid = uid;
    }

    public UserData(String uid, String name, String imgUrl, String post, String time, String downloadURL) {
        Name = name;
        this.post = post;
        this.imgUrl = imgUrl;
        this.time = time;
        this.downloadURL = downloadURL;
        this.uid = uid;
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

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", getUid());
        result.put("name", getName());
        result.put("time", getTime());
        result.put("profileImage", getImgUrl());
        result.put("postImage", downloadURL);
        result.put("Text", getPost()
        );
         return result;
    }

    public Map<String, Object> toMapp() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", getUid());
        result.put("name", getName());
        result.put("time", getTime());
        result.put("profileImage", getImgUrl());
        result.put("Text", getPost()
        );
         return result;
    }
}
