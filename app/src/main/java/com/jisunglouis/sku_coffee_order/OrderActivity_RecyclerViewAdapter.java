package com.jisunglouis.sku_coffee_order;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderActivity_RecyclerViewAdapter extends RecyclerView.Adapter<OrderActivity_RecyclerViewAdapter.ViewHolder>{

    private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    OrderActivity_RecyclerViewAdapter(Context context, String[] data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.order_coffee_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.myTextView.setText(mData[position]);
    }
    public int getItemCount(){
        return mData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.coffeeCategory);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
        String getItem(int id) {
            return mData[id];
        }
        void setClickListener(ItemClickListener itemClickListener){
            this.mClickListener = itemClickListener;
        }
        public interface ItemClickListener{
            void onItemClick(View view, int position);
        }
    }
