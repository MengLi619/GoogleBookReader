package com.xiaoheifamily.bookstore.webapi;

import com.xiaoheifamily.bookstore.dto.Volumes;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBookApi {

    @GET("books/v1/volumes")
    Volumes getVolumes(@Query("q") String query);
}