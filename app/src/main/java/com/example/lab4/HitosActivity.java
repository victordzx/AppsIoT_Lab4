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
import java.util.ArrayList;

public class HitosActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Hitos");
        setContentView(R.layout.activity_hitos);

        ArrayList<Hito> listaHito = new ArrayList<>();

        RecyclerView recyclerView1 = findViewById(R.id.recycleView_Hitos1);
        HitoAdapter hitoAdapter1 = new HitoAdapter(listaHito);
        recyclerView1.setAdapter(hitoAdapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(HitosActivity.this));

        RecyclerView recyclerView2 = findViewById(R.id.recycleView_Hitos2);
        HitoAdapter hitoAdapter2 = new HitoAdapter(listaHito);
        recyclerView2.setAdapter(hitoAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(HitosActivity.this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference().child("hitos");

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (firstTime){
                    firstTime =false;
                }
                Hito hito = snapshot.getValue(Hito.class);
                listaHito.add(hito);
                hitoAdapter1.notifyItemInserted(listaHito.size()-1);
                hitoAdapter2.notifyItemInserted(listaHito.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}