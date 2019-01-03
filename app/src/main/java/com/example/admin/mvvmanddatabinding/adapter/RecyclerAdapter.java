package com.example.admin.mvvmanddatabinding.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.admin.mvvmanddatabinding.R;
import com.example.admin.mvvmanddatabinding.databinding.ChildLayoutBinding;
import com.example.admin.mvvmanddatabinding.model.Person;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Person> personList;

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    public RecyclerAdapter(List<Person> personList, Context context) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ChildLayoutBinding binding = DataBindingUtil.inflate(from, R.layout.child_layout, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        Person person = personList.get(i);
        holder.setData(person);

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ChildLayoutBinding binding;

        public MyViewHolder(@NonNull ChildLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setData(Person person) {
            binding.setPerson(person);
            binding.executePendingBindings();
        }
    }
}
