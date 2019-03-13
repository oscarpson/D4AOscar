package com.digital4africa.oscar.presenter;

import com.digital4africa.oscar.model.PostList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @GET("get_recent_posts")
    Call<PostList> postlist();

     @GET("get_posts")
     Call<PostList> allpostlist();




}
