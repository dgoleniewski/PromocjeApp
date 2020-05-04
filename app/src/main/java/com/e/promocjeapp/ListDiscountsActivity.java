package com.e.promocjeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ListDiscountsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    private List<Discount> discounts;
    private FloatingActionButton newDiscountFloatingActionButton;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_discounts);
        db = FirebaseFirestore.getInstance();

        db.collection("Discounts").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Discount discount;
                for(QueryDocumentSnapshot document : task.getResult()){
                    discounts.add(new Discount(
                            document.get("title").toString(),
                            document.get("description").toString(),
                            document.get("link").toString(),
                            document.get("code").toString(),
                            document.getDouble("basicPrice"),
                            document.getDouble("discountPrice"),
                            document.get("endOfDiscountDate").toString()
                    ));
                }
                adapter = new MyRecyclerViewAdapter(ListDiscountsActivity.this, discounts);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListDiscountsActivity.this));
            }
        });

        discounts = new LinkedList<>();
        recyclerView = findViewById(R.id.recyclerView);
        newDiscountFloatingActionButton = findViewById(R.id.newDiscountFloatingActionButton);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                Intent intent = new Intent(ListDiscountsActivity.this, DiscountActivity.class);
                intent.putExtra("document","q");
                startActivity(intent);
                return true;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        newDiscountFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListDiscountsActivity.this, AddNewDiscount.class);
                startActivity(intent);
            }
        });
    }
}

