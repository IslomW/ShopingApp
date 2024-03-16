package com.sharipov.shoppingapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

import com.sharipov.shoppingapp.R;
import com.sharipov.shoppingapp.remote.MainApi;
import com.sharipov.shoppingapp.util.PreferenceManger;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseActivity<V extends ViewBinding> extends AppCompatActivity {
    protected V binding;

    protected abstract V inflateViewBinding(LayoutInflater inflater);

    private Toolbar toolbar;
    public PreferenceManger preferenceManger;

    public MainApi mainApi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflateViewBinding(getLayoutInflater());
        setContentView(binding.getRoot());
        mainApi = ApiService.provideApi(MainApi.class, this);
        preferenceManger = PreferenceManger.getInstance(getApplicationContext());

        toolbar = binding.getRoot().findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        if (hasBackButton()){
            if (getSupportActionBar() != null){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
            }
        }






    }

    protected boolean hasBackButton() {
        return false;
    }

    protected int backButtonDrawable() {
        return 0;
    }

}
