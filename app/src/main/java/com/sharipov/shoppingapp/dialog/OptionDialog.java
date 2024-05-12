package com.sharipov.shoppingapp.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sharipov.shoppingapp.adapters.OptionListAdapter;
import com.sharipov.shoppingapp.base.BaseDialog;
import com.sharipov.shoppingapp.databinding.DialogOptionBinding;
import com.sharipov.shoppingapp.model.ColorOption;
import com.sharipov.shoppingapp.model.SizeOption;

import java.util.ArrayList;

public class OptionDialog extends BaseDialog<DialogOptionBinding> {
    private ArrayList<ColorOption> colorOptionArrayList;
    private ArrayList<SizeOption> sizeOptionArrayList;

    private ColorOption selectedColorOption;
    private SizeOption selectedSizeOption;
    public void setSelectedColorOption(ColorOption selectedColorOption) {
        this.selectedColorOption = selectedColorOption;
    }

    public void setSelectedSizeOption(SizeOption selectedSizeOption) {
        this.selectedSizeOption = selectedSizeOption;
    }

    public void setColorOptionArrayList(ArrayList<ColorOption> colorOptionArrayList) {
        this.colorOptionArrayList = colorOptionArrayList;
    }

    public void setSizeOptionArrayList(ArrayList<SizeOption> sizeOptionArrayList) {
        this.sizeOptionArrayList = sizeOptionArrayList;
    }

    private OptionListAdapter adapter;

    private OptionItemSelectListener listener;

    public void setOptionItemSelectedListener(OptionItemSelectListener listener) {
        this.listener = listener;
    }

    @Override
    protected DialogOptionBinding inflateViewBinding(LayoutInflater inflater, ViewGroup parent, boolean toAttachParent) {
        return DialogOptionBinding.inflate(inflater);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new OptionListAdapter(colorOptionArrayList, sizeOptionArrayList);
        adapter.setListener(listener);
        adapter.setSelectedColorOption(selectedColorOption);
        adapter.setSelectedSizeOption(selectedSizeOption);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.optionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.optionRecyclerView.setAdapter(adapter);
    }


    public interface OptionItemSelectListener {

        void onColorItemSelected(ColorOption colorOption);

        void onSizeItemSelected(SizeOption sizeOption);
    }
}
