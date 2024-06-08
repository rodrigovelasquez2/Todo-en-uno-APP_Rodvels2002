package com.velasquez.todoenuno;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class Grabadora extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_CODE = 1000;

    private MediaRecorder grabacion;
    private String archivoSalida = null;
    private static final String LOG_TAG = "Grabadora";

    private Button btn_recorder;
    private ImageView imageViewOndas, imageViewAudifono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grabadora);

        // Inicializar componentes
        btn_recorder = findViewById(R.id.btn_grabadora_rec);
        imageViewOndas = findViewById(R.id.grabadora_ondas);
        imageViewAudifono = findViewById(R.id.grabadora_audifono);

        // Solicitar permisos si no están concedidos
        if (!checkPermissions()) {
            requestPermissions();
        }


    }

    /**
     * Verifica si los permisos necesarios están concedidos.
     *
     * @return true si los permisos están concedidos, false en caso contrario.
     */
    private boolean checkPermissions() {
        int writeExternalStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int recordAudio = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        return writeExternalStorage == PackageManager.PERMISSION_GRANTED && recordAudio == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Solicita los permisos necesarios.
     */
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        }, REQUEST_PERMISSION_CODE);
    }

    /**
     * Maneja el resultado de la solicitud de permisos.
     *
     * @param requestCode  Código de solicitud de permisos.
     * @param permissions  Lista de permisos solicitados.
     * @param grantResults Resultados de las solicitudes de permisos.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length > 0) {
                boolean writeExternalStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean recordAudio = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (!writeExternalStorage || !recordAudio) {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    /**
     * Inicia o detiene la grabación de audio.
     *
     * @param view La vista que disparó el evento.
     */
    public void recorder(View view) {
        if (grabacion == null) { // Iniciar grabación
            iniciarGrabacion();
        } else { // Detener grabación
            detenerGrabacion();
        }
    }

    /**
     * Configura y comienza la grabación de audio.
     */
    private void iniciarGrabacion() {
        imageViewAudifono.setImageResource(R.drawable.audio_sin_reproducir);
        imageViewOndas.setVisibility(View.INVISIBLE);
        archivoSalida = getExternalFilesDir(null).getAbsolutePath() + "/grabacion.mp3";
        grabacion = new MediaRecorder();
        grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
        grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        grabacion.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        grabacion.setOutputFile(archivoSalida);

        try {
            grabacion.prepare();
            grabacion.start();
            btn_recorder.setBackgroundResource(R.drawable.grabacion_encendida);
            Toast.makeText(this, "Grabando...", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "Archivo guardado en: " + archivoSalida); // Imprimir la ruta en la consola de depuración
            Toast.makeText(this, "Archivo guardado en: " + archivoSalida, Toast.LENGTH_LONG).show(); // Mostrar la ruta en un mensaje emergente

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al iniciar la grabación", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Detiene la grabación de audio y libera los recursos.
     */
    private void detenerGrabacion() {
        grabacion.stop();
        grabacion.release();
        grabacion = null;
        btn_recorder.setBackgroundResource(R.drawable.record_off);
        Toast.makeText(this, "Grabación finalizada", Toast.LENGTH_SHORT).show();
    }

    /**
     * Reproduce la grabación de audio.
     *
     * @param view La vista que disparó el evento.
     */
    public void reproducir(View view) {
        imageViewOndas.setVisibility(View.VISIBLE);
        imageViewAudifono.setImageResource(R.drawable.audio_reproduciendo);
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(archivoSalida);
            mediaPlayer.prepare();
            mediaPlayer.start();

            Toast.makeText(this, "Reproduciendo...", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al reproducir la grabación", Toast.LENGTH_SHORT).show();
        }
    }
}
