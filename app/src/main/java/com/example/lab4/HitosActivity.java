package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.lab4.Adaptadores.HitoAdapter;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HitosActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    boolean firstTime = true;
    DatabaseReference ref;
    ArrayList<Hito> listaHito = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Hitos");
        setContentView(R.layout.activity_hitos);

        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference("users");

        RecyclerView recyclerView1 = findViewById(R.id.recycleView_Hitos1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(HitosActivity.this));
        RecyclerView recyclerView2 = findViewById(R.id.recycleView_Hitos2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(HitosActivity.this));

        HitoAdapter hitoAdapter1 = new HitoAdapter();
        hitoAdapter1.setListaHito(listaHito);
        HitoAdapter hitoAdapter2 = new HitoAdapter();
        hitoAdapter2.setListaHito(listaHito);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    Hito hito = dataSnapshot.getValue(Hito.class);
                    listaHito.add(hito);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

}