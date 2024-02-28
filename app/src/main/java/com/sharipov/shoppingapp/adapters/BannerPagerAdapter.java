package com.sharipov.shoppingapp.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sharipov.shoppingapp.base.BaseDialog;
import com.sharipov.shoppingapp.fragments.ImageFragment;
import com.sharipov.shoppingapp.model.Banner;

import java.util.ArrayList;

public class BannerPagerAdapter extends FragmentStateAdapter {

    ArrayList<Banner> bannerArrayList;

    public BannerPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Banner> bannerArrayList) {
        super(fragmentActivity);
        this.bannerArrayList = bannerArrayList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Banner banner = bannerArrayList.get(position);
        ImageFragment imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", banner.getImege());
        imageFragment.setArguments(bundle);

        return imageFragment;
    }

    @Override
    public int getItemCount() {
        return bannerArrayList.size();
    }
}
