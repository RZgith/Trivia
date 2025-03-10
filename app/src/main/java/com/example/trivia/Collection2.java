package com.example.trivia;

import java.util.ArrayList;
import java.util.Collections;

public class Collection2  {
    private ArrayList<Question> arr,arr2;
    private int index;

    public Collection2()
    {
        arr=new ArrayList<>();
        Question q1=new Question("1+10","11","3","100","110",1);
        Question q2=new Question("1+2","12","3","100","30",2);
        Question q3=new Question("1+4","15","3","5","11",3);
        Question q4=new Question("3+4","7","9","34","1",1);
        Question q5=new Question("10+6","15","106","16","11",3);
        Question q6=new Question("5+6","12","1","66","11",4);
        Question q7=new Question("10+3","13","16","1","11",1);
        Question q8=new Question("4+6","15","10","16","11",2);


        arr.add(q1);
        arr.add(q2);
        arr.add(q3);
        arr.add(q4);
        arr.add(q5);
        arr.add(q6);
        arr.add(q7);
        arr.add(q8);
        Collections.shuffle(arr);





    }
    public void initQuestion()
    {
        index=0;

        Collections.shuffle(arr);


    }




    public Question getNextQuestion()
    {
        Question q=arr.get(index);
        index++;
        return q;
    }
    public boolean isNotLastQuestion()
    {
        return (index<arr.size());
    }
    public int getIndex()
    {
        return index;
    }
}
