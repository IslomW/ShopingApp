package com.sharipov.shoppingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding>{

    @Override
    protected ActivityMainBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityMainBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

