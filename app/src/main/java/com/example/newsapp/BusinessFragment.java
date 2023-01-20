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

public class BusinessFragment extends Fragment {
    String category="Business";
    Adapter adapter;
    RecyclerView businessRecyclerView;
    ArrayList<Model> newsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.business_fragment,null);
        businessRecyclerView=view.findViewById(R.id.businessRecyclerView);
        businessRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsList= new ArrayList<>();
        adapter=new Adapter(getContext(),newsList);
        businessRecyclerView.setAdapter(adapter);

        categoryNews(category, adapter, newsList);

        return view;
    }
}
