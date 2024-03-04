package com.sharipov.shoppingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.databinding.ActivityMainBinding;
import com.sharipov.shoppingapp.databinding.FragmentHomeBinding;
import com.sharipov.shoppingapp.fragments.CartFragment;
import com.sharipov.shoppingapp.fragments.HomeFragment;
import com.sharipov.shoppingapp.fragments.ProductFragment;
import com.sharipov.shoppingapp.fragments.ProfileFragment;
import com.sharipov.shoppingapp.util.Tab;

public class MainActivity extends BaseActivity<ActivityMainBinding>{

    private Tab currentTab;

    private HomeFragment homeFragment;
    private ProductFragment productFragment;
    private CartFragment cartFragment;
    private ProfileFragment profileFragment;

    @Override
    protected ActivityMainBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityMainBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentTab = Tab.HOME;
        onNavigationTabSelected(Tab.HOME);

        binding.nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home)
                    onNavigationTabSelected(Tab.HOME);
                else if (item.getItemId() == R.id.nav_product)
                    onNavigationTabSelected(Tab.PRODUCTS);
                else if (item.getItemId() == R.id.nav_cart)
                    onNavigationTabSelected(Tab.CART);
                else if (item.getItemId() == R.id.nav_profile)
                    onNavigationTabSelected(Tab.PROFILE);
                return true;
            }
        });

    }

    private void onNavigationTabSelected(Tab tab){

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(currentTab.getTag());
        if (fragment != null)
            getSupportFragmentManager().beginTransaction().hide(fragment).commit();


        currentTab = tab;

        switch (tab){
            case HOME:
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment, "HOME").commit();
                }else {
                    getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
                }
                binding.textViewTitle.setText("Home");
                break;

            case PRODUCTS:
                if (productFragment == null){
                    productFragment = new ProductFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, productFragment, "PRODUCT").commit();
                }else {
                    getSupportFragmentManager().beginTransaction().show(productFragment).commit();
                }
                binding.textViewTitle.setText("Products");
                break;

            case CART:
                if (cartFragment == null){
                    cartFragment = new CartFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, cartFragment, "CART").commit();
                }else {
                    getSupportFragmentManager().beginTransaction().show(cartFragment).commit();
                }
                binding.textViewTitle.setText("Cart");
                break;

            case PROFILE:
                if (profileFragment == null){
                    profileFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, profileFragment, "PROFILE").commit();
                }else {
                    getSupportFragmentManager().beginTransaction().show(profileFragment).commit();
                }
                binding.textViewTitle.setText("Profile");
                break;
        }

    }
}

