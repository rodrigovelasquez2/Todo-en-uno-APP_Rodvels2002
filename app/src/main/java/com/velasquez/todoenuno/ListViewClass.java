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

    /**
     * Metodo que registra datos a la lista
     *
     * @param view
     */
    private Integer contador = 0;

    public void insertDataToListView(View view) {
        String texto = editTextListView.getText().toString();

        //Incrementar el contador
        incrementarContador();

        //Añade a la lista datos:
        miLista.add("ITEM N°" + contador + ":> " + texto);

        // Limpia la caja de texto
        editTextListView.getText().clear();

        // Notifica al ArrayAdapter que los datos han cambiado
        arrayAdapter = new ArrayAdapter<>(this, R.layout.styles_list_items, miLista);

        // Setea los datos al ListView
        listView.setAdapter(arrayAdapter);
    }//Fin insertDataToListView

    public void incrementarContador() {
        contador++;
    }//Fin incrementarContador

    public void clearListView(View view) {
        contador = 0;
        miLista.clear();
        arrayAdapter.notifyDataSetChanged(); // Notifica al ArrayAdapter que los datos han cambiado
    }//Fin clearListView
}//Fin ListView