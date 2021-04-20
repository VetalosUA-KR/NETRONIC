package com.vitalii.netronic.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.vitalii.netronic.pojo.Example;
import com.vitalii.netronic.pojo.Result;
import com.vitalii.netronic.service.ApiFactory;
import com.vitalii.netronic.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static final String TAG = "Repository";

    private ArrayList<Result> results = new ArrayList<>();
    private MutableLiveData<List<Result>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public Repository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Result>> getPersonsLiveData(int resultCount) {

        ApiService apiService = ApiFactory.getService();
        Call<Example> call = apiService.getPersons(resultCount);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                if (example != null && example.getResults() != null) {
                    mutableLiveData.setValue(example.getResults());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d(TAG, "ERROR: "+t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
