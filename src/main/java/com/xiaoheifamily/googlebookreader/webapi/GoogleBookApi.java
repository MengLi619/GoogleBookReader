package com.xiaoheifamily.googlebookreader.webapi;

import com.xiaoheifamily.googlebookreader.dto.Volumes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBookApi {

    @GET("books/v1/volumes")
    Call<Volumes> getVolumes(@Query("q") String query,
                             @Query("startIndex") int startIndex,
                             @Query("maxResults") int maxResults);
}