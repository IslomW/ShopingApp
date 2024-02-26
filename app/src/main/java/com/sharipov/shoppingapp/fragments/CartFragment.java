package com.sharipov.shoppingapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.FragmentCartBinding;

public class CartFragment extends BaseFragment<FragmentCartBinding> {
    @Override
    protected FragmentCartBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentCartBinding.inflate(inflater, parent, toAttach);
    }
}
