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

    String dob,dom,place;

    public void UserDataDetail(String name,String img,String dob,String dom, String place,String uid){
        this.Name = name;
        this.imgUrl = img;
        this.dob = dob;
        this.dom = dom;
        this.place = place;
        this.uid= uid;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

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

    public Map<String, Object> toMappProfile() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", getName());
        result.put("profileImage", getImgUrl());
        result.put("dob", getDob());
        result.put("dom", getDom());
        result.put("place", getPlace());
        result.put("uid", getUid());
         return result;
    }
}
