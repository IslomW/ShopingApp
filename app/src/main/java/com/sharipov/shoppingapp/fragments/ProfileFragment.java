package com.sharipov.shoppingapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.FragmentProductBinding;
import com.sharipov.shoppingapp.databinding.FragmentProfileBinding;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding> {
    @Override
    protected FragmentProfileBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentProfileBinding.inflate(inflater, parent, toAttach);
    }
}
