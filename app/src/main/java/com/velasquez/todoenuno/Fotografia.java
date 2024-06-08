package com.velasquez.todoenuno;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.IOException;

public class Fotografia extends AppCompatActivity {
    ImageView imageViewGaleria;
    ImageView imageViewCamera;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fotografia);
        //Encontrar componentes:
        imageViewGaleria = findViewById(R.id.imageView_Fotografia);
        imageViewCamera = findViewById(R.id.imageView_camera);

        //Permisos
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void capturarPhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            File fotoArchivo = null;
            try {
                fotoArchivo = guardarImage();
            } catch (Exception e) {
                e.printStackTrace();
            }//Fin catch

            if (fotoArchivo != null) {
                Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", fotoArchivo);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(intent, 1);
            }//Fin if
        }//Fin if
    }//Fin capturarPhoto

    private File guardarImage() throws IOException {
        String nombreFoto = "foto.jpg";
        File directorioFotos = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File foto = File.createTempFile(nombreFoto, ".jpg", directorioFotos);
        path = foto.getAbsolutePath();
        return foto;
    }//Fin guardarImage

    //Método para capturar la imagen
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) { // Si la operación fue exitosa
            // Recuperar la imagen
//            Bundle extras = data.getExtras();
//            Bitmap imgBitmap = (Bitmap) extras.get("data");
            // Mostrar la imagen
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            imageViewGaleria.setImageBitmap(bitmap);
        }//Fin if
    }
}//Fin Fotografia