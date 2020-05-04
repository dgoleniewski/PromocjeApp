package com.e.promocjeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<Discount> discounts;
    Discount discount;

    public MyRecyclerViewAdapter(Context context, List<Discount> data) {
        this.context = context;
        this.discounts = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        discount = discounts.get(position);
        holder.imageView.setImageBitmap(discount.getImage());
        holder.titleTextView.setText(discount.getTitle());
        holder.opinionTextView.setText(String.valueOf(discount.getPoints()));
        holder.basicPriceTextView.setText(String.valueOf(discount.getBasicPrice()));
        holder.discountPriceTextView.setText(String.valueOf(discount.getDiscountPrice()));
    }

    @Override
    public int getItemCount() {
        return discounts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView, opinionTextView, basicPriceTextView, discountPriceTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            opinionTextView = itemView.findViewById(R.id.opinionTextView);
            basicPriceTextView = itemView.findViewById(R.id.basicPriceTextView);
            discountPriceTextView = itemView.findViewById(R.id.discountPriceTextView);
        }
    }
}
