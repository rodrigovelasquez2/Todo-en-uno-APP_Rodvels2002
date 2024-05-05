package com.velasquez.todoenuno;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Preferencias extends AppCompatActivity {

    private Button button;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preferencias);

        //Capturar componentes
        button = findViewById(R.id.btnSharePreferences2);
        editText = findViewById(R.id.editTextSharePreferences);

        // Carga el valor guardado previamente en SharedPreferences y lo muestra en el EditText
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        //Mail, mismo nombre que se usara en putString
        String savedEmail = preferences.getString("mail", "");
        editText.setText(savedEmail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void mensaje(View view) {
        Toast.makeText(this, "Persistiendo datos", Toast.LENGTH_SHORT).show();
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_Editor = preferencias.edit();
        Obj_Editor.putString("mail", editText.getText().toString());
        Obj_Editor.commit();
        finish();
    }//Fin  mensajeSharePreferences


}//Fin Preferencias