package com.example.shoppingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shoppingapp.R;
import com.example.shoppingapp.SoftInputAssist;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class EditDetailsBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.details_bottom_sheet, container, false);

        ImageView closeImageView = view.findViewById(R.id.close_btn);
        closeImageView.setOnClickListener(v -> dismiss());

        return view;
    }

}
