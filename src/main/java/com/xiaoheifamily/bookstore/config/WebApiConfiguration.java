package com.xiaoheifamily.bookstore.config;

import com.xiaoheifamily.bookstore.webapi.GoogleBookApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class WebApiConfiguration {

    private static final String GoogleApiBaseUrl = "https://www.googleapis.com";

    @Bean
    public GoogleBookApi googleBookApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GoogleApiBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GoogleBookApi.class);
    }
}