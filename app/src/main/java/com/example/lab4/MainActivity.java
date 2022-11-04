package com.example.lab4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.txt_layaout);

    }

    public void irAdmin(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityAdmin.class);
        startActivity(intent);

    }

    public void guardarJugador(View view){
        DatabaseReference ref = firebaseDatabase.getReference();
        DatabaseReference refPersonas = ref.child("personas");

        EditText editTextEquipo = findViewById(R.id.equipoName);
        EditText editTextNombre = findViewById(R.id.jugadorName);
        EditText editTextApellido = findViewById(R.id.jugadorApellido);
        EditText editTextHito = findViewById(R.id.jugadorHito);

        Jugador jugador = new Jugador();

        jugador.setEquipo(editTextEquipo.getText().toString());
        jugador.setNombreJugador(editTextNombre.getText().toString());
        jugador.setApellidoJugador(editTextApellido.getText().toString());
        jugador.setHito(editTextHito.getText().toString());


    }
}