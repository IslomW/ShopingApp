package com.sharipov.shoppingapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {
    @Override
    protected FragmentHomeBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentHomeBinding.inflate(inflater, parent, toAttach);
    }
}
