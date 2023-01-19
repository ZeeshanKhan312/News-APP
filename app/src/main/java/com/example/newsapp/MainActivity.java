 package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tHome,tSports,tBusiness, tEntertainment, tHealth, tScience, tTechnology;
    androidx.appcompat.widget.Toolbar toolbar;
    PageAdapter pageAdapter;
   static String api="abf710fc482b48debbe6100332e3bd91";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //set toolbar to act as an actionBar



        tHome=findViewById(R.id.home);
        tSports=findViewById(R.id.sports);
        tBusiness=findViewById(R.id.business);
        tEntertainment=findViewById(R.id.entertainment);
        tHealth=findViewById(R.id.health);
        tScience=findViewById(R.id.science);
        tTechnology=findViewById(R.id.technology);
        tabLayout=findViewById(R.id.TabLayout);

        ViewPager viewPager=findViewById(R.id.fragment_container);

        //to set the viewpager according to the tabNo
        pageAdapter= new PageAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pageAdapter);

        //if tab is changed
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5||tab.getPosition()==6)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    public static void news(String country, Adapter adapter, ArrayList<Model> newsList){
        newsList.clear();
        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }

    public static void categoryNews(String country, String category, Context context,Adapter adapter, ArrayList<Model>newsList){
//        ArrayList<Model>newsList= new ArrayList<>();
//        Adapter adapter=new Adapter(context,newsList);
        //find Category wise news
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }

    public static void searchNews(String q, Adapter adapter, ArrayList<Model>newsList){
        newsList.clear();
        ApiUtilities.getApiInterface().searchNews(q,100,api).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
}