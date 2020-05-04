package com.e.promocjeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddNewDiscount extends AppCompatActivity {
    private EditText titleEditText, descriptionEditText, linkEditText, codeEditText, basicPriceEditText, discountPriceEditText, endOfDiscountEditText;
    private Button addDiscountButton;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_discount);
        db = FirebaseFirestore.getInstance();

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        linkEditText = findViewById(R.id.linkEditText);
        codeEditText = findViewById(R.id.codeEditText);
        basicPriceEditText = findViewById(R.id.basicPriceEditText);
        discountPriceEditText = findViewById(R.id.discountPriceEditText);
        endOfDiscountEditText = findViewById(R.id.endOfDiscountEditText);
        addDiscountButton = findViewById(R.id.addDiscountButton);

        addDiscountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String link = linkEditText.getText().toString();
                String code = codeEditText.getText().toString();
                String basicPrice = basicPriceEditText.getText().toString();
                String discountPrice = discountPriceEditText.getText().toString();
                String endOfDiscount = endOfDiscountEditText.getText().toString();
                if(!title.equals("") && !description.equals("") && !link.equals("") && !code.equals("") && !basicPrice.equals("") && !discountPrice.equals("") && !endOfDiscount.equals("")){
                    Discount discount = new Discount(title, description, link, code, Double.parseDouble(basicPrice), Double.parseDouble(discountPrice), endOfDiscount);
                    db.collection("Discounts").add(discount).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(AddNewDiscount.this,"Dodano nową promocje", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddNewDiscount.this,"Nie udało się dodać promocji, spróbuj ponownie za chwilę", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else{
                    Toast.makeText(AddNewDiscount.this,"Wypełnij wszystkie pola", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
