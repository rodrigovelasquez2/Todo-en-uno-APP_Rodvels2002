package com.velasquez.todoenuno;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ManejoArchivos extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manejo_archivos);

        //Capturar elementos por el ID:
        editText = findViewById(R.id.editTextAreaTextoManejoArchivo);

        //Archivos 1
        String archivos[] = fileList();
        String nameFile = "bitacora.txt";
        if (ArchivosExiste(archivos, nameFile)) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput(nameFile));
                BufferedReader br = new BufferedReader(archivo); // Leer el archivo
                String linea = br.readLine();
                String bitacoraCompleta = "";

                while (linea != null) {
                    bitacoraCompleta = bitacoraCompleta + linea + "\n";
                    linea = br.readLine();
                }//fin while

                //Cada vez que se abra la aplicación, mostrara
                editText.setText(bitacoraCompleta);
                br.close();
                archivo.close();

            } catch (IOException io) {

            }//Fin Try-cath

        }//Fin if

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });//Fin onCreate
    }//Fin onCreate

    private boolean ArchivosExiste(String[] archivos, String nameFile) {
        for (int i = 0; i < archivos.length; i++)
            if (nameFile.equals(archivos[i]))
                return true;
        return false;
    }//Fin ArchivosExiste

    //Metodo para guardar
    public void guardarArchivos(View view) {
        String nameFile = "bitacora.txt";
        try {
            //Crea el archivo de texto
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nameFile, Activity.MODE_PRIVATE));
            archivo.write(editText.getText().toString());
            archivo.flush(); // Limpia los datos del buffer
            archivo.close();
        } catch (IOException io) {
            System.out.println(io);
        }//Fin try-catch
        Toast.makeText(this, "Se guardo los datos de manera correcta", Toast.LENGTH_SHORT).show();
        finish();
    }//Fin guardarArchivos
}//Fin ManejoArchivos