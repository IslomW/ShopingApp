package com.sharipov.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.ActivityLoginBinding;
import com.sharipov.shoppingapp.dialog.MyDialogs;
import com.sharipov.shoppingapp.dialog.NoticeDialog;
import com.sharipov.shoppingapp.forgot_password.ForgotPasswordActivity;
import com.sharipov.shoppingapp.model.User;

import retrofit2.Call;
import retrofit2.Response;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    @Override
    protected ActivityLoginBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityLoginBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttonsSetup();

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.editTextEmail.getText().toString();

                String password = binding.editTextPassword.getText().toString();
                User user = new User(email, password);
                Call<User> call = mainApi.login(user);

                call.enqueue(new RequestCallback<User>() {
                    @Override
                    protected void onResponseSuccess(Call<User> call, Response<User> response) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }

                    @Override
                    protected void onResponseFailed(Call<User> call, Throwable t) {
                        MyDialogs.showNoticeDialog(getFragmentManager(), "Username or Password is incorrect");
                    }
                });

            }
        });

        binding.editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = editable.toString();
                boolean isEmailValid = isEmailValid(email);
                if (isEmailValid) {
                    binding.emailField.setEndIconDrawable(R.drawable.ic_check);
                }else {
                    binding.emailField.setEndIconDrawable(null);
                }
            }
        });

    }

    private void buttonsSetup() {
        binding.textViewSignUp.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        binding.textViewForgotPassword.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
        });

    }

    private boolean isEmailValid(String email){
        boolean isEmailValid = true;

        if (!email.contains("@"))
            return false;

        String emailTail = email.substring(email.indexOf("@"));
        if (!emailTail.contains("."))
            return false;

        if (emailTail.indexOf('.') == (emailTail.indexOf("@")+1))
            return false;

        if (email.lastIndexOf('.') == (email.length() - 1))
            return false;

        return isEmailValid;
    }


}
