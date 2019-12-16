package com.example.moviedatabase;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("title")
    private String title;
    @SerializedName("img")
    private String img;
    @SerializedName("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    public String getUrl() {
        return url;
    }

}
