package com.sharipov.shoppingapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.FragmentProductBinding;

public class ProductFragment extends BaseFragment<FragmentProductBinding> {
    @Override
    protected FragmentProductBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentProductBinding.inflate(inflater, parent, toAttach);
    }
}
