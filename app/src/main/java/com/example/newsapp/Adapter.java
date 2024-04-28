package com.example.newsapp;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading,content,author,publishedAt;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading=itemView.findViewById(R.id.mainHeading);
            content=itemView.findViewById(R.id.content);
            author=itemView.findViewById(R.id.author);
            publishedAt=itemView.findViewById(R.id.published);
            imageView=itemView.findViewById(R.id.imageView);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }

    Context context;
    ArrayList<Model> modelArrayList;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,webView.class);
                intent.putExtra("url",modelArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.author.setText(modelArrayList.get(position).getAuthor());
        holder.publishedAt.setText(modelArrayList.get(position).getPublishedAt());
        holder.heading.setText(modelArrayList.get(position).getTitle());
        holder.content.setText(modelArrayList.get(position).getDescription());

        Glide.with(context).load(modelArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }



    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


}
