package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btna1,btna2,btna3,btna4;
    private TextView tvQuestion;
    private TextView tvQuestionNumber,tvPoints,tvGameOver;
    private Question currentQuestion;
    private Collection2 collection;
    private LinearLayout ll2;
    private String color;
    private int points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ll2=findViewById(R.id.activity_game);
        Intent i=getIntent();
        color=i.getStringExtra("color");
        if(!"1".equals(color)&& color != null){setBackgrounColor2(color);}



        collection=new Collection2();

        tvQuestion=findViewById(R.id.tvQuestion);
        btna1=findViewById(R.id.btna1);
        btna2=findViewById(R.id.btna2);
        btna3=findViewById(R.id.btna3);
        btna4=findViewById(R.id.btna4);

        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);

        tvPoints=findViewById(R.id.tvPoints);
        tvQuestionNumber=findViewById(R.id.tvQuestionNumber);
        tvGameOver=findViewById(R.id.tvGameOver);

        tvGameOver.setVisibility(View.INVISIBLE);

        collection.initQuestion();
        nextQuestion();


    }


    private void nextQuestion() {
        if (collection.isNotLastQuestion())
        {
            currentQuestion=collection.getNextQuestion();
            tvQuestion.setText(currentQuestion.getQuestion());
            btna1.setText(currentQuestion.getA1());
            btna2.setText(currentQuestion.getA2());
            btna3.setText(currentQuestion.getA3());
            btna4.setText(currentQuestion.getA4());
        }
        else {
            tvGameOver.setVisibility(View.VISIBLE);
            CustomDialog customDialog=new CustomDialog(this);
            customDialog.show();
        }

    }
    public void setBackgrounColor2(String color)
    {
        switch (color)
        {
            case "Red":
            {
                ll2.setBackgroundColor(Color.argb(255,240,128,128));
                break;
            }
            case "Blue":
            {
                ll2.setBackgroundColor(Color.argb(255,135,206,235));
                break;
            }
            case "Pink":
            {
                ll2.setBackgroundColor(Color.argb(255,219,112,147));
                break;
            }

            case "Yellow":
            {
                ll2.setBackgroundColor(Color.argb(255,255,250,205));
                break;
            }
            default:
                ll2.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onClick(View v) {
        if(v==btna1)
        {
            if(currentQuestion.getCorrect()==1){
                points++;
            }
        }
        if(v==btna2)
        {
            if(currentQuestion.getCorrect()==2){
                points++;
            }
        }
        if(v==btna3)
        {
            if(currentQuestion.getCorrect()==3){
                points++;
            }
        }
        if(v==btna4)
        {
            if(currentQuestion.getCorrect()==4){
                points++;
            }
        }
        tvPoints.setText("points: "+points);
        if (collection.isNotLastQuestion()){
            tvQuestionNumber.setText("Question number: "+(collection.getIndex()+1));
        }
        nextQuestion();

    }

    public void reset() {
        points=0;
        collection.initQuestion();
        tvPoints.setText("points: "+points);
        tvQuestionNumber.setText("Question number: "+1);
        tvGameOver.setVisibility(View.INVISIBLE);
        this.nextQuestion();

    }
}