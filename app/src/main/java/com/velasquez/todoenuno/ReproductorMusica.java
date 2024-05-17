package com.velasquez.todoenuno;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReproductorMusica extends AppCompatActivity {
    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView imageView;
    int repetir;
    int posicion;

    //Vector donde guardara las pistas de audio
    MediaPlayer vectorMp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reproductor_musica);

        //Encontrar componentes por ID:
        play_pause = findViewById(R.id.imageButtonPlay_Rep_Musica);
        btn_repetir = findViewById(R.id.imageButtonRepeat_Rep_Musica);
        imageView = findViewById(R.id.imageView_portada);


        //Vector:
        vectorMp[0] = MediaPlayer.create(this, R.raw.race);
        vectorMp[1] = MediaPlayer.create(this, R.raw.sound);
        vectorMp[2] = MediaPlayer.create(this, R.raw.tea);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void setPlay_pause(View view) {
        if (vectorMp[posicion].isPlaying()) { // Saber si la pista de audio se esta reproduciendo
            vectorMp[posicion].pause();

            //Cambiar la apariencia del boton:
            play_pause.setBackgroundResource(R.drawable.icon_reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vectorMp[posicion].start();

            //Cambiar la apariencia del boton:
            play_pause.setBackgroundResource(R.drawable.icon_pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();

        }//Fin if-else
    }//Fin setPlay_pause

    public void setStop(View view) {
        if (vectorMp[posicion] != null) {
            vectorMp[posicion].stop();

            //Cargar las canciones:
            vectorMp[0] = MediaPlayer.create(this, R.raw.race);
            vectorMp[1] = MediaPlayer.create(this, R.raw.sound);
            vectorMp[2] = MediaPlayer.create(this, R.raw.tea);
            posicion = 0;

            play_pause.setBackgroundResource(R.drawable.icon_reproducir);
            imageView.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }//Fin if
    }//Fin setStop

    public void setRepeat(View view) {
        if (repetir == 1) {
            btn_repetir.setBackgroundResource(R.drawable.icon_no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectorMp[posicion].setLooping(false);
            repetir = 2;

        } else {
            btn_repetir.setBackgroundResource(R.drawable.icon_repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectorMp[posicion].setLooping(true); //Permite repetir la pista
            repetir = 1;
        }//Fin if-else
    }//Fin setRepeat


    public void setSiguienteCancio(View view){
        if(posicion<vectorMp.length -1){ //Verifica que el indice que este en la posicion cero
            

        }else {}
    }//Fin setSiguienteCancio
}//Fin ReproductorMusica