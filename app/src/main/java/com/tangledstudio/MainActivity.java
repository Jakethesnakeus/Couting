package com.tangledstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static int START_VALUE , FINISH_VALUE ;
    private static int interval;
    private static int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOne = findViewById(R.id.button);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                userInputValues();
                Intent gamePlayActivity = new Intent(getApplicationContext(), GameplayActivity.class);
                gamePlayActivity.putExtra("start", START_VALUE);
                gamePlayActivity.putExtra("End value", FINISH_VALUE);
                gamePlayActivity.putExtra("Interval", interval);
                startActivity(gamePlayActivity);
            }
        });
    }

    public void userInputValues(){
        String enterStartNumber = ((EditText) findViewById(R.id.startNumber)).getText().toString();
        START_VALUE = Integer.parseInt(enterStartNumber);

        String enterFinishNumber = ((EditText) findViewById(R.id.endNumber)).getText().toString();
        FINISH_VALUE = Integer.parseInt(enterFinishNumber);

        String enterNumberInterval = ((EditText) findViewById(R.id.numberInterval)).getText().toString();
        interval = Integer.parseInt(enterNumberInterval);
    }
}
