package com.sharipov.shoppingapp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.sharipov.shoppingapp.activities.ProductDetailsActivity;
import com.sharipov.shoppingapp.base.BaseListAdapter;
import com.sharipov.shoppingapp.base.BaseViewHolder;
import com.sharipov.shoppingapp.databinding.ItemProductBinding;
import com.sharipov.shoppingapp.model.Product;

import java.util.ArrayList;

public class ProductListAdapter extends BaseListAdapter {

    private ArrayList<Product> productArrayList;

    public ProductListAdapter(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding binding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ProductDetailsActivity.class);
                intent.putExtra("product_id", productArrayList.get(position).id);
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ProductViewHolder extends BaseViewHolder<ItemProductBinding> {

        public ProductViewHolder(@NonNull ItemProductBinding binding) {
            super(binding);
        }

        @Override
        protected void onBind(int position) {
            Product product = productArrayList.get(position);
            binding.textViewProduct.setText(product.getTitle());
            binding.textViewBrand.setText(product.getBrand());
            binding.textViewPrice.setText(product.getCurrentPrice());
            binding.textViewDiscount.setText(product.getOrginalPrice());

            if (product.getImage() != null){
                Glide.with(binding.imageViewProduct).load(product.getImage().getImage()).into(binding.imageViewProduct);
            }

        }
    }
}
