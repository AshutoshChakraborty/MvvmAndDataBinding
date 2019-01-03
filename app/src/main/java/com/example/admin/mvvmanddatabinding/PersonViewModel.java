package com.example.admin.mvvmanddatabinding;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.admin.mvvmanddatabinding.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonViewModel extends ViewModel {
    MutableLiveData<List<Person>> personList;

    public LiveData<List<Person>> getPersons() {
        if (personList == null) {
            personList = new MutableLiveData<>();
            loadPersonList();
        }
        return personList;
    }

    private void loadPersonList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<List<Person>> call = service.getPersonList();
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                personList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {

            }
        });


    }
}
