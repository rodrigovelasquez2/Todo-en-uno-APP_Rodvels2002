package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScrollView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scroll_view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate


    public void seleccionar(View view) {
        int id = view.getId();
        if (id == R.id.imageBananas) {
            showText("Selecciono platano!");
        }

        if (id == R.id.imageCereza) {
            showText("Selecciono Cereza!");
        }

        if (id == R.id.imageFrambuesa) {
            showText("Selecciono frambuesa!");
        }

        if (id == R.id.imageFresas) {
            showText("Selecciono fresas!");
        }

        if (id == R.id.imageKiwis) {
            showText("Selecciono kiwis!");
        }

        if (id == R.id.imageMangos) {
            showText("Selecciono mangos!");
        }

        if (id == R.id.imageManzanas) {
            showText("Selecciono manzanas!");
        }

        if (id == R.id.imageMelon) {
            showText("Selecciono melon!");
        }

        if (id == R.id.imageNaranjas) {
            showText("Selecciono naranjas!");
        }

        if (id == R.id.imagePera) {
            showText("Selecciono pera!");
        }

        if (id == R.id.imagePiña) {
            showText("Selecciono piña!");
        }

        if (id == R.id.imageSandia) {
            showText("Selecciono sandia!");
        }


        if (id == R.id.imageUvas) {
            showText("Selecciono uvas!");
        }


        if (id == R.id.imageZarzamora) {
            showText("Selecciono zarzamora!");
        }
    }//Fin seleccionar

    public void showText(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }//Fin Toas


}