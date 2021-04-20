package com.vitalii.netronic.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vitalii.netronic.pojo.Result;
import com.vitalii.netronic.repository.Repository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

     private LiveData<List<Result>> listLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }



    public LiveData<List<Result>> getListLiveData(int resultCount) {
        Repository repository = new Repository(getApplication());
        listLiveData = repository.getPersonsLiveData(resultCount);
        return listLiveData;
    }


}
