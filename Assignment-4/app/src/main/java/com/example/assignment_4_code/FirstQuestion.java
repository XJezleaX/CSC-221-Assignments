package com.example.assignment_4_code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import com.example.assignment_4_code.databinding.FirstQuestionLayoutBinding;

import android.widget.TextView;
import android.widget.Toast;

public class FirstQuestion extends AppCompatActivity implements View.OnClickListener {
    FirstQuestionLayoutBinding firstQuestionLayoutBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstQuestionLayoutBinding = firstQuestionLayoutBinding.inflate(getLayoutInflater());
        setContentView(firstQuestionLayoutBinding.getRoot());


        firstQuestionLayoutBinding.onebtnOne.setOnClickListener(this);
        firstQuestionLayoutBinding.onebtnTwo.setOnClickListener(this);
        firstQuestionLayoutBinding.onebtnThree.setOnClickListener(this);

    }

    public void onClick(View v) {
        int score = getIntent().getIntExtra("score", 0);
        //int score = Integer.parseInt(firstQuestionLayoutBinding.countNum.getText().toString());
        if (v.getId() == R.id.onebtnOne) {
            Message("Incorrect");
        }
        else if (v.getId() == R.id.onebtnTwo) {
            Message("Correct!");
            score += 1;
        }
        else if (v.getId() == R.id.onebtnThree) {
            Message("Incorrect");
        }
        firstQuestionLayoutBinding.countNum.setText(String.valueOf(score));
        TextView countNum = findViewById(R.id.countNum);
        countNum.setText(score);
        Intent intent = new Intent(this, SecondQuestion.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }
    private void Message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

