package com.e.promocjeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;
import java.util.List;

public class ListDiscountsActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    private List<Discount> discounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_discounts);
        //mDatabase = FirebaseDatabase.getInstance().getReference();

        Discount discount = new Discount();
        discount.setBasicPrice(249);
        discount.setDiscountPrice(159);
        discount.setTitle("Słuchawki Pioneer SE-S3BT-H różne kolory");
        discount.setLink("https://www.pepper.pl/visit/thread/259334");
        discount.setDescription("Słuchawki Pioneer SE-S3BT-H\n" +
                "Najniższa cena na Allegro 219 zł\n" +
                "Dostępne 4 kolory czarne, niebieskie, szare i różowe\n" +
                "Analogicznie ta sama oferta na Oleole");
        discounts = new LinkedList<>();
        discounts.add(discount);

        //mDatabase.setValue(discounts);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyRecyclerViewAdapter(this, discounts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

