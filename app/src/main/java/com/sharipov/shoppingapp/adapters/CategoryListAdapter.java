package com.sharipov.shoppingapp.adapters;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.base.BaseListAdapter;
import com.sharipov.shoppingapp.base.BaseViewHolder;
import com.sharipov.shoppingapp.databinding.FragmentProductBinding;
import com.sharipov.shoppingapp.databinding.ItemCategoryBinding;
import com.sharipov.shoppingapp.model.Category;
import com.sharipov.shoppingapp.model.Classification;
import com.sharipov.shoppingapp.model.Product;
import com.sharipov.shoppingapp.model.SubProduct;

import java.util.ArrayList;

public class CategoryListAdapter extends BaseListAdapter {

    ArrayList<Classification> classificationArrayList;
    ArrayList<Category> categoryArrayList;
    ArrayList<SubProduct> subProductArrayList;


    private String type = "CLASSIFICATION";

    private CategorySelectListener selectListener;

    public void setSelectListener(CategorySelectListener selectListener) {
        this.selectListener = selectListener;
    }

    public void setType(String type) {
        this.type = type;
        notifyDataSetChanged();
    }

    public CategoryListAdapter(ArrayList<Classification> classificationArrayList, ArrayList<Category> categoryArrayList, ArrayList<SubProduct> subProductArrayList) {
        this.classificationArrayList = classificationArrayList;
        this.categoryArrayList = categoryArrayList;
        this.subProductArrayList = subProductArrayList;

    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, @SuppressLint("RecyclerView") int position) {
        super.onBindViewHolder(holder, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectListener != null) {

                    int id = 0;

                    switch (type) {
                        case "CLASSIFICATION":
                            id = classificationArrayList.get(position).getId();
                            break;
                        case "CATEGORY":

                            id = categoryArrayList.get(position).getId();
                            break;
                        case "SUBPRODUCT":
                            id = subProductArrayList.get(position).getId();
                            break;
                    }
                    if (id != 0)
                        selectListener.onCategorySelected(type, id);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        int size = 0;

        switch (type) {
            case "CLASSIFICATION":
                size = classificationArrayList.size();
                break;
            case "CATEGORY":

                size = categoryArrayList.size();
                break;
            case "SUBPRODUCT":
                size = subProductArrayList.size();
                break;
        }
        return size;
    }

    public String moveBack() {
        if (type.equals("SUBPRODUCT")) {
            type = "CATEGORY";
        } else if (type.equals("CATEGORY")) {
            type = "CLASSIFICATION";
        }
        notifyDataSetChanged();
        return type;
    }


    class CategoryViewHolder extends BaseViewHolder<ItemCategoryBinding> {
        public CategoryViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding);
        }

        @Override
        protected void onBind(int position) {
            if (type.equals("CLASSIFICATION")) {
                Classification classification = classificationArrayList.get(position);
                binding.textViewCategoryNext.setText(classification.getTitle());
            } else if (type.equals("CATEGORY")) {

                Category category = categoryArrayList.get(position);
                binding.textViewCategoryNext.setText(category.getTitle());

            } else if (type.equals("SUBPRODUCT")) {
                SubProduct subProduct = subProductArrayList.get(position);
                binding.textViewCategoryNext.setText(subProduct.getTitle());


            }
        }
    }


    public interface CategorySelectListener {
        void onCategorySelected(String type, int itemId);
    }

}
