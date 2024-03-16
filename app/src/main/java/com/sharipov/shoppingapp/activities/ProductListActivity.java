package com.sharipov.shoppingapp.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.sharipov.shoppingapp.adapters.ProductListAdapter;
import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.base.BaseListAdapter;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.ActivityProductListBinding;
import com.sharipov.shoppingapp.model.Product;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Response;

public class ProductListActivity extends BaseActivity<ActivityProductListBinding> {

    private ArrayList<Product> productArrayList;
    private ProductListAdapter productListAdapter;
    @Override
    protected ActivityProductListBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityProductListBinding.inflate(inflater);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productArrayList = new ArrayList<>();
        productListAdapter = new ProductListAdapter(productArrayList);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerView.setAdapter(productListAdapter);



        int subProduct = getIntent().getIntExtra("subProduct", 0);

        if (subProduct > 0){
            loadProductList(subProduct);

        }






    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }

    private void loadProductList(int subProduct) {

        Call<ArrayList<Product>> call = mainApi.getProductsBySubProduct(subProduct);

        call.enqueue(new RequestCallback<ArrayList<Product>>() {
            @Override
            protected void onResponseSuccess(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                productArrayList.addAll(response.body());
                Log.d("PRODUCT", productArrayList.toString());

                productListAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onResponseFailed(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
    }
}
