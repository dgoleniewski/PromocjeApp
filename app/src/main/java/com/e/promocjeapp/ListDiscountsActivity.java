package com.e.promocjeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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


        Discount discount = new Discount();
        discount.setBasicPrice(3297);
        discount.setDiscountPrice(4710);
        discount.setTitle("Zegarek Longines Hydro Conquest automatic");
        discount.setLink("https://www.marko.pl/pl/p/Zegarek-meski-Longines-L37424966-Hydro-Conquest/48998");
        discount.setDescription("Newsletter -10% nie działa na zegarki\n" +
                "\n" +
                "Cena finalna: 3297 zł\n" +
                "Model L37424966\n" +
                "Automat\n" +
                "\n" +
                "Szukam zegarka i natknąłem się na taką cene chyba najniższa jaką spotkałem.\n" +
                "\n" +
                "W ofercie mają dużo przecen mi osobiście ten model się podoba w tym rozmiarze.\n" +
                "\n" +
                "Wysyłka z polski i gwarancja 24 miesiące\n" +
                "\n" +
                "Pierwsza wrzutka...\n" +
                "\n" +
                "\n" +
                "Opis:\n" +
                "\n" +
                "\n" +
                "Longines L37424966 Hydro Conquest to elegancki zegarek męski. Wyposażony jest w mechanizm automatyczny z 64-godzinną rezerwą naciągu, który do zasilania wykorzystuje naturalny ruch ręki, na której noszony jest zegarek. Szkiełko szafirowe zapewnia bardzo wysoką odporność na zarysowania oraz przejrzystość. Zarówno koperta, jak i bransoleta, wykonane ze stali szlachetnej w kolorze srebrnym podkreślają elegancki charakter zegarka. Wodoszczelność na poziomie 300 m (30 ATM, 30 Bar) zapewnia możliwość nurkowania z zegarkiem bez obaw o jego uszkodzenie.\n" +
                "\n" +
                "Sprzedawany przez firmę MARKO zegarek jest fabrycznie nowym, oryginalnym produktem firmy Longines, pochodzącym z legalnej i oficjalnej dystrybucji. Zapakowany w firmowe opakowanie, nadaje się idealnie na prezent.\n" +
                "\n" +
                "Istnieje możliwość obejrzenia go na żywo w sklepach MARKO oraz sklepach partnerskich (informacja o punktach znajduje się w zakładce O nas).\n" +
                "\n" +
                "Model zegarka objęty jest 2 letnią gwarancją producenta oraz Pakietem Korzyści Marko.");
        discounts = new LinkedList<>();
        discounts.add(discount);

        recyclerView = findViewById(R.id.recyclerView);
        newDiscountFloatingActionButton = findViewById(R.id.newDiscountFloatingActionButton);
//        adapter = new MyRecyclerViewAdapter(this, discounts);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newDiscountFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListDiscountsActivity.this, AddNewDiscount.class);
                startActivity(intent);
            }
        });
    }
}

