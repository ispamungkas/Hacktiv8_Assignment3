package com.unknow.assignment3hacktiv8.network;

import com.unknow.assignment3hacktiv8.model.CovidModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstanceCovidAPI {

    private static String BASE_URL = "https://disease.sh/v3/covid-19/";

    private static Retrofit hitCovid(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Call<CovidModel> callCovidAPI = hitCovid().create(COVIDAPI.class).callCovidAll();
}
