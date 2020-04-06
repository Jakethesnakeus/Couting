package com.tangledstudio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameplayActivity extends AppCompatActivity {

    private static int START_VALUE , FINISH_VALUE ;
    private static int interval;
    private static int score;
    MainActivity m = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        submitAnswer();
    }

    private String userGuess(){
        int ug;
        String userGuess = ((EditText) findViewById(R.id.userGuess)).getText().toString();


        return userGuess;
    }


    private boolean isUserGuessValid(String userAnswer){
        try {
            int number = Integer.parseInt(userAnswer);
            return (number >= START_VALUE) && (number <= FINISH_VALUE);
        } catch (Exception e) {
            return false;
        }
    }

    public void submitAnswer(){
        final Button button = (Button) findViewById(R.id.answer);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = "";
                if(nextNumber() == true){
                    msg = " Correct answer:";

                } else {
                    msg = "This is not the next number in the sequence, try again.";

                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            }
        });
    }

    public boolean nextNumber(){

        String msg = "";

        if(isUserGuessValid(userGuess())) {
            while (START_VALUE <= FINISH_VALUE) {
                START_VALUE += interval;
                String guess = userGuess();
                int g2 = Integer.parseInt(guess);
                while (START_VALUE != 0) {
                    if (g2 != START_VALUE) {
                        System.out.println(guess + " is not the next number in the sequence, try again.");
                        msg = guess + " is not the next number in the sequence, try again.";
                        return false;
                    } else {
                        System.out.println(guess + " is the correct number:");
                        msg = guess + " is the correct number:";
                        return true;
                    }
                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            }
        }
        return false;
    }

}
