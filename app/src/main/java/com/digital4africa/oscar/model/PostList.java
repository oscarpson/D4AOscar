package com.digital4africa.oscar.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PostList {
    @SerializedName("posts")
    ArrayList<Posts>posts;

    public ArrayList<Posts> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Posts> posts) {
        this.posts = posts;
    }
}
