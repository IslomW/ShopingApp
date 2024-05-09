package com.sharipov.shoppingapp.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sharipov.shoppingapp.fragments.ImageFragment;
import com.sharipov.shoppingapp.model.Banner;
import com.sharipov.shoppingapp.model.Image;

import java.util.ArrayList;

public class ProductPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Image> imageArrayList ;

    public ProductPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Image> imageArrayList) {
        super(fragmentActivity);
        this.imageArrayList = imageArrayList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Image image = imageArrayList.get(position);
        ImageFragment imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", image.getImage());
        imageFragment.setArguments(bundle);

        return imageFragment;
    }

    @Override
    public int getItemCount() {
        return bannerArrayList.size();
    }
}
