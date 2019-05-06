package com.example.helinabelete.braintrainingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class Result extends AppCompatActivity {
    TextView givenWrdsTextResult,correctWrdsTextResult,wrongWrdsTextResult,givenWrdsTexTitle,correctWrdsTextTitle,wrongWrdsTextTitle;
    TextView displayResult;
    Button playAgain;
    Button goBack;
    String correctWrds="",wrongWrds="";
    int numCorrectWrds=0,numWrongWrds=0;
    int numWrds=7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_result);


        Intent intent = getIntent(); //retrieve intent
        String userEnteredWords = intent.getStringExtra("userInput"); //retrieve user's input
        String[] userEnteredWordsArray = userEnteredWords.split(" "); //create an array from the String userEnteredWords, separated by space


        String displayGivenWords = intent.getStringExtra("givenWrds"); //retrieve given Words
        //Log.d("displayGivenWords", displayGivenWords);
        String[] displayGivenWordsArray = displayGivenWords.split("\n"); //separate the list by line and enter it into the empty string array
        String[] givenWrds_copy = Arrays.copyOf(displayGivenWordsArray, displayGivenWordsArray.length); //copy of given words (for iterating without changing the list)

        int numuserEnteredWords = userEnteredWordsArray.length;
        int numGivenWords = displayGivenWordsArray.length;

        int index;
        for(int i=0;i<numuserEnteredWords;++i) {
            if (Arrays.asList(givenWrds_copy).contains(userEnteredWordsArray[i])){ //if user's input exist in given words
                index = Arrays.asList(givenWrds_copy).indexOf(userEnteredWordsArray[i]);
                givenWrds_copy[index]= null;
                correctWrds += userEnteredWordsArray[i]; //append user's input in correct string
                correctWrds +="\n"; //becomes a list (one word per line)
                ++numCorrectWrds; //increment number of correct
            }
            else{
                if(userEnteredWordsArray[i] != ""){ //user's input does not exist in given words array
                    wrongWrds += userEnteredWordsArray[i]; //append user's input in incorrect string
                    wrongWrds +="\n"; //becomes a list (one word per line)
                    ++numWrongWrds; //increment number of incorrect
                }
            }
        }


        givenWrdsTexTitle = (TextView) this.findViewById(R.id.label_gvn);
        givenWrdsTexTitle.setText("Given Words : " + String.valueOf(numWrds)); //given word label

        givenWrdsTextResult = (TextView) this.findViewById(R.id.gvn_words);
        givenWrdsTextResult.setText(displayGivenWords); //list of given words

        correctWrdsTextTitle = (TextView) this.findViewById(R.id.label_correct);
        correctWrdsTextTitle.setText("Correct Words : " + String.valueOf(numCorrectWrds)); //correct words label

        correctWrdsTextResult = (TextView) this.findViewById(R.id.correct_words);
        correctWrdsTextResult.setText(correctWrds); //display list of user's input that were correct


        wrongWrdsTextTitle = (TextView) this.findViewById(R.id.label_incorrect);
        wrongWrdsTextTitle.setText("Incorrect Words : "+String.valueOf(numWrongWrds)); //incorrect words label


        wrongWrdsTextResult = (TextView) this.findViewById(R.id.incorrect_words);
        wrongWrdsTextResult.setText(wrongWrds); //display list of user's input that were wrong

        displayResult = (TextView) findViewById(R.id.result);

        //Log.d("Num Words: ", String.valueOf(numWrds));
        //Log.d("Number of Correct Words: ", String.valueOf(numCorrectWrds));
        displayResult.setText("You got " + numCorrectWrds + "/" + numWrds + " correct!"); //displays result

//Play Again onClickListener
        playAgain = (Button) findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent = new Intent(Result.this, WordList.class);
                startActivity(intent); //go back to wordlist (immediately begins game)
            }
        });

        //Return to Homepage onClickListener
        goBack = (Button) findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent); //go back to home screen page
            }
        });


    }
}
