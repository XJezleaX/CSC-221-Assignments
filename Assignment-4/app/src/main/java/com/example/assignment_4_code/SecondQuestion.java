package com.example.assignment_4_code;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.assignment_4_code.databinding.FirstQuestionLayoutBinding;
import com.example.assignment_4_code.databinding.SecondQuestionLayoutBinding;
import android.widget.Toast;


public class SecondQuestion extends AppCompatActivity implements View.OnClickListener{
    SecondQuestionLayoutBinding secondQuestionLayoutBinding;
    FirstQuestionLayoutBinding firstQuestionLayoutBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondQuestionLayoutBinding = secondQuestionLayoutBinding.inflate(getLayoutInflater());
        setContentView(secondQuestionLayoutBinding.getRoot());

        secondQuestionLayoutBinding.twobtnOne.setOnClickListener(this);
        secondQuestionLayoutBinding.twobtnTwo.setOnClickListener(this);
        secondQuestionLayoutBinding.twobtnThree.setOnClickListener(this);
        secondQuestionLayoutBinding.twobtnFour.setOnClickListener(this);

    }

    public void onClick(View v) {
        int score = getIntent().getIntExtra("score", 0);
        if (v.getId() == R.id.twobtnOne) {
            Message("Incorrect");
        }
        else if (v.getId() == R.id.twobtnTwo) {
            Message("Incorrect");
            score += 1;
        }
        else if (v.getId() == R.id.twobtnThree) {
            Message("Incorrect");
        }
        else if (v.getId() == R.id.twobtnFour) {
            Message("Correct");
        }
        //secondQuestionLayoutBinding.countNum.setText(String.valueOf(score));
        Intent intent = new Intent(this, ThirdQuestion.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }

    private void Message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
