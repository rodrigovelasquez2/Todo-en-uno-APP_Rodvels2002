package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListViewClass extends AppCompatActivity {
    private EditText editTextListView;
    private Button button;
    private ListView listView;

    //Para guardar los datos hacia la lista:
    private List<String> miLista = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        //Encontrar los componentes:
        editTextListView = findViewById(R.id.editTextInsertText_ListView);
        button = findViewById(R.id.btnButtonAdd_ListView);
        listView = findViewById(R.id.lstVItems_ListView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }//Fin onCreate

    public void insertDataToListView(View view){
        String texto = editTextListView.getText().toString();
        miLista.add(texto);
        editTextListView.getText().clear();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,miLista);
        listView.setAdapter(arrayAdapter);

    }//Fin insertDataToListView

}//Fin ListView