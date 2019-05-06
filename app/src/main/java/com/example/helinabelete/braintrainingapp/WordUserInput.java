package com.example.helinabelete.braintrainingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WordUserInput extends AppCompatActivity {
    EditText userInput;
    Button done;
    String givenWords = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_user_input);


        Intent intent = getIntent(); //gets intent from previous activity (WordList.class)
        givenWords = intent.getStringExtra("givenWrds");//populate the string (givenWords) with data

        //Log.d("Test 2 - Given Words: ", givenWords);

        //Setting onClickListener for "Done"
        done = (Button) findViewById(R.id.btn_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent = new Intent(WordUserInput.this, Result.class); //when clicked, switch to show results
                userInput = (EditText) findViewById(R.id.user_input);
                String enteredInput = userInput.getText().toString(); //take and convert user's answer to string format and save in new string variable "enteredInput"
                intent.putExtra("userInput",enteredInput); //store user's answers and carries to next activities
                intent.putExtra("givenWrds",givenWords); //store initial list of words and carries to next activities
                startActivity(intent);
                //Log.d("User Input: ", enteredInput);
                //Log.d("Given Words: ", givenWords);
            }
        });

    }

    @Override
    public void onBackPressed() {}
}
