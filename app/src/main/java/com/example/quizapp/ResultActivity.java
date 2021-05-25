package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView score;
    private TextView remark;
    private Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        score = findViewById(R.id.final_score);
        remark = findViewById(R.id.remark);
        finish = findViewById(R.id.finish_btn);

        int s = getIntent().getIntExtra("score" , 0);
        score.setText(s + "/10");

        if(s < 4) {
            remark.setText("Work harder");
        }else if(s < 7){
            remark.setText("Good");
        }else{
            remark.setText("Excellent");
        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this , MainActivity.class));
                finish();
            }
        });
    }
}