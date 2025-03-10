package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InstructionActivity2 extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction2);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        finish();
    }
}