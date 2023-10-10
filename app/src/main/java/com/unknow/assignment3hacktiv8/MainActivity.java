package com.unknow.assignment3hacktiv8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.unknow.assignment3hacktiv8.model.CovidModel;
import com.unknow.assignment3hacktiv8.network.InstanceCovidAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView cases,recovered,death;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cases = findViewById(R.id.totalCases);
        recovered = findViewById(R.id.totalRecovered);
        death = findViewById(R.id.totalDeath);

        callCovidApi();

    }

    private void setView(CovidModel model){
        cases.setText(model.getCases());
        recovered.setText(model.getRecovered());
        death.setText(model.getDeaths());
    }

    private void callCovidApi(){
        InstanceCovidAPI.callCovidAPI.enqueue(new Callback<CovidModel>() {
            @Override
            public void onResponse(Call<CovidModel> call, Response<CovidModel> response) {
                if(response.body() != null){
                    setView(response.body());
                }
            }

            @Override
            public void onFailure(Call<CovidModel> call, Throwable t) {
                Log.e("TAGGING", t.fillInStackTrace().toString());
            }
        });
    }
}