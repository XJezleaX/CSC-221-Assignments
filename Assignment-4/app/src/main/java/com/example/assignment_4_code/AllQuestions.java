package com.example.assignment_4_code;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AllQuestions extends AppCompatActivity{
    private TextView questionText;  //TextView that will be altered to display each question
    private TextView questionNumText; //TextView to indicate/display what question number it is
    private Button onebtnOne, onebtnTwo, onebtnThree, onebtnFour; //Setting variables that will each my button id's for clicker use
    private Questions quiz;  //The set of questions we will be using
    private int current = 0;   //Current to be the index number we are on in the question set
    private int questionNum = 0;  //Question number to be increased each time we move on to the next question
    private int score = 0;   //Total score to be tallied up as we go

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allquestions_activity_layout);

        questionText = findViewById(R.id.question);          //setting our Textviews for the question and questions numbers to be displayed
        questionNumText = findViewById(R.id.questionNum);
        onebtnOne = findViewById(R.id.onebtnOne);     //Setting our button variables equal to their respective ids for future use
        onebtnTwo = findViewById(R.id.onebtnTwo);
        onebtnThree = findViewById(R.id.onebtnThree);
        onebtnFour = findViewById(R.id.onebtnFour);


        quiz = new Questions();
        displayQuestion();

    }

    private void displayQuestion() {
        if (current < quiz.getQuestionCount()) {             //While our current index number is within the length of our set
            questionNumText.setText(quiz.getQuestionNum(questionNum));  //Displaying the question number for user
            questionText.setText(quiz.getQuestion(current));            //Displaying the question for user
            String[] choices = quiz.getAnswerChoices(current);
            onebtnOne.setText(choices[0]);      //Set button one text to first choice
            onebtnTwo.setText(choices[1]);      //Set button two text to second choice
            onebtnThree.setText(choices[2]);  //Set button three text to third choice
            onebtnFour.setText(choices[3]);     //Set button four text to fourth choice
            onebtnOne.setOnClickListener(new View.OnClickListener() {      //Creating clickers for each choice and checking if the choice matches our correct answer
                @Override
                public void onClick(View view) {
                    checkAnswer(0);
                }
            });

            onebtnTwo.setOnClickListener(new View.OnClickListener() { //Same as before but for choice 2
                @Override
                public void onClick(View view) {
                    checkAnswer(1);
                }
            });

            onebtnThree.setOnClickListener(new View.OnClickListener() {  //Same as before for choice 3
                @Override
                public void onClick(View view) {
                    checkAnswer(2);
                }
            });

            onebtnFour.setOnClickListener(new View.OnClickListener() {     //Same as before for choice 4
                @Override
                public void onClick(View view) {
                    checkAnswer(3);
                }
            });
        } else {
            onebtnOne.setVisibility(View.INVISIBLE);       //We have no more questions so make all our buttons and question number text invisible
            onebtnTwo.setVisibility(View.INVISIBLE);
            onebtnThree.setVisibility(View.INVISIBLE);
            onebtnFour.setVisibility(View.INVISIBLE);
            questionNumText.setVisibility(View.INVISIBLE);
            questionText.setText("Thank you for participating: \n\nYour score is " + score); //Display a thankyou message and the user score
        }
    }

    private void checkAnswer(int answer) {
        if (answer== quiz.getCorrectAns(current)) {    //If the button clicked matches the correct answer increment score
            score++;
            Message("Correct!");  //Display "correct" message
        } else {
            Message("Wrong answer."); //Answer does not match, don't increment and display "wrong" message
        }
        questionNum++;    //Increment our question number
        current++;        //Increment our index value to keep track of what question will be displayed
        displayQuestion();
    }

    private void Message(String message) { //Message box for our correct and wrong display
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

