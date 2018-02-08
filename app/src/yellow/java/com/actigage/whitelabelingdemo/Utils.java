package com.actigage.whitelabelingdemo;


import com.actigage.whitelabelingdemo.data.speakers.Speaker;

import java.util.ArrayList;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public class Utils {
    public static ArrayList<Speaker> getSpeakerData(){
        ArrayList<Speaker> lstSpeaker = new ArrayList<>();
        lstSpeaker.add(new Speaker("Mr.Speaker Yellow 1","Chief Data Scientist\n Organization 1,\n Mumbai,India"));
        lstSpeaker.add(new Speaker("Mr.Speaker Yellow 2","Managing Director\n Organization 2,\n Mumbai,India"));
        lstSpeaker.add(new Speaker("Mr.Speaker Yellow 3","Senior Manager\n Organization 3,\n Mumbai,India"));
        lstSpeaker.add(new Speaker("Mr.Speaker Yellow 4","Chief Technology Officer\n Organization 4,\n Mumbai,India"));
        lstSpeaker.add(new Speaker("Mr.Speaker Yellow 5","Head of Strategy\n Organization 5,\n Mumbai,India"));
        lstSpeaker.add(new Speaker("Mr.Speaker Yellow 6","Co Founder\n Organization 6,\n Mumbai,India"));
        return lstSpeaker;
    }
}
