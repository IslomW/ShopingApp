package com.sharipov.shoppingapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;

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

    public PreferenceManger preferenceManger;

    public MainApi mainApi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflateViewBinding(getLayoutInflater());
        setContentView(binding.getRoot());

        preferenceManger = PreferenceManger.getInstance(getApplicationContext());


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.annyong.store")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mainApi = retrofit.create(MainApi.class);
//        Toolbar toolbar = (binding.getRoot().findViewById(R.id.toolbar));
//        setSupportActionBar(toolbar);
//
//        if (getSupportActionBar() != null){
//            getSupportActionBar().setDisplayHomeAsUpEnabled(hasBackButton());
//
//            if (hasBackButton()){
//                if (backButtonDrawable() != 0)
//                    getSupportActionBar().setHomeAsUpIndicator(backButtonDrawable());
//            }
//        }



    }

    protected boolean hasBackButton() {
        return false;
    }

    protected int backButtonDrawable() {
        return 0;
    }

}
