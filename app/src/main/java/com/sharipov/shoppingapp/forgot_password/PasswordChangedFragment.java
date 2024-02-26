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
import com.sharipov.shoppingapp.databinding.FragmentPasswordChangedBinding;

public class PasswordChangedFragment extends BaseFragment<FragmentPasswordChangedBinding> {

    @Override
    protected FragmentPasswordChangedBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentPasswordChangedBinding.inflate(inflater, parent, toAttach);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonSetup();
    }

    private void buttonSetup() {

        binding.buttonBackToLogin.setOnClickListener(view ->
                startActivity(new Intent(requireContext(), LoginActivity.class)));
    }
}
