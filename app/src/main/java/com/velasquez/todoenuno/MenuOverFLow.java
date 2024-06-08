package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuOverFLow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_over_flow); // Mostrar primero el action bar
        setSupportActionBar(findViewById(R.id.toolbar)); // Encima se muestra la barra de herramientas.

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    //Metodo para que muestre el menu de opciones en el tolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_menu, menu);
        return true;
    }//Fin onCreateOptionsMenu

    //Metodo para asignar las funciones al boton de cada item del menu:
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1_agregar:
                Toast.makeText(this, "Opcion 1, soy un action button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2_delete:
                Toast.makeText(this, "Opcion 2, soy un action button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3_actionBar:
                Toast.makeText(this, "Opcion 3, soy un actionBar", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }//Fin onOptionsItemSelected


}//Fin MenuOverFLow