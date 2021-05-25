package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.data.Questions;
import com.example.quizapp.model.Question;

public class QuizActivity extends AppCompatActivity {

    private Button qNxt;
    private TextView q_no_view;
    private TextView qTxt;
    private TextView qOpt1;
    private TextView qOpt2;
    private TextView qOpt3;
    private TextView qOpt4;
    private TextView qRes;

    private String category;
    private int qNo;
    private Question currentQuestion;

    private boolean answered = false;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initializeUi();

        qRes.setVisibility(View.GONE);

        category = getIntent().getStringExtra("category");
        qNo = getIntent().getIntExtra("qNo" , 0);
        score = getIntent().getIntExtra("score" , 0);

        if(qNo == 9) {
            qNxt.setText("Finish");
        }

        switch (category) {
            case "bio" : {
                currentQuestion = Questions.BiologyQuestions[qNo];
                setData();
                break;
            }
            case "gk" : {
                currentQuestion = Questions.GeneralKnowledge[qNo];
                setData();
                break;
            }
            default:{
                Toast.makeText(QuizActivity.this , "Wrong category given" , Toast.LENGTH_LONG).show();
            }
        }

        qNxt.setOnClickListener(v -> {
            if(qNo == 9) {
                Intent intent = new Intent(QuizActivity.this , ResultActivity.class);
                intent.putExtra("score" , score);
                startActivity(intent);
                finish();
            }else {
                Intent intent = new Intent(QuizActivity.this , QuizActivity.class);
                intent.putExtra("category" , category);
                intent.putExtra("qNo" , qNo + 1);
                intent.putExtra("score" , score);
                startActivity(intent);
            }
        });

        qOpt1.setOnClickListener(v -> {
            if(!answered) {
                answered = true;
                if(currentQuestion.getCorrectAnswer() == 0){
                    qRes.setText("Correct answer");
                    qRes.setTextColor(Color.rgb(0 , 255 , 0 ));
                    this.score += 1;
                }else{
                    qRes.setTextColor(Color.rgb(255 , 0 , 0 ));
                    qRes.setText("Wrong answer");
                }
                qRes.setVisibility(View.VISIBLE);
            }
        });

        qOpt2.setOnClickListener(v -> {
            if(!answered) {
                answered = true;
                if(currentQuestion.getCorrectAnswer() == 1){
                    qRes.setText("Correct answer");
                    qRes.setTextColor(Color.rgb(0 , 255 , 0 ));
                    this.score += 1;
                }else{
                    qRes.setTextColor(Color.rgb(255 , 0 , 0 ));
                    qRes.setText("Wrong answer");
                }
                qRes.setVisibility(View.VISIBLE);
            }
        });

        qOpt3.setOnClickListener(v -> {
            if(!answered) {
                answered = true;
                if(currentQuestion.getCorrectAnswer() == 2){
                    qRes.setText("Correct answer");
                    qRes.setTextColor(Color.rgb(0 , 255 , 0 ));
                    this.score += 1;
                }else{
                    qRes.setTextColor(Color.rgb(255 , 0 , 0 ));
                    qRes.setText("Wrong answer");
                }
                qRes.setVisibility(View.VISIBLE);
            }
        });

        qOpt4.setOnClickListener(v -> {
            if(!answered) {
                this.answered = true;
                if(currentQuestion.getCorrectAnswer() == 3){
                    this.qRes.setText("Correct answer");
                    this.qRes.setTextColor(Color.rgb(0 , 255 , 0 ));
                    this.score += 1;
                }else{
                    this.qRes.setTextColor(Color.rgb(255 , 0 , 0 ));
                    this.qRes.setText("Wrong answer");
                }
                this.qRes.setVisibility(View.VISIBLE);
            }
        });
    }

    private void setData(){
        this.q_no_view.setText("Question number " + qNo);
        this.qTxt.setText(currentQuestion.getQuestion());
        this.qOpt1.setText(currentQuestion.getOptions()[0]);
        this.qOpt2.setText(currentQuestion.getOptions()[1]);
        this.qOpt3.setText(currentQuestion.getOptions()[2]);
        this.qOpt4.setText(currentQuestion.getOptions()[3]);
    }

    private void initializeUi(){
        this.qNxt = findViewById(R.id.q_next);
        this.qTxt = findViewById(R.id.q_txt);
        this.qOpt1 = findViewById(R.id.q_opt1);
        this.qOpt2 = findViewById(R.id.q_opt2);
        this.qOpt3 = findViewById(R.id.q_opt3);
        this.qOpt4 = findViewById(R.id.q_apt4);
        this.qRes = findViewById(R.id.q_res);
        this.q_no_view = findViewById(R.id.q_no);
    }
}