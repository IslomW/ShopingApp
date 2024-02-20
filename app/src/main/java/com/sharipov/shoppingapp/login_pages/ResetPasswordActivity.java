package com.sharipov.shoppingapp.login_pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.databinding.ActivityResetPasswordBinding;

public class ResetPasswordActivity extends BaseActivity<ActivityResetPasswordBinding> {
    @Override
    protected ActivityResetPasswordBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityResetPasswordBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.buttonBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });

        binding.textViewLogIn.setOnClickListener(view -> {
            startActivity(new Intent(ResetPasswordActivity.this, LoginActivity.class));
        });
    }
}
