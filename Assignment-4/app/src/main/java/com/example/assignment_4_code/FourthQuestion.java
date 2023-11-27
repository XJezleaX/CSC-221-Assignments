package com.example.assignment_4_code;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.assignment_4_code.databinding.FourthQuestionLayoutBinding;

public class FourthQuestion extends AppCompatActivity implements View.OnClickListener{
    FourthQuestionLayoutBinding fourthQuestionLayoutBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fourthQuestionLayoutBinding = fourthQuestionLayoutBinding.inflate(getLayoutInflater());
        setContentView(fourthQuestionLayoutBinding.getRoot());

        fourthQuestionLayoutBinding.fourbtnOne.setOnClickListener(this);
        fourthQuestionLayoutBinding.fourbtnTwo.setOnClickListener(this);
        fourthQuestionLayoutBinding.fourbtnThree.setOnClickListener(this);
        fourthQuestionLayoutBinding.fourbtnFour.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.fourbtnOne) {
            Message("Incorrect");
        }
        else if (v.getId() == R.id.fourbtnTwo) {
            Message("Inorrect");
            //int score = Integer.parseInt(firstQuestionLayoutBinding.countNum.getText().toString());
            //firstQuestionLayoutBinding.countNum.setText("" + (score + 1));
        }
        else if (v.getId() == R.id.fourbtnThree) {
            Message("Incorrect");
        }
        else if (v.getId() == R.id.fourbtnFour) {
            Message("Correct");
        }
        Intent intent = new Intent(this, FifthQuestion.class);
        startActivity(intent);
    }

    private void Message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
