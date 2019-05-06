package com.example.helinabelete.braintrainingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WordInstructions extends AppCompatActivity{
    TextView instructions;
    Button play;
    Button go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_rules);

        instructions = (TextView) findViewById(R.id.instructions);

        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent = new Intent(WordInstructions.this, WordList.class);
                startActivity(intent);
            }
        }); //if clicked, begin game (starts by displaying list of words with countdown)

        go_back = (Button) findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent = new Intent(WordInstructions.this, MainActivity.class);
                startActivity(intent); //if clicked, return back to homepage
            }
        });




    }

}
