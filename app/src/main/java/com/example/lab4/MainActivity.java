package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("IoT LAB 4");

    }

    public void irAdmin(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityAdmin.class);
        startActivity(intent);

    }
}