package com.example.helinabelete.braintrainingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WordList extends AppCompatActivity {
    TextView countdown;
    TextView wordlist;
    CountDownTimer countDownTimer;
    int startTime = 10 * 1000; //10 seconds
    int interval = 1000; //1 second
    int level, numWords;
    String givenWords = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordlist);


        numWords = 7; //number of words
        countdown = (TextView) findViewById(R.id.cntDown);
        countDownTimer = new CountDownTimer(startTime,interval) {

            @Override
            public void onTick(long millisUntilFinished) {
                countdown.setText("Seconds Remaining: " + millisUntilFinished / 1000); //timer - countdown starting at 10
            }

            @Override
            public void onFinish() {
                Toast.makeText(WordList.this, "Time's Up!", Toast.LENGTH_SHORT).show(); //displays message that time is up
                Intent intent = new Intent(WordList.this, WordUserInput.class); //go to user input page when time runs out
                //Log.d("Given Words 2: ", givenWords); //debug
                intent.putExtra("givenWrds", givenWords); //carrying current list of words to next activity
                //Log.d("Given Words 3: ", givenWords);
                startActivity(intent);
            }
        };
        //countdown.setText(countdown.getText() + String.valueOf(startTime / 1000));
        //countDownTimer.start();
        countDownTimer.start(); //begin countdown



//Arrays of Words to pick from (for given words)
        String[] word = {"the","be","and","of","a","in","to","have","to","it","i","that","for","you","he","with",
                "on","do","say","this","they","at","but","we","his","from","that","not","qwerty","by","she","or",
                "as","what","go","their","can","who","get","if","would","her","all","my","make","about","know",
                "will","as","up","one","time","there","year","so","think","when","which","them","some","me",
                "people","take","out","into","just","see","him","your","come","could","now","than","like","other",
                "how","then","its","our","two","more","these","want","way","look","first","also","new","because","day",
                "more","use","no","man","find","here","thing","give","many","well","only","those","tell","one","very",
                "her","even","back","any","good","woman","through","us","life","child","there","work","down","may",
                "after","should","call","world","over","school","still","try","in","as","last","ask","need","too",
                "feel","three","when","state","never","become","between","high","really","something","most","another",
                "much","family","own","out","leave","put","old","while","mean","on","keep","student","why","let","great",
                "same","big","group","begin","seem","country","help","talk","where","turn","problem","every","start","hand",
                "might","american","show","part","about","against","place","over","such","again","few","case","most","week",
                "company","where","system","each","right","program","hear","so","question","during","work","play","government",
                "run","small","number","off","always","move","like","night","live","mr","point","believe","hold","today","bring",
                "happen","next","without","before","large","all","million","must","home","under","water","room","write","mother",
                "area","national","money","story","young","fact","month","different","lot","right","study","book","eye","job",
                "word","though","business","issue","side","kind","four","head","far","black","long","both","little","house","yes",
                "after","since","long","provide","service","around","friend","important","father","sit","away","until","power",
                "hour","game","often","yet","line","political","end","among","ever","stand","bad","lose","however","member","pay",
                "law","meet","car","city","almost","include","continue","set","later","community","much","name","five","once",
                "white","least","president","learn","real","change","team","minute","best","several","idea","kid","body",
                "information","nothing","ago","right","lead","social","understand","whether","back","watch","together","follow",
                "around","parent","only","stop","face","anything","create","public","already","speak","others","read","level",
                "allow","add","office","spend","door","health","person","art","sure","such","war","history","party","within","grow",
                "result","open","change","morning","walk","reason","low","win","research","girl","guy","early","food","before","moment"};

        String[] chosenWords = new String[numWords]; //new string array
        //Log.d("Chosen Words Array: ", Arrays.toString(chosenWords));

        int i;
        for(i=0;i<numWords;++i){
            Random rand = new Random();
            int randomNum = rand.nextInt(100); //pick a random number
            if(!(Arrays.asList(chosenWords).contains(word[randomNum]))) //avoids repetition
                chosenWords[i]=word[randomNum]; //populate chosenWords with words at the index number provided by Random()
        }
        for(i=0;i<numWords;++i){
            givenWords += chosenWords[i]; //copy string array into a string
            givenWords += "\n"; //new line
        }

        wordlist = (TextView) findViewById(R.id.wordDisplay);
        wordlist.setText(givenWords);
        //Log.d("Given Words 1: ", givenWords);
    }

    @Override
    public void onBackPressed() {}

    @Override
    protected void onStop() {
        super.onStop();
    }


    }

