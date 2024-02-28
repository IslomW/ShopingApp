package com.sharipov.shoppingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.adapters.BannerPagerAdapter;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.FragmentHomeBinding;
import com.sharipov.shoppingapp.model.Banner;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    private ArrayList<Banner> bannerArrayList;
    private BannerPagerAdapter bannerPagerAdapter;
    @Override
    protected FragmentHomeBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentHomeBinding.inflate(inflater, parent, toAttach);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bannerArrayList = new ArrayList<>();
        bannerPagerAdapter = new BannerPagerAdapter(getActivity(), bannerArrayList);
    }


    @Override
    public void onStart() {
        super.onStart();
        loadBanners();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.viewPagerBanner.setAdapter(bannerPagerAdapter);
    }


    private void loadBanners() {
        Call<ArrayList<Banner>> call = parent.mainApi.getBanners();

        call.enqueue(new RequestCallback<ArrayList<Banner>>() {
            @Override
            protected void onResponseSuccess(Call<ArrayList<Banner>> call, Response<ArrayList<Banner>> response) {
                bannerArrayList.addAll(response.body());
                bannerPagerAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onResponseFailed(Call<ArrayList<Banner>> call, Throwable t) {

            }
        });
    }
}
