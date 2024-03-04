package com.sharipov.shoppingapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import com.sharipov.shoppingapp.adapters.BannerPagerAdapter;
import com.sharipov.shoppingapp.adapters.IndicatorAdapter;
import com.sharipov.shoppingapp.adapters.ProductListAdapter;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.FragmentHomeBinding;
import com.sharipov.shoppingapp.model.Banner;
import com.sharipov.shoppingapp.model.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    private ArrayList<Banner> bannerArrayList;
    private BannerPagerAdapter bannerPagerAdapter;

    private ArrayList<Product> productArrayList;
    private ProductListAdapter productListAdapter;

    private IndicatorAdapter indicatorAdapter;


    @Override
    protected FragmentHomeBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentHomeBinding.inflate(inflater, parent, toAttach);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bannerArrayList = new ArrayList<>();
        bannerPagerAdapter = new BannerPagerAdapter(getActivity(), bannerArrayList);
        indicatorAdapter = new IndicatorAdapter(bannerArrayList.size());

        productArrayList = new ArrayList<>();
        productListAdapter = new ProductListAdapter(productArrayList);


    }


    @Override
    public void onStart() {
        super.onStart();

        loadProducts();
        loadBanners();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.viewPagerBanner.setAdapter(bannerPagerAdapter);
        binding.indicatorRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.indicatorRecyclerView.setAdapter(indicatorAdapter);

        binding.recyclerViewProduct.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        binding.recyclerViewProduct.setAdapter(productListAdapter);


        binding.viewPagerBanner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                indicatorAdapter.setSelectedPosition(position);
                indicatorAdapter.notifyDataSetChanged();
            }
        });


    }


    private void loadBanners() {
        Call<ArrayList<Banner>> call = parent.mainApi.getBanners();

        call.enqueue(new RequestCallback<ArrayList<Banner>>() {
            @Override
            protected void onResponseSuccess(Call<ArrayList<Banner>> call, Response<ArrayList<Banner>> response) {
                bannerArrayList.addAll(response.body());
                bannerPagerAdapter.notifyDataSetChanged();
                indicatorAdapter.setBannerListSize(bannerArrayList.size());
                indicatorAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onResponseFailed(Call<ArrayList<Banner>> call, Throwable t) {

            }
        });
    }


    private void loadProducts(){
       Call<ArrayList<Product>> call = parent.mainApi.getPopularProduct();
       call.enqueue(new RequestCallback<ArrayList<Product>>() {
           @Override
           protected void onResponseSuccess(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
               productArrayList.addAll(response.body());
               productListAdapter.notifyDataSetChanged();

               Log.d("PRODUCT", productArrayList.toString());
           }

           @Override
           protected void onResponseFailed(Call<ArrayList<Product>> call, Throwable t) {

               Log.e("ERROR", t.getLocalizedMessage());
           }
       });
    }
}
