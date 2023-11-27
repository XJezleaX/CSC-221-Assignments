package com.example.assignment_4_code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_4_code.databinding.ThirdQuestionLayoutBinding;
public class ThirdQuestion extends AppCompatActivity implements View.OnClickListener {
    ThirdQuestionLayoutBinding thirdQuestionLayoutBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thirdQuestionLayoutBinding = thirdQuestionLayoutBinding.inflate(getLayoutInflater());
        setContentView(thirdQuestionLayoutBinding.getRoot());

        thirdQuestionLayoutBinding.threebtnOne.setOnClickListener(this);
        thirdQuestionLayoutBinding.threebtnTwo.setOnClickListener(this);
        thirdQuestionLayoutBinding.threebtnThree.setOnClickListener(this);
        thirdQuestionLayoutBinding.threebtnFour.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.threebtnOne) {
            Message("Incorrect");
        }
        else if (v.getId() == R.id.threebtnTwo) {
            Message("Correct");
            //int score = Integer.parseInt(firstQuestionLayoutBinding.countNum.getText().toString());
            //firstQuestionLayoutBinding.countNum.setText("" + (score + 1));
        }
        else if (v.getId() == R.id.threebtnThree) {
            Message("Incorrect");
        }
        else if (v.getId() == R.id.threebtnFour) {
            Message("Incorrect");
        }
        Intent intent = new Intent(this, FourthQuestion.class);
        startActivity(intent);
    }

    private void Message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
