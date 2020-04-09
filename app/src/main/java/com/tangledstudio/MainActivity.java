package com.tangledstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                startActivity(gamePlayActivity);
            }
        });
    }

    public void userInputValues(){
        String enterStartNumber = ((EditText) findViewById(R.id.startNumber)).getText().toString();
        START_VALUE = Integer.parseInt(enterStartNumber);
        setStartValue(this,START_VALUE );

        String enterFinishNumber = ((EditText) findViewById(R.id.endNumber)).getText().toString();
        FINISH_VALUE = Integer.parseInt(enterFinishNumber);
        setFinishValue(this,FINISH_VALUE);

        String enterNumberInterval = ((EditText) findViewById(R.id.numberInterval)).getText().toString();
        interval = Integer.parseInt(enterNumberInterval);
        setInterval(this, interval);
    }

    public static void setStartValue(Context context, int startVal){
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("startval", START_VALUE);
        editor.commit();
    }
    public static void setFinishValue(Context context, int finVal){
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("finishval", FINISH_VALUE);
        editor.commit();
    }
    public static void setInterval(Context context, int intVal){
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("interval", interval);
        editor.commit();
    }
    public static int getStartValue(Context context){
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        return prefs.getInt("startval",0);
    }
    public static int getFinishValue(Context context){
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        return prefs.getInt("finishval",0);
    }
    public static int getInterval(Context context){
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        return prefs.getInt("interval",0);
    }

}
