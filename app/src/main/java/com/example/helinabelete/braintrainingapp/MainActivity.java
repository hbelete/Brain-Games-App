package com.example.helinabelete.braintrainingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startMemory;
    Button startMath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startMemory = (Button) findViewById(R.id.memory);
        startMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent = new Intent(MainActivity.this, WordInstructions.class);
                startActivity(intent); //start memory game
            }
        });

        startMath = (Button) findViewById(R.id.math);
        startMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent = new Intent(MainActivity.this, difficulty_choice.class);
                startActivity(intent); //start math game
            }
        });


    }
}
