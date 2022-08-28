package com.example.hello.Home.Route;

import com.google.gson.annotations.SerializedName;

public class SearchRequest {

    @SerializedName("query")
    private String query;

    @SerializedName("x")
    private String x;

    @SerializedName("y")
    private String y;

    @SerializedName("size")
    private String size;
}
