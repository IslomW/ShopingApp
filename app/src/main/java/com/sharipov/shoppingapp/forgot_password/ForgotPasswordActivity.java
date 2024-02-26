package com.sharipov.shoppingapp.forgot_password;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.ActivityForgotPasswrodBinding;

public class ForgotPasswordActivity extends BaseActivity<ActivityForgotPasswrodBinding> {

    @Override
    protected ActivityForgotPasswrodBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityForgotPasswrodBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttonsSetup();
    }

    private void buttonsSetup() {

        binding.buttonBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }
}
