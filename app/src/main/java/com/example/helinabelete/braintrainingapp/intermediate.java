package com.example.helinabelete.braintrainingapp;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class intermediate extends AppCompatActivity {

    Random rand;
    public int ansValue, incorrect, correct;
    public int counter = 30;
    TextView Problem;
    Button ans_btn;
    EditText user_ans;
    TextView calc_mess, num_correct, timer, results;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);

        Problem = (TextView) findViewById(R.id.Problem);
        rand = new Random();
        ans_btn = (Button) findViewById(R.id.ans_btn);
        user_ans = (EditText) findViewById(R.id.user_ans);
        calc_mess = (TextView) findViewById(R.id.calc);
        start = (Button) findViewById(R.id.start) ;
        num_correct = (TextView) findViewById(R.id.num_correct);
        timer = (TextView) findViewById(R.id.timer);
        results = (TextView) findViewById(R.id.results);

        ans_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (Integer.parseInt(user_ans.getText().toString()) == ansValue) {
                        correct++;
                    } else {
                        incorrect++;
                    }

                    user_ans.getText().clear();
                    updateStats();
                    generateIntProblem(view);
                }
                catch (NumberFormatException e) {

                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans_btn.setVisibility(View.VISIBLE);
                calc_mess.setVisibility(View.VISIBLE);
                user_ans.setVisibility(View.VISIBLE);
                num_correct.setVisibility(View.VISIBLE);
                start.setVisibility(View.GONE);
                timer.setVisibility(View.VISIBLE);
                Problem.setVisibility(View.VISIBLE);
                generateIntProblem(v);

                new CountDownTimer(30000, 1000){
                    public void onTick(long time_left){
                        timer.setText(String.format("%d seconds",counter));
                        counter--;
                    }

                    public void onFinish(){
                        ans_btn.setVisibility(View.INVISIBLE);
                        calc_mess.setVisibility(View.INVISIBLE);
                        user_ans.setVisibility(View.INVISIBLE);
                        num_correct.setVisibility(View.INVISIBLE);
                        timer.setVisibility(View.INVISIBLE);
                        Problem.setVisibility(View.INVISIBLE);
                        results.setText(String.format("You answered %d out of %d intermediate questions correctly in 30 seconds!", correct, correct + incorrect));
                        results.setVisibility(View.VISIBLE);

                    }
                }.start();
            }
        });

    }

    private void updateStats() {
        num_correct.setText(String.format("%d correct, %d incorrect", correct, incorrect));
    }

    public void generateIntProblem(View view) {
        int num1 = rand.nextInt(20);
        int num2 = rand.nextInt(20);
        int index = rand.nextInt(4) - 1;

        switch (index) {
            case 0:
                ansValue = num1 + num2;
                Problem.setText(String.format("%d + %d = ?", num1, num2));
                break;
            case 1:
                if (num2 > num1) {
                    // make sure the answer is positive
                    int temp = num2;
                    num2 = num1;
                    num1 = temp;
                }
                ansValue = num1 - num2;
                Problem.setText(String.format("%d - %d = ?", num1, num2));
                break;
            case 2:
                ansValue = num1 * num2;
                Problem.setText(String.format("%d x %d = ?", num1, num2));
                break;
            case 3:
                ansValue = num1 / num2;
                num1 = ansValue * num2; // update x from the integer division above, to make sure
                // x properly divides by y
                Problem.setText(String.format("%d / %d = ?", num1, num2));
                break;
        }
    }
}