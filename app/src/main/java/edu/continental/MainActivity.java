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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

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


    FirebaseAuth mAuth;
     DatabaseReference database;
    //private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

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


    }


    @Override
    public void onClick(View v) {
        registrarUsuario();
    }

    private void registrarUsuario(){
        final String idusuario = edtidUsuario.getText().toString();
        final String apellido = edtApellido.getText().toString();
        final String nombre = edtnombre.getText().toString();
        final String direccion = edtdireccion.getText().toString();
        final String nacionalidad = edtNacionalidad.getText().toString();
        final String fechanac = edtfechaNac.getText().toString();
        final String telefono = edtTelefono.getText().toString();
        final String email = edtemail.getText().toString();
        final String password = edtContrasenia.getText().toString();
        System.out.println("guardado");

        if (!TextUtils.isEmpty(idusuario) && !TextUtils.isEmpty(apellido)  && !TextUtils.isEmpty(nombre)  && !TextUtils.isEmpty(direccion)  && !TextUtils.isEmpty(nacionalidad)
                && !TextUtils.isEmpty(fechanac)  && !TextUtils.isEmpty(telefono)  && !TextUtils.isEmpty(email)  && !TextUtils.isEmpty(password)) {
           mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       Map<String, Object> map = new HashMap<>();
                       map.put("idusuario", idusuario);
                       map.put("apellido", apellido);
                       map.put("nombre", nombre);
                       map.put("direccion", direccion);
                       map.put("nacionalidad", nacionalidad);
                       map.put("fechanac", fechanac);
                       map.put("telefono", telefono);
                       map.put("email", email);
                       map.put("password", password);
                       String id = mAuth.getCurrentUser().getUid();
                       database.child("usuario").child(id).setValue(map)
                               .addOnCompleteListener(new OnCompleteListener<Void>() {//validacion
                           @Override
                           public void onComplete(@NonNull Task<Void> task2) {
                               if(task2.isSuccessful()){
                                   startActivity(new Intent(MainActivity.this, PerfilActivity.class));
                                   System.out.println("perfilactivity pasar");
                                   finish();
                               }else{
                                   Toast.makeText(MainActivity.this, "no se crearon los datos correctamente", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                   }
               }
           });

            Toast.makeText(MainActivity.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, PerfilActivity.class));
            finish();
        }
        else Toast.makeText(MainActivity.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
    }


}