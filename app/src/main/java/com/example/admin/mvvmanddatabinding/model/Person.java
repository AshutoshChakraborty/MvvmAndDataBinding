package com.example.admin.mvvmanddatabinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person extends BaseObservable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("imageurl")
    @Expose
    private String picUrl;


    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getPicUrl() {
        return picUrl;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        notifyPropertyChanged(BR.picUrl);
    }
}
