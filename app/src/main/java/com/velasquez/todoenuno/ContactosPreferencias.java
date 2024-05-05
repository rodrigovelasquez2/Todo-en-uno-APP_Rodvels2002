package com.velasquez.todoenuno;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactosPreferencias extends AppCompatActivity {
    private EditText editTextNombre;
    private EditText editTextOtros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contactos_preferencias);
        // Encontrar componentes por ID

        editTextNombre = findViewById(R.id.editTextSharePreferences_Contactos_Name);
        editTextOtros = findViewById(R.id.editTextSharePreferences_Contactos_Otros);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    /**
     * Guarda el dato en preferences
     *
     * @param view
     */
    public void guardarDatosPreferences_Contactos(View view) {
        String nombre = editTextNombre.getText().toString();
        String contacto = editTextOtros.getText().toString();

        //Share:
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(nombre, contacto); // Guarda el nombre y contactos obtenidos de las cajas de texto
        obj_editor.commit(); // Persistir ese dato

        Toast.makeText(this, "Se guardo el contacto!", Toast.LENGTH_SHORT).show();
    }//Fin guardarDatosPreferences_Contactos


    /**
     * Busca un contacto en preferences
     *
     * @param view
     */
    public void buscarPreferences_Contactos(View view) {
        String nombre = editTextNombre.getText().toString();
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferences.getString(nombre, "");

        //Evaluar si existe el contacto
        if (datos.length() == 0) {  // 0 indica que no encontro nada
            Toast.makeText(this, "No se encontro el dato", Toast.LENGTH_SHORT).show();
        } else {
            editTextOtros.setText(datos);
        }//Fin else
    }//Fin buscarPreferences_Contactos
}//Fin ContactosPreferencias