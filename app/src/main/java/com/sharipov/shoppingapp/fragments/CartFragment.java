package com.sharipov.shoppingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sharipov.shoppingapp.adapters.CartListAdapter;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.FragmentCartBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class CartFragment extends BaseFragment<FragmentCartBinding> {

    private ArrayList<Cart> cartArrayList;
    private CartListAdapter adapter;

    @Override
    protected FragmentCartBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentCartBinding.inflate(inflater, parent, toAttach);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartArrayList = new ArrayList<>();
        adapter = new CartListAdapter(cartArrayList);

    }

    @Override
    public void onStart() {
        super.onStart();
        loadMyCarts();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        binding.cartRecyclerView.setAdapter(adapter);
    }

    private void loadMyCarts(){
        Call<ArrayList<Cart>> call = parent.mainApi.getMyCart();
        cartArrayList.clear();

        call.enqueue(new RequestCallback<ArrayList<Cart>>() {
            @Override
            protected void onResponseSuccess(Call<ArrayList<Cart>> call, Response<ArrayList<Cart>> response) {
                cartArrayList.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            protected void onResponseFailed(Call<ArrayList<Cart>> call, Throwable t) {

            }
        });
    }
}
