package com.sharipov.shoppingapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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

//            Glide.with(binding.imageViewProduct).load(product.getImageUrl()).into(binding.imageViewProduct);
        }
    }
}
