package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guardarJugador(View view){
        DatabaseReference ref = firebaseDatabase.getReference();
        DatabaseReference refPersonas = ref.child("personas");

        EditText editTextEquipo = findViewById(R.id.equipoName);
        EditText editTextNombre = findViewById(R.id.jugadorName);
        EditText editTextApellido = findViewById(R.id.jugadorApellido);
        EditText editTextHito = findViewById(R.id.jugadorHito);

        Jugador jugador = new jugador();

        jugador.setEquipo(editTextEquipo.getText().toString());
        jugador.setNombre(editTextNombre.getText().toString());
        jugador.setApellido(editTextApellido.getText().toString());
        jugador.setHito(editTextHito.getText().toString());


    }
}