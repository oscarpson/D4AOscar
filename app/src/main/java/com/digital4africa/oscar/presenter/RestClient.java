package com.digital4africa.oscar.presenter;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    public static ApiService apiService;
    static {setRetrofitClient();}

    private static void setRetrofitClient() {
        Gson gson= new Gson();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService=retrofit.create(ApiService.class);
    }

    public static ApiService getApiService(){return apiService;}
}
