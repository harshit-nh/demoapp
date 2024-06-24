package com.example.shoppingapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shoppingapp.fragments.EditDetailsBottomSheet;
import com.example.shoppingapp.fragments.FeedbackBottomSheet;
import com.example.shoppingapp.fragments.PersonalisedBottomSheet;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainActivity extends AppCompatActivity {

    private SoftInputAssist softInputAssist;


    TextView feedbackText, personalisedDetailsText;
    ImageView editDetailsImg, editAddressImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        softInputAssist = new SoftInputAssist(this);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //enabling back navigation
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener( v -> onBackPressed());

        editDetailsImg = findViewById(R.id.editDetailsImg);

        editAddressImg = findViewById(R.id.editAddressImg);

        feedbackText = findViewById(R.id.feedbackText);

        personalisedDetailsText = findViewById(R.id.personalisedDetailsBtn);


        editDetailsImg.setOnClickListener(v -> {
            EditDetailsBottomSheet bottomSheet = new EditDetailsBottomSheet();
            bottomSheet.show(getSupportFragmentManager(), "EditDetailsBottomSheet");
        });

        feedbackText.setOnClickListener(v -> {
            FeedbackBottomSheet bottomSheet1 = new FeedbackBottomSheet();
            bottomSheet1.show(getSupportFragmentManager(), "FeedbackBottomSheet");
        });

        personalisedDetailsText.setOnClickListener(v ->{
            PersonalisedBottomSheet bottomSheet2 = new PersonalisedBottomSheet();
            bottomSheet2.show(getSupportFragmentManager(), "PersonalisedBottomSheet");
        });

        editAddressImg.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddressActivity.class);
            startActivity(intent);
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }
}