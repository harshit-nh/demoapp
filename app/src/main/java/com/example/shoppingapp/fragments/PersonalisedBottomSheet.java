package com.example.shoppingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shoppingapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class PersonalisedBottomSheet extends BottomSheetDialogFragment {

    TextView birthDate, anniversaryDate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.personalised_details_bottom_sheet,container,false);

        ImageView closeImageView = view.findViewById(R.id.close_btn3);
        closeImageView.setOnClickListener(v -> dismiss());


        birthDate = view.findViewById(R.id.birthDate);
        anniversaryDate = view.findViewById(R.id.anniversary);

        birthDate.setOnClickListener(v -> setDate(birthDate));

        anniversaryDate.setOnClickListener(v -> setDate(anniversaryDate));

        genderGroup(view);

        foodGroup(view);

        maritalGroup(view);

        familyGroup(view);


        return view;

    }




    private void genderGroup(View view){
        RadioGroup genderGroup = view.findViewById(R.id.genderGroup);
        ToggleButton maleButton = view.findViewById(R.id.maleButton);
        ToggleButton femaleButton = view.findViewById(R.id.femaleButton);
        ToggleButton othersButton = view.findViewById(R.id.othersButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToggleButton clickedButton = (ToggleButton) v;
                boolean isChecked = clickedButton.isChecked();

                // Unchecking all buttons
                for (int i = 0; i < genderGroup.getChildCount(); i++) {
                    View child = genderGroup.getChildAt(i);
                    if (child instanceof ToggleButton) {
                        ((ToggleButton) child).setChecked(false);
                    }
                }

                // Checking the clicked button if it was not already checked
                if (isChecked) {
                    clickedButton.setChecked(true);
                }
            }
        };


        //Setting the listener to all ToggleButtons
        maleButton.setOnClickListener(listener);
        femaleButton.setOnClickListener(listener);
        othersButton.setOnClickListener(listener);
    }

    private void foodGroup(View view){

        RadioGroup foodGroup = view.findViewById(R.id.foodGroup);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToggleButton clickedButton = (ToggleButton) v;
                boolean isChecked = clickedButton.isChecked();

                // Unchecking all buttons in the RadioGroup
                for (int i = 0; i < foodGroup.getChildCount(); i++) {
                    View row = foodGroup.getChildAt(i);
                    if (row instanceof LinearLayout) {
                        LinearLayout linearLayout = (LinearLayout) row;
                        for (int j = 0; j < linearLayout.getChildCount(); j++) {
                            View child = linearLayout.getChildAt(j);
                            if (child instanceof ToggleButton) {
                                ((ToggleButton) child).setChecked(false);
                            }
                        }
                    }
                }

                // Checking the clicked button if it was not already checked
                if (isChecked) {
                    clickedButton.setChecked(true);
                }
            }
        };

        // Setting  the listener to all ToggleButtons using nested loops because there are two linear layouts
        for (int i = 0; i < foodGroup.getChildCount(); i++) {
            View row = foodGroup.getChildAt(i);
            if (row instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) row;
                for (int j = 0; j < linearLayout.getChildCount(); j++) {
                    View child = linearLayout.getChildAt(j);
                    if (child instanceof ToggleButton) {
                        child.setOnClickListener(listener);
                    }
                }
            }
        }
    }

    private void maritalGroup(View view){

        RadioGroup maritalGroup = view.findViewById(R.id.maritalGroup);
        ToggleButton marriedButton = view.findViewById(R.id.marriedButton);
        ToggleButton unmarriedButton = view.findViewById(R.id.unmarriedButton);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToggleButton clickedButton = (ToggleButton) v;
                boolean isChecked = clickedButton.isChecked();

                // Unchecking all buttons
                for (int i = 0; i < maritalGroup.getChildCount(); i++) {
                    View child = maritalGroup.getChildAt(i);
                    if (child instanceof ToggleButton) {
                        ((ToggleButton) child).setChecked(false);
                    }
                }

                // Checking the clicked button if it was not already checked
                if (isChecked) {
                    clickedButton.setChecked(true);
                }
            }
        };


        //Setting the listener to all the ToggleButtons
        marriedButton.setOnClickListener(listener);
        unmarriedButton.setOnClickListener(listener);

    }

    private void familyGroup(View view){

        RadioGroup familyGroup = view.findViewById(R.id.familyGroup);
        ToggleButton btn1 = view.findViewById(R.id.btn1);
        ToggleButton btn2 = view.findViewById(R.id.btn2);
        ToggleButton btn3 = view.findViewById(R.id.btn3);
        ToggleButton btn4 = view.findViewById(R.id.btn4);
        ToggleButton btn5 = view.findViewById(R.id.btn5);
        ToggleButton btn6 = view.findViewById(R.id.btn6);
        ToggleButton btn7 = view.findViewById(R.id.btn7);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToggleButton clickedButton = (ToggleButton) v;
                boolean isChecked = clickedButton.isChecked();

                // Unchecking all buttons
                for (int i = 0; i < familyGroup.getChildCount(); i++) {
                    View child = familyGroup.getChildAt(i);
                    if (child instanceof ToggleButton) {
                        ((ToggleButton) child).setChecked(false);
                    }
                }

                // Checking the clicked button if it was not already checked
                if (isChecked) {
                    clickedButton.setChecked(true);
                }
            }
        };


        //Setting the listener to all the ToggleButtons
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);

    }


    //Set date method
    private void setDate(TextView eventText){
        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                String formattedDate = formatDate(selection);
                eventText.setText(formattedDate);
            }
        });
        materialDatePicker.addOnNegativeButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                birthDate.setText("DD/MM/YYYY");
            }
        });

        materialDatePicker.show(getParentFragmentManager(), "tag");
    }


    //Format date
    private String formatDate(long milliseconds){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return simpleDateFormat.format(new Date(milliseconds));
    }





}
