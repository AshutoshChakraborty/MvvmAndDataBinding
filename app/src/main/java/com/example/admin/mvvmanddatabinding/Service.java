package com.example.admin.mvvmanddatabinding;

import com.example.admin.mvvmanddatabinding.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Person>> getPersonList();
}
