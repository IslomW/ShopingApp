package com.sharipov.shoppingapp.login_pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    @Override
    protected ActivityLoginBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityLoginBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttonsSetup();


    }

    private void buttonsSetup() {
        binding.textViewSignUp.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        binding.textViewForgotPassword.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
        });
    }

}
