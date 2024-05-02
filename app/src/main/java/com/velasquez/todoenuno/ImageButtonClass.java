package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImageButtonClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_button_class);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void imageButtonSettings(View view) {
        Toast.makeText(this, "Settins funcionando", Toast.LENGTH_SHORT).show();
    }//fin settings
    public void imageButtonHome(View view) {
        Toast.makeText(this, "Home Funcionando", Toast.LENGTH_SHORT).show();
    }//Fin home
    public void imageButtonUser(View view) {
        Toast.makeText(this, "User funcionando", Toast.LENGTH_SHORT).show();
    }//fin user
}//Fin ImageButtonClass