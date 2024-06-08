package com.jisunglouis.sku_coffee_order;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class OrderActivity_RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private int selectedPosition = -1;
    public static final int VIEW_TYPE_1 = 1;
    public static final int VIEW_TYPE_2 = 2;
    private int viewType;

    // 생성자
    public OrderActivity_RecyclerViewAdapter(Context context, String[] data, int viewType) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.viewType = viewType;
    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_1) {
            view = mInflater.inflate(R.layout.order_coffee_category, parent, false);
            return new CategoryViewHolder(view);
        } else {
            view = mInflater.inflate(R.layout.order_coffee_list, parent, false);
            return new CoffeeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String item = mData[position];
        if (holder instanceof CategoryViewHolder) {
            CategoryViewHolder categoryHolder = (CategoryViewHolder) holder;
            categoryHolder.myTextView.setText(item);
            if (position == selectedPosition) {
                categoryHolder.myTextView.setPaintFlags(categoryHolder.myTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            } else {
                categoryHolder.myTextView.setPaintFlags(categoryHolder.myTextView.getPaintFlags() & (~Paint.UNDERLINE_TEXT_FLAG));
            }
        } else if (holder instanceof CoffeeViewHolder) {
            CoffeeViewHolder coffeeHolder = (CoffeeViewHolder) holder;
            coffeeHolder.myTextView.setText(item);
        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        CategoryViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.coffeeCategory);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition(), viewType);
        }
    }

    public class CoffeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        CoffeeViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.coffeeList_coffeeName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition(), viewType);
        }
    }

    // 아이템 클릭 리스너를 설정하는 메서드
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // 선택된 위치를 설정하는 메서드 추가
    public void setSelectedPosition(int position) {
        selectedPosition = position;
        notifyDataSetChanged();
    }

    // 아이템 클릭 리스너 인터페이스
    public interface ItemClickListener {
        void onItemClick(View view, int position, int viewType);
    }
}