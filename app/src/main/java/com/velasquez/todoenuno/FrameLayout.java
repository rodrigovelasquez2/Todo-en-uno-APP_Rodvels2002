package com.velasquez.todoenuno;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FrameLayout extends AppCompatActivity {
    private Button btn;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frame_layout);
        //Buscar componentes:

        btn = findViewById(R.id.btnFrameLayoutButton);
        image = findViewById(R.id.imageView_FrameLayout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });//Fin ViewCompact
    }//Fin onCreate

    public void ocultar(View view) {
        btn.setVisibility(View.INVISIBLE);
        image.setVisibility(view.VISIBLE);
    }//Fin ocultar

}//Fin FrameLayout