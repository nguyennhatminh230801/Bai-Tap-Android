package com.example.btvntuan4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class BanHangAdapter extends RecyclerView.Adapter<BanHangAdapter.ViewHolder>{
    List<Product> list;
    Context context;
    IOnClickItemProduct iOnClickItemProduct;

    public BanHangAdapter(List<Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setiOnClickItemProduct(IOnClickItemProduct iOnClickItemProduct) {
        this.iOnClickItemProduct = iOnClickItemProduct;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ImgProductShow;
        TextView ProductName;
        TextView PriceOfProduct;
        ImageView btnIncrease;
        TextView AmountProduct;
        ImageView btnDecrease;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgProductShow = itemView.findViewById(R.id.ImgProductShow);
            ProductName = itemView.findViewById(R.id.ProductName);
            PriceOfProduct = itemView.findViewById(R.id.PriceOfProduct);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            AmountProduct = itemView.findViewById(R.id.AmountProduct);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = list.get(position);
        holder.ImgProductShow.setImageResource(product.getImageItem());
        holder.ProductName.setText(product.getNameItem());
        holder.PriceOfProduct.setText(product.getPrice());
        holder.AmountProduct.setText(product.getAmount());
        holder.btnIncrease.setImageResource(product.getIncreaseItem());
        holder.btnDecrease.setImageResource(product.getDecreaseItem());
        holder.btnIncrease.setOnClickListener(v -> iOnClickItemProduct.onClickIncreaseButton(product));
        holder.btnDecrease.setOnClickListener(v -> iOnClickItemProduct.onClickDecreaseButton(product));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
