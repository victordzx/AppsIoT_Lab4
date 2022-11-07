package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Iterator;
import java.util.Objects;

public class UserActivity extends AppCompatActivity {
    Button btnAlineaciones;
    Button btnHitos;
    TextView tvMsg;
    String equipoa;
    String equipob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnAlineaciones = findViewById(R.id.btnLineups);
        btnHitos = findViewById(R.id.btnHitos);
        tvMsg = findViewById(R.id.tvUser);

        btnHitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, HitosActivity.class));
                finish();
            }
        });
    }

    public void listHitos(View view) {
        Intent intent = new Intent(UserActivity.this, HitosActivity.class);
        startActivity(intent);
    }

    public void listLineups(View view){
        Intent intent = new Intent(UserActivity.this, LineupTeam.class);
        startActivity(intent);
    }
}