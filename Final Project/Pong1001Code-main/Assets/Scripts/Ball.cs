using JetBrains.Annotations;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;

public class Ball : MonoBehaviour
{
    public float speed = 200.0f; //setting speed of our balls
    public float maxSpeed = 3.0f;  
    private Rigidbody2D _rigidbody;
    
    private void Awake()
    {
        _rigidbody = GetComponent<Rigidbody2D>();
    }

    private void Start()
    {
        AddStartingForce();
    }

    private void AddStartingForce()
    {
        float x = Random.value < 0.5f ? -1.0f : 1.0f;                  //Assign a random x coord
        float y = Random.value < 0.5f ? Random.Range(-1.0f, -0.5f) :   //Assign a radom y coord
                                        Random.Range(0.5f, 1.0f);
        Vector2 direction = new Vector2(x, y);
        _rigidbody.AddForce(direction * this.speed);  //Multiply the direction by speed
    }

    private void Update()
    {
    }
}
