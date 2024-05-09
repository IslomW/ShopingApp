package com.sharipov.shoppingapp.activities;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.adapters.ProductPagerAdapter;
import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.ActivityProductDetailsBinding;
import com.sharipov.shoppingapp.model.Image;
import com.sharipov.shoppingapp.model.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity<ActivityProductDetailsBinding> {

    private Product product;
    private ProductPagerAdapter adapter;
    private ArrayList<Image> imageArrayList;
    @Override
    protected ActivityProductDetailsBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityProductDetailsBinding.inflate(inflater);
    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int productId = getIntent().getIntExtra("product_id", 0);
        imageArrayList = new ArrayList<>();
        adapter = new ProductPagerAdapter(this, imageArrayList);
        binding.productViewPager.setAdapter(adapter);
        if (productId != 0){
            loadProductDetails(productId);
        }
    }

    private void loadProductDetails(int productId) {
        Call<Product> call = mainApi.getProductDetails(productId);

        call.enqueue(new RequestCallback<Product>() {
            @Override
            protected void onResponseSuccess(Call<Product> call, Response<Product> response) {
                product = response.body();
                createProductUI();
            }



            @Override
            protected void onResponseFailed(Call<Product> call, Throwable t) {

            }
        });
    }
    private void createProductUI() {
        if (product != null){
            binding.productBrand.setText(product.getBrand());
            binding.productTitle.setText(product.getTitle());
            binding.productDetails.setText(product.getDescription());
            binding.productPriceCurrent.setText(product.getPriceCurrentAsString());
            binding.productPriceOrginal.setText(product.getOrginalPriceAsString());
        }
    }




}
