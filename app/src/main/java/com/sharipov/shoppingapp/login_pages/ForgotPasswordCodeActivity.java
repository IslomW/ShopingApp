package com.sharipov.shoppingapp.login_pages;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.databinding.ActivityForgotPasswordCodeBinding;

public class ForgotPasswordCodeActivity extends BaseActivity<ActivityForgotPasswordCodeBinding> {
    @Override
    protected ActivityForgotPasswordCodeBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityForgotPasswordCodeBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.buttonBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });

    }
}
