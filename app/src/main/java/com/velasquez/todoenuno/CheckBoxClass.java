package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckBoxClass extends AppCompatActivity {

    EditText primerValor;
    EditText segundoValor;
    CheckBox checkBoxSuma, checkBoxResta, checkBoxDivision;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_box);

        //Obtener los componentes:
        primerValor = findViewById(R.id.editTextNumber1_Checkbox);
        segundoValor = findViewById(R.id.editTextNumber2_Checkbox);
        checkBoxSuma = findViewById(R.id.checkBox_Suma);
        checkBoxResta = findViewById(R.id.checkBox_Resta);
        checkBoxDivision = findViewById(R.id.checkBox_Division);
        textView=findViewById(R.id.textViewResultado_Checkbox);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate


    //Metodos:
    public void calcularResultado_CheckBox(View view) {
        //Obtener valores
        String dato1 = primerValor.getText().toString();
        String dato2 = segundoValor.getText().toString();

        String resultado="";

        //Validar campos vacios
        if (dato1.isEmpty() || dato2.isEmpty()) { // Si los campos estan vacios
            Toast.makeText(this, "Inserte datos", Toast.LENGTH_SHORT).show();
            return;
        }

        double number1 = Double.parseDouble(dato1);
        double number2 = Double.parseDouble(dato2);


        if (checkBoxSuma.isChecked()) {
            double suma = number1 + number2;
            resultado = "SUMA: " + suma + " /";
        }

        if (checkBoxResta.isChecked()) {
            double resta = number1 - number2;
            resultado = resultado + "RESTA: " + resta;
        }

        if (checkBoxDivision.isChecked()) {
            if (number2 != 0) {
                double division = number1 / number2;
                resultado = resultado + "DIVISION: " + division;
            }else{
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
            }//Fin if
        }//Fin if

        textView.setText(resultado);






    }//Fin calcularResultado_CheckBox
}//Fin CheckBoxClass