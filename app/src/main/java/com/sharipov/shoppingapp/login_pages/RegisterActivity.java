package com.sharipov.shoppingapp.login_pages;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.databinding.ActivitySignupBinding;

public class RegisterActivity extends BaseActivity<ActivitySignupBinding> {
    @Override
    protected ActivitySignupBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivitySignupBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding.buttonBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }
}
