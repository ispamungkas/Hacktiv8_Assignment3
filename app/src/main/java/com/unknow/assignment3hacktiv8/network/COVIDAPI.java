package com.unknow.assignment3hacktiv8.network;

import com.unknow.assignment3hacktiv8.model.CovidModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface COVIDAPI {

    @GET("all")
    Call<CovidModel> callCovidAll();

}
