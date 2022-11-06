package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LineupTeam extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineup_team);

        Intent intent = getIntent();
        Button btn_equipoa = findViewById(R.id.btnEquipoA);
        Button btn_equipob = findViewById(R.id.btnEquipoB);
        btn_equipoa.setText(intent.getStringExtra("equipoA"));
        btn_equipob.setText(intent.getStringExtra("equipoB"));
    }

    public void Buttons(View view){
        intent = new Intent(this, LineupActivity.class);
        intent.putExtra("equipo", ((Button) view).getText());
        startActivity(intent);
    }
}