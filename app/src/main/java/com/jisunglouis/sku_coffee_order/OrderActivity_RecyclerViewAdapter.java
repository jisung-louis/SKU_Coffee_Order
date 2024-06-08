package com.jisunglouis.sku_coffee_order;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderActivity_RecyclerViewAdapter extends RecyclerView.Adapter<OrderActivity_RecyclerViewAdapter.ViewHolder>{

    private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    OrderActivity_RecyclerViewAdapter(Context context, String[] data){
        this.mInflater= LayoutInflater.from(context);
        this.mData=data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup)
}
