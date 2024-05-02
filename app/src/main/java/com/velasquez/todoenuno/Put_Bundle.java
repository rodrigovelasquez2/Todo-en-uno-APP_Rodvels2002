package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Put_Bundle extends AppCompatActivity {

    private TextView txtresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_put_bundle);

        //Obtener componentes
        txtresultado = findViewById(R.id.txtViewResultadoPutBundle);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void revelarDatos(View view) {
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String apellido = bundle.getString("apellido");

        txtresultado.setText("DATO RECUPERADO:" + nombre + " " + apellido);

    }//Fin revelarDatos


}//Fin Put_Bundle