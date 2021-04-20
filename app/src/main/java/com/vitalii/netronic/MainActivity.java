package com.vitalii.netronic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.vitalii.netronic.adapters.PersonAdapter;
import com.vitalii.netronic.pojo.Result;
import com.vitalii.netronic.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private PersonAdapter adapter;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewModel();
        initPersonAdapter();
        if(savedInstanceState == null) {
            getPersons(20);
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("key", new ArrayList<Result>(adapter.getPersons()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        List<Result> persons = savedInstanceState.getParcelableArrayList("key");
        adapter.setPersons(persons);
    }

    private void getPersons(int resultCount) {
        mainActivityViewModel.getListLiveData(resultCount).observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                adapter.setPersons(results);
            }
        });
    }

    private void initViewModel() {
        if(mainActivityViewModel == null) {
            mainActivityViewModel = new ViewModelProvider
                    .AndroidViewModelFactory(getApplication())
                    .create(MainActivityViewModel.class);
        }
    }

    private void initPersonAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPosters);
        adapter = new PersonAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setClickListener();
    }

    private void setClickListener() {
        adapter.setOnPersonClickListener(new PersonAdapter.OnPersonClickListener() {
            @Override
            public void onPersonClick(int position) {
                Result person = adapter.getPersons().get(position);
                Intent intent = new Intent(getApplication(), DetailsActivity.class);
                intent.putExtra(Result.class.getSimpleName(), person);
                startActivity(intent);
            }
        });
    }


}