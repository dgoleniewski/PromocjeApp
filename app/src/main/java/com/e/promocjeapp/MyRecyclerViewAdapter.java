package com.e.promocjeapp;

import android.content.Context;
import android.content.Intent;
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
        holder.basicPriceTextView.setText(String.valueOf(discount.getBasicPrice()));
        holder.discountPriceTextView.setText(String.valueOf(discount.getDiscountPrice()));
        holder.idTextView.setText(discount.getId());
    }

    @Override
    public int getItemCount() {
        return discounts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView titleTextView, opinionTextView, basicPriceTextView, discountPriceTextView, idTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            basicPriceTextView = itemView.findViewById(R.id.basicPriceTextView);
            discountPriceTextView = itemView.findViewById(R.id.discountPriceTextView);
            idTextView = itemView.findViewById(R.id.idTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context, DiscountActivity.class).putExtra("document",idTextView.getText()));
        }
    }
}
