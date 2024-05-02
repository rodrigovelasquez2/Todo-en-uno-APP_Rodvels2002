package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioGroupActivity extends AppCompatActivity {
    private RadioButton radioButtonSuma, radioButtonResta, radioButtonDividir;
    private EditText editText1;
    private EditText editText2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_group_class);
        //Encontrar los componentes:
        editText1 = findViewById(R.id.edtxtNumero1_rdButton);
        editText2 = findViewById(R.id.edtxtNumero2_rdButton);
        radioButtonSuma = findViewById(R.id.radioButtonSumar);
        radioButtonResta = findViewById(R.id.radioButtonRestar);
        radioButtonDividir = findViewById(R.id.radioButtonDividir);
        textView = findViewById(R.id.textViewResultado_RadioButton);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void calcularRadioButton(View view) {
        double resultado;
        try {
            String valor1 = editText1.getText().toString();
            String valor2 = editText2.getText().toString();

            //Conversion a double:
            double numero1 = Double.parseDouble(valor1);
            double numero2 = Double.parseDouble(valor2);

            if (valor1.isEmpty() && valor2.isEmpty()) {
                Toast.makeText(this, "Campos vacios, digite lo que se pide", Toast.LENGTH_SHORT).show();
                return;
            }

            //Get item Sumar
            if (radioButtonSuma.isChecked()) { // Selecciono la suma?
                resultado = numero1 + numero2;
                textView.setText(String.valueOf(resultado));
            }//Fin radioButtonSuma

            //Get item Resta
            if (radioButtonResta.isChecked()) {
                resultado = (numero1 - numero2);
                textView.setText(String.valueOf(resultado));
            }//Fin radioButtonResta

            //Get item Dividir
            if (radioButtonDividir.isChecked()) {
                if (numero2 != 0) {
                    resultado = (numero1 / numero2);
                    textView.setText(String.valueOf(resultado));
                } else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                }//Fin if-else
            }//Fin radioButtonDividir
        } catch (Exception e) {
            Toast.makeText(this, "Ocurrio un error inesperado, regrese pronto....", Toast.LENGTH_SHORT).show();
        }//Fin trycath
    }//Fin calcular
}//Fin RadioGroupActivity