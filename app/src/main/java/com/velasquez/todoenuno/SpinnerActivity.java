package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button button;
    private EditText editText1, editText2;
    private TextView textView1;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        //Encontrar los componentes por el ID
        editText1 = findViewById(R.id.editTextNumber1);
        editText2 = findViewById(R.id.editTextNumber2);
        textView1 = findViewById(R.id.textViewResultado);
        button = findViewById(R.id.btnButton);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.dataToSpinnerListOperations, android.R.layout.simple_spinner_item);
        //Setear los datos al spinner
        spinner.setAdapter(arrayAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void calcular(View view) {
        // Obtener los valores ingresados
        String valor1String = editText1.getText().toString();
        String valor2String = editText2.getText().toString();

        // Verificar si los campos están vacíos
        if (valor1String.isEmpty() || valor2String.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos valores", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convertir los valores a enteros
        double valor1 = Double.parseDouble(valor1String);
        double valor2 = Double.parseDouble(valor2String);
        String seleccion = spinner.getSelectedItem().toString(); // Obtiene el ITEM que selecciono el usaurio.
        switch (seleccion) {
            case "sumar":
                textView1.setText("SUMA: " + String.valueOf(valor1 + valor2));
                break;
            case "restar":
                textView1.setText("RESTA: " + String.valueOf(valor1 - valor2));
                break;
            case "dividir":
                if (valor2 != 0) {
                    textView1.setText("DIVISION: " + String.valueOf(valor1 / valor2));
                } else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
                }//Fin else
                break;
            case "multiplicar":
                textView1.setText(String.valueOf(valor1 * valor2));
                break;
            default:
                Toast.makeText(this, "No se encontro esa opción", Toast.LENGTH_SHORT).show();
                break;
        }

    }//Fin calcular

}//Fin SpinnerActivity