package com.jsgk.retrofit;

public class UserAPImodel {
    String fristname,lastname,imgAvatar;

    public UserAPImodel(String fristname, String lastname, String imgAvatar) {
        this.fristname = fristname;
        this.lastname = lastname;
        this.imgAvatar = imgAvatar;
    }

    public String getFristname() {
        return fristname;
    }

    public void setFristname(String fristname) {
        this.fristname = fristname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }
}
