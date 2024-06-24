package com.example.shoppingapp.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shoppingapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FeedbackBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.feedback_bottom_sheet, container, false);

        ImageView closeImageView = view.findViewById(R.id.close_btn2);
        closeImageView.setOnClickListener(v -> dismiss());

        return view;
    }
}
