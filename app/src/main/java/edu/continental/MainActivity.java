package edu.continental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import java.util.HashMap;
//import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtidUsuario, edtApellido, edtnombre, edtdireccion, edtNacionalidad,
            edtfechaNac, edtTelefono, edtemail, edtContrasenia;
    Button btnRegistrar;
    //variables de los datos a registrar
    private String idusuario = "";
    private String apellido = "";
    private String nombre = "";
    private String direccion = "";
    private String nacionalidad = "";
    private String fechanac = "";
    private String telefono = "";
    private String email = "";
    private String password = "";


    private DatabaseReference database;
    //private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtidUsuario= findViewById(R.id.edtidUsuario);
        edtApellido= findViewById(R.id.edtApellido);
        edtnombre= findViewById(R.id.edtNombre);
        edtdireccion= findViewById(R.id.edtDirec);
        edtNacionalidad= findViewById(R.id.edtNacionalidad);
        edtfechaNac= findViewById(R.id.edtfechaNac);
        edtTelefono= findViewById(R.id.edtTelefono);
        edtemail= findViewById(R.id.edtEmail);
        edtContrasenia= findViewById(R.id.edtpassword);
        btnRegistrar= findViewById(R.id.btnregistrar);
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        btnRegistrar.setOnClickListener(this);
        inicializarFirebase();

    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(MainActivity.this);
        //firebaseDatabase=FirebaseDatabase.getInstance();
        //FirebaseDatabase=firebaseDatabase.getReference();
    }

    @Override
    public void onClick(View v) {
        registrarUsuario();
    }

    private void registrarUsuario(){
        String idusuario = edtidUsuario.getText().toString();
        String apellido = edtApellido.getText().toString();
        String nombre = edtnombre.getText().toString();
        String direccion = edtdireccion.getText().toString();
        String nacionalidad = edtNacionalidad.getText().toString();
        String fechanac = edtfechaNac.getText().toString();
        String telefono = edtTelefono.getText().toString();
        String email = edtemail.getText().toString();
        String password = edtContrasenia.getText().toString();
        System.out.println("guardado");

        if (!TextUtils.isEmpty(idusuario) && !TextUtils.isEmpty(apellido)  && !TextUtils.isEmpty(nombre)  && !TextUtils.isEmpty(direccion)  && !TextUtils.isEmpty(nacionalidad)
                && !TextUtils.isEmpty(fechanac)  && !TextUtils.isEmpty(telefono)  && !TextUtils.isEmpty(email)  && !TextUtils.isEmpty(password)) {
            String id = database.push().getKey();                  // Para obtener el valor más alto y obtengo el valor clave
            Usuario usuario = new Usuario (idusuario,apellido,nombre,direccion, nacionalidad, fechanac, telefono, email, password);
            database.child("Usuario").child(id).setValue(usuario);
            Toast.makeText(MainActivity.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(MainActivity.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
    }


}