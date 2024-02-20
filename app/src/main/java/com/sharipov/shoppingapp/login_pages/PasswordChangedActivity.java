package com.sharipov.shoppingapp.login_pages;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.databinding.ActivityPasswordChangedBinding;

public class PasswordChangedActivity extends BaseActivity<ActivityPasswordChangedBinding> {
    @Override
    protected ActivityPasswordChangedBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityPasswordChangedBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.buttonBackToLogin.setOnClickListener(view -> {
            startActivity(new Intent(PasswordChangedActivity.this, LoginActivity.class));
        });
    }
}
