package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab4.Adaptadores.LineupAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LineupActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Alineaciones");
        setContentView(R.layout.activity_lineup);
        RecyclerView recyclerView =findViewById(R.id.recyclerView_lineups);

        ArrayList<Hito> listaHito = new ArrayList<>();
        ArrayList<String> listaPlayers = new ArrayList<>();
        Intent intent = getIntent();
        String comparar =(String) intent.getStringExtra("equipo");
        TextView tv = findViewById(R.id.textView_nameEquipo);
        tv.setText(comparar);
        LineupAdapter lineupAdapter = new LineupAdapter(listaPlayers);
        recyclerView.setAdapter(lineupAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(LineupActivity.this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference().child("hitos");
        ref.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.getChildren()){
                    listaHito.add(d.getValue(Hito.class));
                }
                for(Hito hitoPlayer : listaHito){
                    if(hitoPlayer.getEquipo().equals(comparar)){
                        String player = hitoPlayer.getNombreJugador()+" "+hitoPlayer.getApellidoJugador();
                        if(!listaPlayers.contains(player)){
                            listaPlayers.add(player);
                        }
                    }
                }
                lineupAdapter.notifyDataSetChanged();
            }
        });
    }
}