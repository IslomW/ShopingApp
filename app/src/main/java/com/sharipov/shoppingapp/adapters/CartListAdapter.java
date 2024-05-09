package com.sharipov.shoppingapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.sharipov.shoppingapp.base.BaseListAdapter;
import com.sharipov.shoppingapp.base.BaseViewHolder;
import com.sharipov.shoppingapp.databinding.ItemCartBinding;
import com.sharipov.shoppingapp.databinding.ItemCategoryBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartListAdapter extends BaseListAdapter {

    private ArrayList<Cart> cartArrayList;

    public CartListAdapter(ArrayList<Cart> cartArrayList) {
        this.cartArrayList = cartArrayList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartBinding binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return cartArrayList.size();
    }

    public class CartViewHolder extends BaseViewHolder<ItemCartBinding>{

        public CartViewHolder(@NonNull ItemCartBinding binding) {
            super(binding);
        }

        @Override
        protected void onBind(int position) {
            Cart cart = cartArrayList.get(position);

            binding.tvProductTitle.setText(cart.getProduct().getTitle());

            Glide.with(binding.ivProductImage).load(cart.getProduct().getImage()).into(binding.ivProductImage);

            binding.tvColor.setText();
            binding.tvSize.setText();
            binding.tvPrice.setText();
            binding.tvQuantity.setText();

            int total_price = cart.getQuantity() * cart.getProduct().getPriceCurrent();
            DecimalFormat format = new DecimalFormat("###,###,###W");
            binding.tvTotalPrice.setText(format.format(total_price));
        }
    }
}
