package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InstructionActivity2 extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction2);
        tv=findViewById(R.id.tv);
        tv.setText("Instructions:\n" +
                "To start playing you have to enter with \n" +

                "the button start a game,\n"+
                " and there will appear questions \n" +
                "that to answer\n" +
                " them you have to click on the\n " +
                "correct answer.\n" +
                "In addition, you can change\n " +
                "the background color\n" +
                " by going to the settings and choosing\n" +
                "a different color there.\n");

    }
}