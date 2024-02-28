package com.sharipov.shoppingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.FragmentImageBinding;

public class ImageFragment extends BaseFragment<FragmentImageBinding> {
    @Override
    protected FragmentImageBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentImageBinding.inflate(inflater, parent, toAttach);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String image = getArguments().getString("imageUrl");

        if (image!=null && !image.isEmpty()){
            Glide.with(binding.bannerImage).load(image).into(binding.bannerImage);
        }
    }
}
