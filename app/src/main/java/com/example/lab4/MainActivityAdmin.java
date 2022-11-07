package com.example.lab4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityAdmin extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;

    public void abrirMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_layaout);

    }

    public void guardarJugador(View view){
        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference().child("users");
        System.out.println("Probando");


        EditText editTextEquipo = findViewById(R.id.equipoName);
        EditText editTextNombre = findViewById(R.id.jugadorName);
        EditText editTextApellido = findViewById(R.id.jugadorApellido);
        EditText editTextHito = findViewById(R.id.jugadorHito);

        System.out.println("Probando2");

        Hito hito = new Hito();

        hito.setEquipo(editTextEquipo.getText().toString());
        hito.setNombreJugador(editTextNombre.getText().toString());
        hito.setApellidoJugador(editTextApellido.getText().toString());
        hito.setHito(editTextHito.getText().toString());

        DatabaseReference ref2 = ref;
        //ref2.push().setValue(hito);


        ref2.push().setValue(hito)
                .addOnSuccessListener(aVoid ->{
                    Log.d("msg","Data guardada exitosamente");
                    Toast.makeText(MainActivityAdmin.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Log.d("msg",e.getMessage());
                });



    }
}