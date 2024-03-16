package com.sharipov.shoppingapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sharipov.shoppingapp.activities.ProductListActivity;
import com.sharipov.shoppingapp.adapters.CategoryListAdapter;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.FragmentProductBinding;
import com.sharipov.shoppingapp.model.Category;
import com.sharipov.shoppingapp.model.Classification;
import com.sharipov.shoppingapp.model.SubProduct;

import java.math.BigInteger;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class ProductFragment extends BaseFragment<FragmentProductBinding> {

    private ArrayList<Classification> classificationArrayList;
    private ArrayList<Category> categoryArrayList;
    private ArrayList<SubProduct> subProductArrayList;
    private CategoryListAdapter adapter;
    @Override
    protected FragmentProductBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentProductBinding.inflate(inflater, parent, toAttach);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        classificationArrayList = new ArrayList<>();
        categoryArrayList = new ArrayList<>();
        subProductArrayList = new ArrayList<>();
        adapter = new CategoryListAdapter(classificationArrayList, categoryArrayList, subProductArrayList);

        adapter.setSelectListener(new CategoryListAdapter.CategorySelectListener() {
            @Override
            public void onCategorySelected(String type, int itemId) {

                if (type.equals("CLASSIFICATION")) {
                    binding.topPanel.setVisibility(View.VISIBLE);
                    binding.textViewCategoryBack.setText("Classification");
                    loadCategories(itemId);

                } else if (type.equals("CATEGORY")) {
                    binding.topPanel.setVisibility(View.VISIBLE);
                    binding.textViewCategoryBack.setText("Category");
                    loadSubProducts(itemId);
                }else if (type.equals("SUBPRODUCT")){

                    Intent intent  = new Intent(getContext(), ProductListActivity.class);
                    intent.putExtra("subProduct", itemId);
                    startActivity(intent);

                    // move to Product List. Intent to New Activity.
                }
            }
        });


        getClassifications();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerViewProduct.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerViewProduct.setAdapter(adapter);

        binding.textViewCategoryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = adapter.moveBack();
                if (type.equals("CLASSIFICATION")){
                    binding.topPanel.setVisibility(View.GONE);
                }else if (type.equals("CATEGORY")){
                    binding.textViewCategoryBack.setText("Classification");

                }
            }
        });
    }

    private void getClassifications(){
        Call<ArrayList<Classification>> call = parent.mainApi.getClassification();


        call.enqueue(new RequestCallback<ArrayList<Classification>>() {
            @Override
            protected void onResponseSuccess(Call<ArrayList<Classification>> call, Response<ArrayList<Classification>> response) {
                classificationArrayList.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            protected void onResponseFailed(Call<ArrayList<Classification>> call, Throwable t) {

            }
        });
    }

    private void loadCategories(int classificationId){
        adapter.setType("CATEGORY");


        Call<ArrayList<Category>> call = parent.mainApi.getCategories(classificationId);

        call.enqueue(new RequestCallback<ArrayList<Category>>() {
            @Override
            protected void onResponseSuccess(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                categoryArrayList.clear();
                categoryArrayList.addAll(response.body());
                adapter.notifyDataSetChanged();

            }

            @Override
            protected void onResponseFailed(Call<ArrayList<Category>> call, Throwable t) {

            }
        });
    }

    private void loadSubProducts(int categoryId){
        adapter.setType("SUBPRODUCT");

        Call<ArrayList<SubProduct>> call = parent.mainApi.getSubProducts(categoryId);

        call.enqueue(new RequestCallback<ArrayList<SubProduct>>() {
            @Override
            protected void onResponseSuccess(Call<ArrayList<SubProduct>> call, Response<ArrayList<SubProduct>> response) {
                subProductArrayList.clear();
                subProductArrayList.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            protected void onResponseFailed(Call<ArrayList<SubProduct>> call, Throwable t) {

            }
        });
    }
}
