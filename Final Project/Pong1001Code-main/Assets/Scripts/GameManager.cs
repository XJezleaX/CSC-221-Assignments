using System.Collections;
using System.Collections.Generic;
using TMPro;
using Unity.VisualScripting;
using Unity.VisualScripting.Antlr3.Runtime;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using UnityEngine.SocialPlatforms.Impl;

public class GameManager : MonoBehaviour
{
    private int playerScore;
    private int aiScore;
    public Ball ball;
    private int _playerLives = 100;
    private int _computerLives = 100;
    public TextMeshProUGUI ScoreDisplay1;  //Texts for changing our scores
    public TextMeshProUGUI LivesDisplay1;
    public TextMeshProUGUI ScoreDisplay2;
    public TextMeshProUGUI LivesDisplay2;
    public AudioSource AudioSource;
    public Image HP1;  //Images will show our HP bars
    public Image HP2;

    private void Start()
    {
        Destroy(GameObject.FindWithTag("Music")); 
        HP1.fillAmount = 1.0f;  //Fill to full to show full health
        HP2.fillAmount = 1.0f;
    }


    public void PlayerLives()
    {
        HP1.fillAmount -= 0.01f;  //Subtract from HP bar
        _playerLives--;         //Player 1 was scored on so subtract
        aiScore = aiScore + 1;   //Ai has scored so increment
        ScoreDisplay2.text = "Score:" + aiScore.ToString(); //Write the ai score to it's text

        if(_playerLives == 0)   
        {
            UnityEngine.SceneManagement.SceneManager.LoadScene(3); //Player 1 has lost so load gameover
        }

    }

    public void ComputerLives()
    {
        HP2.fillAmount -= 0.01f;  //Subtract from HP bar
        _computerLives--;   //Player 2/ai scored on
        playerScore = playerScore + 1;  //Player 1 scored so increment
        ScoreDisplay1.text = "Score:" + playerScore.ToString();  ///Write to text the score

        if (_computerLives == 0)
        {
            UnityEngine.SceneManagement.SceneManager.LoadScene(2); //Player 2 has lost so load game over
        }

    }
}
