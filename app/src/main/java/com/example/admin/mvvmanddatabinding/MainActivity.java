package com.example.admin.mvvmanddatabinding;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.admin.mvvmanddatabinding.adapter.RecyclerAdapter;
import com.example.admin.mvvmanddatabinding.databinding.ActivityMainBinding;
import com.example.admin.mvvmanddatabinding.model.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.list.setLayoutManager(new LinearLayoutManager(this));
        PersonViewModel viewModel = ViewModelProviders.of(this).get(PersonViewModel.class);
        viewModel.getPersons().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable List<Person> people) {
                binding.list.setAdapter(new RecyclerAdapter(people, MainActivity.this));
            }
        });




    }
}
