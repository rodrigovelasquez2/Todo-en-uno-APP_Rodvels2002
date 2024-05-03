package com.velasquez.todoenuno.cardView.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.velasquez.todoenuno.R;
import com.velasquez.todoenuno.cardView.adapters.AdapterData;
import com.velasquez.todoenuno.cardView.entity.Pet;

import java.util.ArrayList;
import java.util.List;

public class CardViewRecycleView extends AppCompatActivity {
    List<Pet> listaData;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_card_view_recycle_view);

        //Capturar componentes:
        recyclerView = findViewById(R.id.recycle);

        //Creacion de objetos
        listaData = new ArrayList<Pet>();
        listaData.add(new Pet(R.drawable.icon_angora, "Kiara", "Codigo: 0001", "Animal: GATO", "Ranza: ANGORA", "Edad: 4años", "Genero: HEMBRA", "Color: Nieve"));
        listaData.add(new Pet(R.drawable.icon_orangecat, "Morci", "Codigo: 0002", "Animal: PERRO", "Ranza: NARANJA", "Edad: 5 años", "Genero: HEMBRA", "Color: Naranja"));
        listaData.add(new Pet(R.drawable.icon_buldog, "Max", "Codigo: 0003", "Animal: PERRO", "Ranza: BULLDOG", "Edad: 3 años", "Genero: MACHO", "Color: Marrón"));
        listaData.add(new Pet(R.drawable.icon_snaucher, "PICARON", "Codigo: 0006", "Animal: PERRO", "Raza: SCHNAUZER", "Edad: 4 años", "Genero: MACHO", "Color: Sal y Pimienta"));


        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterData(listaData);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}