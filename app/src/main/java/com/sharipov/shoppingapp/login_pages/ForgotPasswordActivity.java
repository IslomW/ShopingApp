package com.sharipov.shoppingapp.login_pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends BaseActivity<ActivityForgotPasswordBinding> {
    @Override
    protected ActivityForgotPasswordBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityForgotPasswordBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.buttonBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });

        binding.textViewLogin.setOnClickListener(view -> {
            startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
        });
    }
}
