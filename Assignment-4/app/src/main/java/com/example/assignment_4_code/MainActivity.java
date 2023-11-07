package com.example.assignment_4_code;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.assignment_4_code.databinding.MainActivityLayoutBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MainActivityLayoutBinding mainActivityLayoutBinding;

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        mainActivityLayoutBinding = MainActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(mainActivityLayoutBinding.getRoot());

        mainActivityLayoutBinding.startButton.setOnClickListener(this::onClick);  //Setting it to the begin button
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AllQuestions.class);   //When clicked I want to take the user to the AllQuestions activity(display it)
        startActivity(intent);
    }
}
