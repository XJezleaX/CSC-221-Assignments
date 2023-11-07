package com.example.assignment_4_code;

public class Questions {
    private String[] questionNum = {"Question 1: ", "Question 2: ", "Question 3: ", "Question 4: ", "Question 5: ", "Question 6: "};
    private String[] questions = {"Who was the Ancient Greek Goddess of the Sun?", //Set of questions I will ask
            "How many ghosts chase Pac-Man at the start of each game? ",
            "In DC's Blue Beetle, what is the name of our superhero? ",
            "What Netflix show had the most streaming views in 2021? ",
            "Which Street Fighter character wears a white outfit and a red headband? ",
            "What is the name of the fictional land where Frozen takes place?"
    };
    private String[][] answerChoices = {{"Ares", "Apollo", "Kratos", "Athena"}, //Set of answer choices for each question
            {"1", "2", "3", "4"},
            {"Carlos", "Jaime", "Peter", "Arthur"},
            {"The Witcher", "Sweet Tooth", "Maid", "Squid Games"},
            {"Akuma", "Kage", "Ryu", "Juri"},
            {"Arendelle", "Wonderland", "Angkor", "Forbidden City"}
    };

    private int[] correctAns = {1, 3, 1, 3, 2, 0}; //Index number matching my correct answer in each choice set

    public String getQuestion(int index) { //Getter and setter for everything

        return questions[index];
    }
    public void setQuestions(String[] questions) {

        this.questions = questions;
    }

    public int getCorrectAns(int index) {

        return correctAns[index];
    }

    public String getQuestionNum(int index) {
        return questionNum[index];
    }

    public void setQuestionNum(String[] questionNum) {
        this.questionNum = questionNum;
    }

    public void setCorrectAns(int[] correctAns) {

        this.correctAns = correctAns;
    }

    public int getQuestionCount() {

        return questions.length;
    }

    public String[] getAnswerChoices(int index) {

        return answerChoices[index];
    }

    public void setAnswerChoices(String[][] answerChoices) {

        this.answerChoices = answerChoices;
    }

}
