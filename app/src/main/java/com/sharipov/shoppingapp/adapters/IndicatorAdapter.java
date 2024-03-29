package com.sharipov.shoppingapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.sharipov.shoppingapp.base.BaseListAdapter;
import com.sharipov.shoppingapp.base.BaseViewHolder;
import com.sharipov.shoppingapp.databinding.ItemIndecatorBinding;


public class IndicatorAdapter extends BaseListAdapter {

    private int selectedPosition = 0;

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    private int bannerListSize;

    public IndicatorAdapter(int bannerListSize) {
        this.bannerListSize = bannerListSize;
    }

    public void setBannerListSize(int bannerListSize) {
        this.bannerListSize = bannerListSize;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIndecatorBinding binding =  ItemIndecatorBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);

        return new IndicatorViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return bannerListSize;
    }


    class IndicatorViewHolder extends BaseViewHolder<ItemIndecatorBinding> {
        public IndicatorViewHolder(@NonNull ItemIndecatorBinding binding) {
            super(binding);
        }

        @Override
        protected void onBind(int position) {
            binding.dotImageView.setSelected(selectedPosition == position);
        }
    }
}
