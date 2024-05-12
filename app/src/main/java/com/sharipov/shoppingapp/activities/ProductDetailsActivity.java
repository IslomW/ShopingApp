package com.sharipov.shoppingapp.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.adapters.ProductPagerAdapter;
import com.sharipov.shoppingapp.base.BaseActivity;
import com.sharipov.shoppingapp.base.BaseFragment;
import com.sharipov.shoppingapp.base.RequestCallback;
import com.sharipov.shoppingapp.databinding.ActivityProductDetailsBinding;
import com.sharipov.shoppingapp.dialog.MyDialogs;
import com.sharipov.shoppingapp.dialog.OptionDialog;
import com.sharipov.shoppingapp.model.CartRequest;
import com.sharipov.shoppingapp.model.CartResponse;
import com.sharipov.shoppingapp.model.ColorOption;
import com.sharipov.shoppingapp.model.Image;
import com.sharipov.shoppingapp.model.Option;
import com.sharipov.shoppingapp.model.Product;
import com.sharipov.shoppingapp.model.SizeOption;

import java.util.ArrayList;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity<ActivityProductDetailsBinding> {

    private Product product;
    private ProductPagerAdapter adapter;
    private ArrayList<Image> imageArrayList;
    private ColorOption selectedColorOption;
    private SizeOption selectedSizeOption;

    private ArrayList<SizeOption> filterSizeOptionArrayList = new ArrayList<>();

    @Override
    protected ActivityProductDetailsBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityProductDetailsBinding.inflate(inflater);
    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int productId = getIntent().getIntExtra("product_id", 0);
        imageArrayList = new ArrayList<>();
        adapter = new ProductPagerAdapter(this, imageArrayList);
        binding.productViewPager.setAdapter(adapter);
        if (productId != 0){
            loadProductDetails(productId);
        }


        binding.tvColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OptionDialog optionDialog = new OptionDialog();
                optionDialog.setSelectedColorOption(selectedColorOption);
                optionDialog.setColorOptionArrayList(product.getColorOptions());
                optionDialog.setOptionItemSelectedListener(new OptionDialog.OptionItemSelectListener() {
                    @Override
                    public void onColorItemSelected(ColorOption colorOption) {
                        optionDialog.dismiss();
                        selectedColorOption = colorOption;
                        binding.ivColorRight.setVisibility(View.GONE);
                        binding.tvSelectedColor.setVisibility(View.VISIBLE);
                        binding.tvSelectedColor.setText(colorOption.getTitle());
                        selectedSizeOption = null;


                        binding.tvSelectedSize.setVisibility(View.GONE);
                        binding.ivSizeRight.setVisibility(View.VISIBLE);
                        filterSizeOptionArrayList.clear();

                        product.getOptionArrayLists().forEach(new Consumer<Option>() {
                            @Override
                            public void accept(Option option) {
                                if (option.getColorOption().getId() == selectedColorOption.getId()) {
                                    filterSizeOptionArrayList.add(option.getSizeOption());
                                }
                            }
                        });

                    }

                    @Override
                    public void onSizeItemSelected(SizeOption sizeOption) {

                    }
                });


                optionDialog.show(getFragmentManager(), "color_dialog");

            }
        });


        binding.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(binding.tvQuantity.getText().toString());
                if (value < 10)
                    value++; // value=value+1

                binding.tvQuantity.setText(String.valueOf(value));

            }
        });
        binding.minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(binding.tvQuantity.getText().toString());
                if (value > 1)
                    value--; // value=value-1

                binding.tvQuantity.setText(String.valueOf(value));
            }
        });

        binding.addProductToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // product id
                // quantity
                // option id.

                // options:
                //    option 1: Navi, M.
                //    option 2: Red, L.
                //    option 3: Yellow, XL.

                int quantity = Integer.parseInt(binding.tvQuantity.getText().toString());

                // selectedColorOption, selectedSizeOption;

                if (selectedSizeOption == null || selectedColorOption == null) {
                    MyDialogs.showNoticeDialog(getFragmentManager(), "Please select options first");
                    return;
                }


                Option selectedOption = null;
                for (Option option : product.getOptionArrayLists()) {
                    if (option.getColorOption().getId() == selectedColorOption.getId() && option.getSizeOption().getId() == selectedSizeOption.getId()) {
                        selectedOption = option;
                    }
                }

                if (selectedOption != null) {

                    CartRequest cartRequest = new CartRequest(product.getId(), quantity, selectedOption.getId());

                    Call<CartResponse> call = mainApi.addProductToCart(cartRequest);
                    call.enqueue(new RequestCallback<CartResponse>() {
                        @Override
                        protected void onResponseSuccess(Call<CartResponse> call, Response<CartResponse> response) {
                            MyDialogs.showNoticeDialog(getFragmentManager(), "Product is added to cart!");
                        }

                        @Override
                        protected void onResponseFailed(Call<CartResponse> call, Throwable t) {

                        }
                    });

                }

            }
        });

        binding.tvSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedColorOption != null) {
                    OptionDialog optionDialog = new OptionDialog();
                    optionDialog.setSizeOptionArrayList(filterSizeOptionArrayList);
                    optionDialog.setOptionItemSelectedListener(new OptionDialog.OptionItemSelectListener() {
                        @Override
                        public void onColorItemSelected(ColorOption colorOption) {

                        }

                        @Override
                        public void onSizeItemSelected(SizeOption sizeOption) {
                            // this will be invoked
                            optionDialog.dismiss();
                            selectedSizeOption = sizeOption;
                            binding.tvSelectedSize.setVisibility(View.VISIBLE);
                            binding.ivSizeRight.setVisibility(View.GONE);
                            binding.tvSelectedSize.setText(selectedSizeOption.getTitle());

                        }
                    });
                    optionDialog.show(getFragmentManager(), "size_dialog");
                } else {
                    MyDialogs.showNoticeDialog(getFragmentManager(), "Please select color first.");
                }
            }
        });

    }

    private void loadProductDetails(int productId) {
        Call<Product> call = mainApi.getProductDetails(productId);

        call.enqueue(new RequestCallback<Product>() {
            @Override
            protected void onResponseSuccess(Call<Product> call, Response<Product> response) {
                product = response.body();
                createProductUI();
            }



            @Override
            protected void onResponseFailed(Call<Product> call, Throwable t) {

            }
        });
    }
    private void createProductUI() {
        if (product != null){
            binding.productBrand.setText(product.getBrand());
            binding.productTitle.setText(product.getTitle());
            binding.productDetails.setText(product.getDescription());
            binding.productPriceCurrent.setText(product.getPriceCurrentAsString());
            binding.productPriceOrginal.setText(product.getOrginalPriceAsString());
        }
    }




}
