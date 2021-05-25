package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        findViewById(R.id.btn_bio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz("bio");
            }
        });

        findViewById(R.id.btn_gk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz("gk");
            }
        });

    }


    private void startQuiz(String category){
        Intent intent = new Intent(SelectCategory.this , QuizActivity.class);
        intent.putExtra("category" , category);
        intent.putExtra("qNo" , 0);
        intent.putExtra("score" , 0);
        startActivity(intent);
    }
}