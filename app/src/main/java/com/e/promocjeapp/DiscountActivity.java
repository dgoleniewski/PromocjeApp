package com.e.promocjeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DiscountActivity extends AppCompatActivity {
    private ImageButton thumbUpImageButton, thumbDownImageButton;
    private TextView titleTextView, descriptionTextView, pointsTextView, basicPriceTextView, discountPriceTextView, dateTextView, codeTextView;
    private Button linkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        //finish();

        thumbUpImageButton = findViewById(R.id.thumbUpImageButton);
        thumbDownImageButton = findViewById(R.id.thumbDownImageButton);
        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        pointsTextView = findViewById(R.id.pointsTextView);
        basicPriceTextView = findViewById(R.id.basicPriceTextView);
        discountPriceTextView = findViewById(R.id.discountPriceTextView);
        dateTextView = findViewById(R.id.discountPriceTextView);
        codeTextView = findViewById(R.id.codeTextView);
        linkButton = findViewById(R.id.linkButton);
    }
}
