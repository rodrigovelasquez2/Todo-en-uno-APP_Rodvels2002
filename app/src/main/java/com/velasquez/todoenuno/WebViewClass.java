package com.velasquez.todoenuno;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Actividad que muestra un WebView para navegar por páginas web.
 */
public class WebViewClass extends AppCompatActivity {
    private EditText editText;
    private WebView paginaWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Habilitar edge-to-edge display
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view_class);

        // Inicializar los elementos de la interfaz
        editText = findViewById(R.id.editTextWebView);
        paginaWeb = findViewById(R.id.webViewPaginaWeb);

        // Configurar el WebView para cargar y mostrar páginas web
        WebSettings webSettings = paginaWeb.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilitar JavaScript
        paginaWeb.setWebViewClient(new WebViewClient()); // Utilizar un WebViewClient para cargar páginas web

        // Comprobar si hay conexión a Internet al iniciar la actividad
        if (isNetworkAvailable()) {
            // Puedes cargar una página predeterminada aquí si lo deseas
            editText.setText("https://www.google.com/");
        } else {
            // Manejar caso de no haber conexión a Internet
        }

        // Ajustar el padding de acuerdo a los system bars (barras de sistema)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * Método para navegar a una URL especificada en el EditText.
     *
     * @param view Vista desde la que se llama al método.
     */
    public void navegar(View view) {
        String URL = editText.getText().toString().trim();
        if (!URL.isEmpty()) {
            // Construir la URL de búsqueda de Google con la consulta ingresada
            String urlBusqueda = "https://www.google.com/search?q=" + Uri.encode(URL); // Se agrega la consulta a Google para que busque
            // Limpiar la cache del navegador y cargar la URL en el WebView
            paginaWeb.clearCache(false);
            paginaWeb.loadUrl(urlBusqueda);
        }
    }

    /**
     * Verifica si hay una conexión de red disponible.
     *
     * @return true si hay una conexión de red disponible, false de lo contrario.
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
}
