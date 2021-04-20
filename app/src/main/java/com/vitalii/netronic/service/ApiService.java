package com.vitalii.netronic.service;

import com.vitalii.netronic.pojo.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    ////https://randomuser.me/api/?results=2

    @GET("?")
    Call<Example> getPersons(
            @Query("results") long results
    );

}
