package com.example.hello.Network;

import com.example.hello.Home.Route.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("v2/local/search/keyword.json")
    Call<SearchResponse> getPlaces(
            @Header("Authorization") String key, @Query("y") String lat, @Query("x") String lon, @Query("Query") String query, @Query("size") Integer size);

}
