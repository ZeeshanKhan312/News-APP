package com.example.newsapp;

import static com.example.newsapp.MainActivity.categoryNews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {
    String category="Health";
    Adapter adapter;
    RecyclerView healthRecyclerView;
    ArrayList<Model> newsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.health_fragment,null);
        healthRecyclerView=view.findViewById(R.id.healthRecyclerView);
        healthRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsList= new ArrayList<>();
        adapter=new Adapter(getContext(),newsList);
        healthRecyclerView.setAdapter(adapter);

        //find Category wise news
        categoryNews(category, adapter, newsList);

        return view;
    }
}
