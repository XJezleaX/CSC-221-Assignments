package com.example.assignment_4_code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import com.example.assignment_4_code.databinding.FifthQuestionLayoutBinding;

import android.widget.Toast;
public class FifthQuestion extends AppCompatActivity implements View.OnClickListener{
    FifthQuestionLayoutBinding fifthQuestionLayoutBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fifthQuestionLayoutBinding = fifthQuestionLayoutBinding.inflate(getLayoutInflater());
        setContentView(fifthQuestionLayoutBinding.getRoot());

        fifthQuestionLayoutBinding.fivebtnOne.setOnClickListener(this);
        fifthQuestionLayoutBinding.fivebtnTwo.setOnClickListener(this);
        fifthQuestionLayoutBinding.fivebtnThree.setOnClickListener(this);
        fifthQuestionLayoutBinding.fivebtnFour.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.fivebtnOne) {
            Message("Incorrect");
            //Intent intent = new Intent(this, SecondQuestion.class);
            // startActivity(intent);
        }
        else if (v.getId() == R.id.fivebtnTwo) {
            Message("Inorrect");
            //int score = Integer.parseInt(firstQuestionLayoutBinding.countNum.getText().toString());
            //firstQuestionLayoutBinding.countNum.setText("" + (score + 1));
            //Intent intent = new Intent(this, FourthQuestion.class);
            // startActivity(intent);
        }
        else if (v.getId() == R.id.fivebtnThree) {
            Message("Correct");
            //Intent intent = new Intent(this, FourthQuestion.class);
            //startActivity(intent);
        }
        else if (v.getId() == R.id.fivebtnFour) {
            Message("Incorrect");
            //Intent intent = new Intent(this, FourthQuestion.class);
            //startActivity(intent);
        }
    }

    private void Message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
