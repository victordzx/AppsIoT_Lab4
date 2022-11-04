package com.example.lab4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityAdmin extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_layaout);

    }

    public void guardarJugador(View view){

        DatabaseReference ref = firebaseDatabase.getReference();
        DatabaseReference refJugador = ref.child("jugador");

        EditText editTextEquipo = findViewById(R.id.equipoName);
        EditText editTextNombre = findViewById(R.id.jugadorName);
        EditText editTextApellido = findViewById(R.id.jugadorApellido);
        EditText editTextHito = findViewById(R.id.jugadorHito);

        Jugador jugador = new Jugador();

        jugador.setEquipo(editTextEquipo.getText().toString());
        jugador.setNombreJugador(editTextNombre.getText().toString());
        jugador.setApellidoJugador(editTextApellido.getText().toString());
        jugador.setHito(editTextHito.getText().toString());

        Toast.makeText( MainActivityAdmin.this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();


    }
}