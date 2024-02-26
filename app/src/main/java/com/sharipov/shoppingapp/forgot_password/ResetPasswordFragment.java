package com.sharipov.shoppingapp.forgot_password;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.LoginActivity;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.FragmentResetPasswordBinding;

public class ResetPasswordFragment extends BaseFragment<FragmentResetPasswordBinding> {

    @Override
    protected FragmentResetPasswordBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentResetPasswordBinding.inflate(inflater, parent, toAttach);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        buttonSetup();

    }

    private void buttonSetup() {
        binding.buttonResetPassword.setOnClickListener(view -> {

        });


        binding.textViewLogIn.setOnClickListener(view -> {
            startActivity(new Intent(requireContext(), LoginActivity.class));
        });
    }


}
