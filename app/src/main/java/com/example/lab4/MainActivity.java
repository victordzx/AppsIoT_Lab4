package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

        Jugador jugador = new jugador();

        jugador.setEquipo(editTextEquipo.getText().toString());
        jugador.setNombre(editTextNombre.getText().toString());
        jugador.setApellido(editTextApellido.getText().toString());
        jugador.setHito(editTextHito.getText().toString());


    }
}