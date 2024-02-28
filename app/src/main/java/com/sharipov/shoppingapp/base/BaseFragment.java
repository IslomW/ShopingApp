package com.sharipov.shoppingapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<V extends ViewBinding> extends Fragment {

    protected V binding;

    protected BaseActivity parent;

    protected abstract V inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parent = (BaseActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = inflateViewBinding(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}
