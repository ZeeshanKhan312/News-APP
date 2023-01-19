package com.example.newsapp;

import static com.example.newsapp.MainActivity.news;
import static com.example.newsapp.MainActivity.searchNews;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api="abf710fc482b48debbe6100332e3bd91";
    String country="in";
    Adapter adapter;
    RecyclerView homeRecyclerView;
    ArrayList<Model> newsList;
    androidx.appcompat.widget.SearchView searchBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,null);
        homeRecyclerView=view.findViewById(R.id.homeRecyclerView);
        newsList=new ArrayList<>();
        searchBar=view.findViewById(R.id.search_bar);

        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),newsList);
        homeRecyclerView.setAdapter(adapter);

        //find News
        news(country, adapter, newsList);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchNews(query,adapter,newsList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                    return false;
            }
        });



        return view;
    }
}
