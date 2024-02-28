package com.sharipov.shoppingapp.base;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

public abstract class BaseDialog<V extends ViewBinding> extends DialogFragment {

    protected V binding;

    protected abstract V inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttachParent);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = inflateViewBinding(inflater, container, false);
        return binding.getRoot();
    }
}
