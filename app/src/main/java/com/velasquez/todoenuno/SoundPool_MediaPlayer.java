package com.velasquez.todoenuno;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SoundPool_MediaPlayer extends AppCompatActivity {

    ImageButton playCuack, playMeow;
    SoundPool spCuak;
    SoundPool spMeow;
    int soundCuack;
    int soundMeow;
    MediaPlayer mp; // Declaración del objeto MediaPlayer a nivel de clase


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sound_pool_media_player);

        //BUSCAR COMPONENTES
        playCuack = findViewById(R.id.imageButton_Pato);
        playMeow = findViewById(R.id.imageButton_Cat);

        //Sound pool para cuack:
        spCuak = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        soundCuack = spCuak.load(this, R.raw.cuack_soundpool, 1); //cargar la pista

        //Sound pool para meow
        spMeow = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        soundMeow = spMeow.load(this, R.raw.meowcat_soundpool, 1); //cargar la pista


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void audioCuak(View view) {
        //-1: Siempre se va estar repetiendo
        // 1: Se repite
        // 0: Se repite cada vez que presiones el boton
        // rate: 1: Recomendado velocidad de reproduccion
        spCuak.play(soundCuack, 1, 1, 1, 0, 1);
    }//Fin audioCuak

    public void audioMeow(View view) {
        //-1: Siempre se va estar repetiendo
        // 1: Se repite
        // 0: Se repite cada vez que presiones el boton
        // rate: 1: Recomendado velocidad de reproduccion
        spMeow.play(soundMeow, 1, 1, 1, 0, 2);
    }//Fin audioMeow


    public void audioPlayer(View view) {
        // Detener reproducción anterior si hay
        if (mp != null && mp.isPlaying()) {
            Toast.makeText(this, "Reproduciendo...", Toast.LENGTH_SHORT).show();
            mp.stop();
            mp.release();
            mp = null;
        }
        mp = MediaPlayer.create(this, R.raw.synthwave_soundlong);
        mp.start();
    }//Fin audioPlayer

    public void stopMediaPlayer(View view) {
        Toast.makeText(this, "Deteniendo la musica  ", Toast.LENGTH_SHORT).show();
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }//Fin if
    }//Fin stopMediaPlayer
}//Fin activity_sound_pool_media_player