using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallDup : MonoBehaviour
{
    public GameObject copy;
    public float spawn = 30;
    public float time = 0;
    void Start()
    {
        Instantiate(copy, transform.position, transform.rotation);
    }

    void Update()
    {
        if (time > spawn)
        {
            Instantiate(copy, transform.position, transform.rotation);
            time = 0;
        }
        else if (time < spawn)
        {
            time = time + Time.deltaTime;
        }

    }
}
