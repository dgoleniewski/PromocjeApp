package com.e.promocjeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class DiscountActivity extends AppCompatActivity {
    private TextView titleTextView, descriptionTextView, pointsTextView, basicPriceTextView, discountPriceTextView, dateTextView, codeTextView;
    private ImageView imageView;
    private Button linkButton;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        db = FirebaseFirestore.getInstance();
        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        basicPriceTextView = findViewById(R.id.basicPriceTextView);
        discountPriceTextView = findViewById(R.id.discountPriceTextView);
        dateTextView = findViewById(R.id.dateTextView);
        codeTextView = findViewById(R.id.codeTextView);
        linkButton = findViewById(R.id.linkButton);
        imageView = findViewById(R.id.imageView);

        db.collection("Discounts").document(getIntent().getStringExtra("document")).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                final DocumentSnapshot document = task.getResult();
                titleTextView.setText(document.getString("title"));
                descriptionTextView.setText(document.getString("description"));
                basicPriceTextView.setText(document.getDouble("basicPrice").toString());
                discountPriceTextView.setText(document.getDouble("discountPrice").toString());
                dateTextView.setText(document.getString("endOfDiscountDate"));
                codeTextView.setText(document.getString("code"));
                Picasso.get().load(document.getString("image")).into(imageView);
                linkButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = document.getString("link");
                        if (!url.startsWith("http://") && !url.startsWith("https://"))
                            url = "http://" + url;
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(browserIntent);
                    }
                });
            }
        });
    }
}
