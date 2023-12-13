using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ChangeToGame : MonoBehaviour
{
    public void Update()
    {
        if (Input.GetKey("space"))  //If space is pressed player wants to play so load screen
        {
            UnityEngine.SceneManagement.SceneManager.LoadScene(1);
        }
        if (Input.GetKey(KeyCode.C))  //If C is pressed show game controls
        {
            UnityEngine.SceneManagement.SceneManager.LoadScene(4);
        }
        if (Input.GetKey(KeyCode.Q))  //If Q is pressed close the game
        {
            Application.Quit();
        }
    }
}
