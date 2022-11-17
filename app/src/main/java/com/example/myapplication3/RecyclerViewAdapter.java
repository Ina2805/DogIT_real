package com.example.myapplication3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{

    Context context;
    ArrayList<DogItems> dogItemsArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<DogItems> dogItemsArrayList) {
        this.context = context;
        this.dogItemsArrayList = dogItemsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        DogItems dogItems = dogItemsArrayList.get(position);
        holder.imageView.setImageResource(dogItems.image);
        holder.textView.setText(dogItems.dogName);

    }

    @Override
    public int getItemCount() {
        return dogItemsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        ImageButton imageButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            imageButton = itemView.findViewById(R.id.imageButton);
        }
    }
}
