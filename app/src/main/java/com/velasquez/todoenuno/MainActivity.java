package com.velasquez.todoenuno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.velasquez.todoenuno.cardView.main.CardViewRecycleView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void sendToButtonSpinner(View view) {
        Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
        startActivity(intent);
    }//fin sendToButtonSpinner

    public void sendToButtonListView(View view) {
        Intent intent = new Intent(MainActivity.this, ListViewClass.class);
        startActivity(intent);
    }

    public void sendToButtonRadioButton(View view) {
        Intent intent = new Intent(MainActivity.this, RadioGroupActivity.class);
        startActivity(intent);
    }//Fin sendToButtonRadioButton

    public void sendToButtonCheckBox(View view) {
        Intent intent = new Intent(MainActivity.this, CheckBoxClass.class);
        startActivity(intent);
    }//Fin sendToButtonCheckBox

    public void sendToLayouts(View view) {
        Intent intent = new Intent(MainActivity.this, Layouts.class);
        startActivity(intent);
    }//Fin sendToLayouts

    public void sendToLayoutRelative(View view) {
        Intent intent = new Intent(MainActivity.this, RelativeLayout.class);
        startActivity(intent);
    }//Fin sendToLayouts


    public void sendToGripLayouts(View view) {
        Intent intent = new Intent(MainActivity.this, Grip_Layout.class);
        startActivity(intent);
    }//Fin sendToLayouts

    public void sendToImagenButton(View view) {
        Intent intent = new Intent(MainActivity.this, ImageButtonClass.class);
        startActivity(intent);
    }//Fin sendToImagenButton


    /**
     * Metodo que envia un dato a otra activity a travez del PUT y recibe la otra clase con Bundle
     *
     * @param view
     */
    public void sendToPutBundle(View view) {
        String nombre = "Rodrigo";
        String apellido = "Velasquez";
        Intent intent = new Intent(MainActivity.this, Put_Bundle.class);

        //Envio los datos a travez del Intent a la otra clase
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);

        startActivity(intent);
    }//Fin sendToImagenButton

    public void sendToWebView(View view){
        Intent intent = new Intent(MainActivity.this, WebViewClass.class);
        startActivity(intent);
    }//Fin sendToWebView

    public void sendToCardViewRecycleView (View view){
        Intent intent = new Intent(MainActivity.this, CardViewRecycleView.class);
        startActivity(intent);
    }

    public void sendToSharePreferences(View view){
        Intent intent = new Intent(MainActivity.this,Preferencias.class);
        startActivity(intent);
    }//Fin sendToSharePreferences


    public void sendToContactosPreferencias(View view){
        Intent intent = new Intent(MainActivity.this,ContactosPreferencias.class);
        startActivity(intent);
    }//Fin sendToContactosPreferencias

    public void sendToManejoArchivos(View view){
        Intent intent = new Intent(MainActivity.this,ManejoArchivos.class);
        startActivity(intent);
    }//Fin sendToManejoArchivos

}//Fin MainActivity