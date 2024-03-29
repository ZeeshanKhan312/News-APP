package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String Base_URL="https://newsapi.org/v2/";

    @GET("everything")
    Call<News> searchNews(
            @Query("q") String q,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<News> getNews(
        @Query("country") String country,
        @Query("pageSize") int pageSize,
        @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<News> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );
}
