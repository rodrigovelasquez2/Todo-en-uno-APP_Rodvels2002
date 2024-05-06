package com.velasquez.todoenuno;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Tarjeta_SD extends AppCompatActivity {
    private EditText editTextNameFile, editTextContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tarjeta_sd);
        //Obtener componentes por ID
        editTextNameFile = findViewById(R.id.editTextNameFile_TarjetaSD);
        editTextContent = findViewById(R.id.editTextContent_TarjetaSD);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void guardarTarjetaSD(View view) {
        String nameFile = editTextNameFile.getText().toString();
        String content = editTextContent.getText().toString();

        try {
            File tarjetaSD = Environment.getExternalStorageDirectory(); // Guarda de manera temporal el archivo
            Toast.makeText(this, "Ruta: " + tarjetaSD.getPath(), Toast.LENGTH_SHORT).show(); // Recupera con getpath el contenido de la tarjeta SD
            File rutaArchivo = new File(tarjetaSD.getPath(), nameFile);
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(nameFile, Activity.MODE_PRIVATE));
            crearArchivo.write(content);
            crearArchivo.flush();
            crearArchivo.close();
            Toast.makeText(this, "Guardado correctamente", Toast.LENGTH_SHORT).show();
            editTextContent.setText("");
            editTextNameFile.setText("");
        } catch (IOException io) {
            Toast.makeText(this, "No se pudo guardar el contenido", Toast.LENGTH_SHORT).show();
            System.out.println(io);
        }//Fin try-cath
    }//Fin guardarTarjetaSD

    public void consultarTarjetaSD(View view) {
        String nombre = editTextNameFile.getText().toString();

        try {
            File tarjetaSD = Environment.getExternalStorageDirectory(); // Guarda de manera temporal el archivo
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));

            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea = leerArchivo.readLine();
            String contenidoCompleto = "";

            while (linea != null) { // Si la linea esta vacio, entonces no tiene texto
                contenidoCompleto = contenidoCompleto + linea + "\n";
                linea = leerArchivo.readLine();
            }//Fin while

            //Cierra conexiones
            leerArchivo.close();
            abrirArchivo.close();

            //Muestra el contenido
            editTextContent.setText(contenidoCompleto);

        } catch (IOException io) {
            Toast.makeText(this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
        }//Fin try-cath
    }//Fin consultar

}//Fin Tarjeta_SD