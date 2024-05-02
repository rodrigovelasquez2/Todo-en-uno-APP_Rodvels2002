package com.velasquez.todoenuno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        Intent intent = new Intent(MainActivity.this, SpinnerActivity.class );
        startActivity(intent);
    }//fin sendToButtonSpinner

    public void sendToButtonListView(View view){
        Intent intent = new Intent(MainActivity.this, ListViewClass.class);
        startActivity(intent);
    }

    public void sendToButtonRadioButton(View view){
        Intent intent = new Intent(MainActivity.this, RadioGroupActivity.class);
        startActivity(intent);
    }//Fin sendToButtonRadioButton

    public void sendToButtonCheckBox(View view){
        Intent intent = new Intent(MainActivity.this, CheckBoxClass.class);
        startActivity(intent);
    }//Fin sendToButtonCheckBox

    public void sendToLayouts(View view){
        Intent intent = new Intent(MainActivity.this, Layouts.class);
        startActivity(intent);
    }//Fin sendToLayouts

    public void sendToLayoutRelative(View view){
        Intent intent = new Intent(MainActivity.this, RelativeLayout.class);
        startActivity(intent);
    }//Fin sendToLayouts


    public void sendToGripLayouts(View view){
        Intent intent = new Intent(MainActivity.this, Grip_Layout.class);
        startActivity(intent);
    }//Fin sendToLayouts

}