package com.sharipov.shoppingapp.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.sharipov.shoppingapp.base.BaseDialog;
import com.sharipov.shoppingapp.databinding.NoticeDialogBinding;

public class NoticeDialog extends BaseDialog<NoticeDialogBinding> {

    public static NoticeDialog getInstance(String message){
        NoticeDialog dialog = new NoticeDialog();
        Bundle basket = new Bundle();
        basket.putString("message", message);
        dialog.setArguments(basket);
        return dialog;
    }

    @Override
    protected NoticeDialogBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttachParent) {
        return NoticeDialogBinding.inflate(inflater, parent, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments()!=null) {
            String message = getArguments().getString("message");
            binding.textViewMessage.setText(message);
        }
        binding.buttonClose.setOnClickListener(view1 -> {

            dismiss();
        });
    }
}
