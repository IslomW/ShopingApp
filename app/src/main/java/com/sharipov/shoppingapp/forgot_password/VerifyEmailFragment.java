package com.sharipov.shoppingapp.forgot_password;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.LoginActivity;
import com.sharipov.shoppingapp.R;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.databinding.FragmentForgotPasswordBinding;


public class VerifyEmailFragment extends BaseFragment<FragmentForgotPasswordBinding> {
    @Override
    protected FragmentForgotPasswordBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentForgotPasswordBinding.inflate(inflater, parent, toAttach);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonsSetup();
    }

    private void buttonsSetup() {


    binding.buttonSendCode.setOnClickListener(view ->
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new VerifyCodeFragment()).commit() );

        binding.textViewLogin.setOnClickListener(view ->
                startActivity(new Intent(requireContext(), LoginActivity.class)));
    }
}
