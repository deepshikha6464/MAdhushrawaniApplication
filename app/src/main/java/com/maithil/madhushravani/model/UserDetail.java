package com.maithil.madhushravani.model;

public class UserDetail {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOcc() {
        return occ;
    }

    public void setOcc(String occ) {
        this.occ = occ;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public UserDetail() {
    }

    public UserDetail(String name, String dob, String dom, String place, String occ, String img) {
        this.name = name;
        this.dob = dob;
        this.dom = dom;
        this.place = place;
        this.occ = occ;
        this.img = img;
    }

    String name,dob,dom,place,occ,img;
}
