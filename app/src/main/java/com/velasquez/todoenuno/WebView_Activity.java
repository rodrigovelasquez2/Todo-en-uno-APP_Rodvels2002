package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebView_Activity extends AppCompatActivity {

    //Web view no necesita tipo de dato private por ser muy estricto
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);
        //Captura de datos:
        web = findViewById(R.id.webView1);

        //Capturar los datos del PUT
        Bundle bundle = getIntent().getExtras();
        String URL = bundle.getString("www");


//        web.setWebChromeClient(); // Usa el explorador de google chorme y abre una nueva pestaña para abrir el sitio web

        //Abrir el sitio web dentro de la aplicación:
        web.setWebViewClient(new WebViewClient()); // Muestra adentro del webView el sitio web

        //Cargar el URL
        web.loadUrl("https://" + URL);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void cerrarButton(View view) {
        finish(); //Cerrar el activity

    }//Fin cerrarButton
}//Fin activity_web_view