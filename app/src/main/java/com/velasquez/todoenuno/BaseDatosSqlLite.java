package com.velasquez.todoenuno;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.velasquez.todoenuno.OpenHelperSQLite.AdminSQLiteOpenHelper;

public class BaseDatosSqlLite extends AppCompatActivity {

    private EditText editTextCodigo, editTextDescripcion, editTextPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_base_datos_sql_lite);

        //Buscar componentes entre ID
        editTextCodigo = findViewById(R.id.editTextCodigoProducto_SQlite);
        editTextDescripcion = findViewById(R.id.editTextDescripcionProducto_SQLite);
        editTextPrecio = findViewById(R.id.editTextPrecioProducto_SQlite);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }//Fin onCreate

    public void registrar_SQLite(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BD_Administracion", null, 1);

        // Permite abrir en modo lectura y escritura
        SQLiteDatabase database = admin.getReadableDatabase();

        //Guardar en variables
        String codigo = editTextCodigo.getText().toString();
        String descripcion = editTextDescripcion.getText().toString();
        String precio = editTextPrecio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);
            database.insert("Articulos", null, registro);
            database.close();

            //Limpiar campos
            editTextCodigo.setText("");
            editTextDescripcion.setText("");
            editTextPrecio.setText("");

            notificacionAgree("Se inserto los datos correctamente");
        } else {
            notificationAlert("Campos vacíos: Ingrese los datos en las cajas de texto");
        }//Fin if-else
    }//Fin registrar_SQLite


    public void buscarSQLite(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BD_Administracion", null, 1);

        // Permite abrir en modo lectura y escritura
        SQLiteDatabase database = admin.getReadableDatabase();

        //Capturar el ID
        String codigo = editTextCodigo.getText().toString();

        if (!codigo.isEmpty()) {
            Cursor file = database.rawQuery("SELECT descripcion, precio FROM Articulos WHERE codigo =" + codigo, null);

            if (file.moveToFirst()) { // Revisara si cuenta con valores
                notificacionAgree("Datos encontrados!!!");
                editTextDescripcion.setText(file.getString(0));  //Primer valor
                editTextPrecio.setText(file.getString(1));
                database.close();
            } else {
                notificacionError("No existe el producto");
            }//Fin if-Else
        } else {
            notificationAlert("Debes introducir el codigo del producto!");
        }//Fin if-else
    }//Fin buscarSQLite


    public void eliminar_SQlite(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BD_Administracion", null, 1);

        // Permite abrir en modo lectura y escritura
        SQLiteDatabase database = admin.getReadableDatabase();

        //Capturar el ID
        String codigo = editTextCodigo.getText().toString();

        if (!codigo.isEmpty()) {
            int cantidad = database.delete("Articulos", "codigo=" + codigo, null);
            database.close();

            //Limpiar campos
            editTextCodigo.setText("");
            editTextDescripcion.setText("");
            editTextPrecio.setText("");


            if (cantidad == 1) {
                notificacionAgree("Se elimino el producto exitosamente!!!");
            } else {
                notificacionError("No existe el producto");
            }//Fin if-else
        } else {
            notificationAlert("Debes introducir el codigo del producto!");
        }//Fin if-else
    }//Fin eliminar_SQlite


    public void modificar_SQLite(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BD_Administracion", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        //Guardar en variables
        String codigo = editTextCodigo.getText().toString();
        String descripcion = editTextDescripcion.getText().toString();
        String precio = editTextPrecio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cantidad = database.update("Articulos", registro, "codigo=" + codigo, null);
            database.close();

            if (cantidad == 1) {
                notificacionAgree("Articulo modificado satisfactoriamente");
            } else {
                notificationAlert("Escriba el CODIGO!!!");
            }//Fin else
        } else {
            notificacionError("No existe el producto, coloca el codigo para revisarlom");

        }//Fin if-else
    }//Fin modificar_SQLite

    //Metodos aparte:
    private void notificacionAgree(String mensaje) {
        // Inflar el diseño del Toast personalizado
        View layout = getLayoutInflater().inflate(R.layout.toast_custom_agree, findViewById(R.id.toastValido));

        // Configurar el contenido del ImageView si lo deseas
        ImageView imageView = layout.findViewById(R.id.imageViewToast_Agree);
        imageView.setImageResource(R.drawable.icon_check); // Cambiar el icono

        // Configurar el texto del Toast si lo deseas
        TextView textView = layout.findViewById(R.id.toastValido);
        textView.setText(mensaje);

        // Crear y mostrar el Toast personalizado
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }//Fin notificacionAgree

    private void notificationAlert(String mensajeAlert) {
        // Inflar el diseño del Toast personalizado
        View layout = getLayoutInflater().inflate(R.layout.toast_custom_warning, findViewById(R.id.toastAdvertencia));

        // Configurar el contenido del ImageView si lo deseas
        ImageView imageView = layout.findViewById(R.id.imageViewtoast_alert);
        imageView.setImageResource(R.drawable.icon_alert); // Cambiar el icono

        // Configurar el texto del Toast si lo deseas
        TextView textView = layout.findViewById(R.id.toastAdvertencia);
        textView.setText(mensajeAlert);

        // Crear y mostrar el Toast personalizado
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }//Fin notificationAlert

    private void notificacionError(String texto) {
        // Inflar el diseño del Toast personalizado
        View layout = getLayoutInflater().inflate(R.layout.toast_custom_error, findViewById(R.id.toastError));

        // Configurar el contenido del ImageView si lo deseas
        ImageView imageView = layout.findViewById(R.id.imageViewToast_error);
        imageView.setImageResource(R.drawable.icon_error); // Cambiar el icono

        // Configurar el texto del Toast si lo deseas
        TextView textView = layout.findViewById(R.id.toastError);
        textView.setText(texto);

        // Crear y mostrar el Toast personalizado
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }//Fin notificacionNoExisteProducto
}//Fin BaseDatosSqlLite