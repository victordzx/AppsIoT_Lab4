package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LineupTeam extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Hito> list = new ArrayList<>();

    ArrayList<TextView> teamAPlayer = new ArrayList<>();
    ArrayList<TextView> teamBPlayer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineup_team);

        teamAPlayer.add(findViewById(R.id.player1a));
        teamAPlayer.add(findViewById(R.id.player2a));
        teamAPlayer.add(findViewById(R.id.player3a));
        teamAPlayer.add(findViewById(R.id.player4a));
        teamAPlayer.add(findViewById(R.id.player5a));
        teamAPlayer.add(findViewById(R.id.player6a));
        teamAPlayer.add(findViewById(R.id.player7a));
        teamAPlayer.add(findViewById(R.id.player8a));
        teamAPlayer.add(findViewById(R.id.player9a));
        teamAPlayer.add(findViewById(R.id.player10a));
        teamAPlayer.add(findViewById(R.id.player11a));

        teamBPlayer.add(findViewById(R.id.player1b));
        teamBPlayer.add(findViewById(R.id.player2b));
        teamBPlayer.add(findViewById(R.id.player3b));
        teamBPlayer.add(findViewById(R.id.player4b));
        teamBPlayer.add(findViewById(R.id.player5b));
        teamBPlayer.add(findViewById(R.id.player6b));
        teamBPlayer.add(findViewById(R.id.player7b));
        teamBPlayer.add(findViewById(R.id.player8b));
        teamBPlayer.add(findViewById(R.id.player9b));
        teamBPlayer.add(findViewById(R.id.player10b));
        teamBPlayer.add(findViewById(R.id.player11b));


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("partido").child("FIBRA TOXICA");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Hito player = dataSnapshot.getValue(Hito.class);
                    list.add(player);
                    System.out.println(player.getNombreJugador());
                }

                String player = "txtPUCP";
                boolean n = true;
                for (int i = 0; i < Math.min(list.size(), teamAPlayer.size()); i++) {
                    teamAPlayer.get(i).setText(list.get(i).getNombreJugador());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}