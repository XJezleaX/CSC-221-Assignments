using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.SocialPlatforms.Impl;

public class DangerZone : MonoBehaviour
{
    public EventTrigger.TriggerEvent liveTrigger;

    private void OnCollisionEnter2D(Collision2D collision)  //Detects when objects collide
    {
        Ball ball = collision.gameObject.GetComponent<Ball>();
     

        if (ball != null)  //Detects if the object colliding with it is a ball
        {
            BaseEventData eventData = new BaseEventData(EventSystem.current);
            this.liveTrigger.Invoke(eventData);

        }
    }
}
