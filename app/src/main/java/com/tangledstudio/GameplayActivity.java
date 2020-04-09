package com.tangledstudio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameplayActivity extends AppCompatActivity {
    MainActivity m = new MainActivity();
    private int START_VALUE;
    private int FINISH_VALUE;
    private int interval;;
    private int score;

    public void loadGameParams() {
        interval = m.getInterval(this);
        START_VALUE = m.getStartValue(this);
        FINISH_VALUE = m.getFinishValue(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        loadGameParams();

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
                   compareNumbers();

            }
        });
    }

    public boolean compareNumbers(){
        String msg = "";


        String guess = userGuess();
        int g2 = Integer.parseInt(guess);

        for (int i = START_VALUE; i <= FINISH_VALUE; i += interval){

            if(g2 == nextNumber()){
                msg = " Correct answer:";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                return true;
            } else {
                msg = "This is not the next number in the sequence, try again.";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                return false;
            }


        }
        return false;
    }

    public int nextNumber(){
        START_VALUE += interval;
        m.setStartValue(this, START_VALUE);
        return START_VALUE;
    }

}
