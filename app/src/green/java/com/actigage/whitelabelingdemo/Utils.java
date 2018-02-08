package com.actigage.whitelabelingdemo;

import com.actigage.whitelabelingdemo.data.speakers.Speaker;

import java.util.ArrayList;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public class Utils {
    public static ArrayList<Speaker> getSpeakerData(){
        ArrayList<Speaker> lstSpeaker = new ArrayList<>();
        lstSpeaker.add(new Speaker("Mr.Speaker Green 1","Chief financial officer\n Organization 1,\n USA"));
        lstSpeaker.add(new Speaker("Mr.Speaker Green 2","Head of R&D\n Organization 2,\n USA"));
        lstSpeaker.add(new Speaker("Mr.Speaker Green 3","Head of Innovations & Strategy\n Organization 3,\n USA"));
        lstSpeaker.add(new Speaker("Mr.Speaker Green 4","Chief Scientific Officer\n Organization 4,\n USA"));
        lstSpeaker.add(new Speaker("Mr.Speaker Green 5","Head of Supply Chain Management\n Organization 5,\n USA"));
        lstSpeaker.add(new Speaker("Mr.Speaker Green 6","MD\n Organization 6,\n USA"));
        return lstSpeaker;
    }
}
