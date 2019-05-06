package com.example.helinabelete.braintrainingapp;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class difficulty_choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_choice);
    }

    Button beg_btn;
    Button int_btn;
    Button adv_btn;
    Random rnd;
    TextView Problem;
    int ansValue;

    public void newBegGame(View view) {
        Intent startBegGame = new Intent(this, beginner.class);
        startActivity(startBegGame);
    }

    public void newIntGame(View view) {
        Intent startIntGame = new Intent(this, intermediate.class);
        startActivity(startIntGame);
    }

    public void newAdvGame(View view) {
        Intent startAdvGame = new Intent(this, advanced.class);
        startActivity(startAdvGame);
    }
}