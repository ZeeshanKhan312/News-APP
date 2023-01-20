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

public class ScienceFragment extends Fragment {
    String category="Science";
    Adapter adapter;
    RecyclerView scienceRecyclerView;
    ArrayList<Model> newsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.science_fragment,null);
        scienceRecyclerView=view.findViewById(R.id.scienceRecyclerView);
        scienceRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsList= new ArrayList<>();
        adapter=new Adapter(getContext(),newsList);
        scienceRecyclerView.setAdapter(adapter);

        //find Category wise news
        categoryNews(category, adapter, newsList);
        return view;
    }
}
