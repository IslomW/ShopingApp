package com.sharipov.shoppingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.ActivitySignupBinding;
import com.sharipov.shoppingapp.model.User;

import retrofit2.Call;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity<ActivitySignupBinding> {
    @Override
    protected ActivitySignupBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivitySignupBinding.inflate(inflater);
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


        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = binding.editTextFirstName.getText().toString();
                String lastName = binding.editTextLastName.getText().toString();
                String email = binding.editTextEmail.getText().toString();
                String password = binding.editTextPassword.getText().toString();
                String confirmPassword = binding.editTextConfirmPassword.getText().toString();
                String address1 = binding.editTextAddress1.getText().toString();
                String address2 = binding.editTextAddress2.getText().toString();

                if (firstName.isEmpty()){
                    return;
                }
                if (lastName.isEmpty()){
                    return;
                }
                if (email.isEmpty()){
                    return;
                }
                if (password.isEmpty()){
                    return;
                }

                if (password.equals(confirmPassword)){
                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(email);
                    user.setPassword(password);
                    if (!address2.isEmpty()){
                        user.setAddress(address1 + ", " + address2);
                    }


                    Call<User> call = mainApi.createUser(user);

                    call.enqueue(new RequestCallback<User>() {
                        @Override
                        protected void onResponseSuccess(Call<User> call, Response<User> response) {
                            preferenceManger.setValue("isLoggedIn", true);
                            preferenceManger.setValue("user", response.body());


                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        }

                        @Override
                        protected void onResponseFailed(Call<User> call, Throwable t) {
                            Log.e("ERROR", t.getLocalizedMessage());
                        }
                    });

                }


            }
        });

        binding.buttonPostCode.setOnClickListener(view -> {

            activityResultLauncher.launch(new Intent(RegisterActivity.this, AddressActivity.class));

        });
    }



    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    if (o.getResultCode() == Activity.RESULT_OK){
                        Intent data = o.getData();
                        String postcode = data.getStringExtra("postcode");
                        String address = data.getStringExtra("address");
                        binding.editTextPostCode.setText(postcode);
                        binding.editTextAddress1.setText(address);
                    }
                }
            }
    );
}
