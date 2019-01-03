package com.example.admin.mvvmanddatabinding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.mvvmanddatabinding.adapter.RecyclerAdapter;
import com.example.admin.mvvmanddatabinding.model.Person;

import java.util.List;

public class ImageAdapter {
    @BindingAdapter("url")
    public static void setUrl(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView list, List<Person> people) {
        ((RecyclerAdapter) list.getAdapter()).setPersonList(people);
    }
}
