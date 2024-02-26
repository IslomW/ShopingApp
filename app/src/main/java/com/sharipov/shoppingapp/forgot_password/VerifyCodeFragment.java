package com.sharipov.shoppingapp.forgot_password;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.FragmentForgotPasswordCodeBinding;

public class VerifyCodeFragment extends BaseFragment<FragmentForgotPasswordCodeBinding> {
    @Override
    protected FragmentForgotPasswordCodeBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentForgotPasswordCodeBinding.inflate(inflater, parent, toAttach);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonsSetup();
    }

    private void buttonsSetup() {
        binding.buttonVerify.setOnClickListener(view -> {

        });

        binding.buttonSendCode.setOnClickListener(view -> {

        });

    }
}
