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

public class SportsFragment extends Fragment {
//    String api="abf710fc482b48debbe6100332e3bd91";
//    String country="in";
    String category="Sports";
    Adapter adapter;
    RecyclerView sportsRecyclerView;
    ArrayList<Model> newsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sports_fragment,null);
//        Bundle data=getArguments();
//        category= data.getString("Category");
        sportsRecyclerView=view.findViewById(R.id.sportsRecyclerView);
        sportsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsList= new ArrayList<>();
        adapter=new Adapter(getContext(),newsList);
        sportsRecyclerView.setAdapter(adapter);

        categoryNews(category,adapter, newsList);

//        //find Category wise news
//        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<News>() {
//            @Override
//            public void onResponse(Call<News> call, Response<News> response) {
//                newsList.addAll(response.body().getArticles());
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<News> call, Throwable t) {
//
//            }
//        });

        return view;
    }
}
