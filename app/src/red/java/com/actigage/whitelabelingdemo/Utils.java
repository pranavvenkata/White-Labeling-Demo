package com.actigage.whitelabelingdemo;


import com.actigage.whitelabelingdemo.data.speakers.Speaker;

import java.util.ArrayList;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public class Utils {
    public static ArrayList<Speaker> getSpeakerData(){
        ArrayList<Speaker> lstSpeaker = new ArrayList<>();
        lstSpeaker.add(new Speaker("Mr.Speaker Red 1","Head Human Resources Dept.\n Organization 1,\n Singapore"));
        lstSpeaker.add(new Speaker("Mr.Speaker Red 2","Chief Commercial Officer\n Organization 2,\n Singapore"));
        lstSpeaker.add(new Speaker("Mr.Speaker Red 3","General Manager\n Organization 3,\n Singapore"));
        lstSpeaker.add(new Speaker("Mr.Speaker Red 4","Project Lead\n Organization 4,\n Singapore"));
        lstSpeaker.add(new Speaker("Mr.Speaker Red 5","Head of Technology\n Organization 5,\n Singapore"));
        lstSpeaker.add(new Speaker("Mr.Speaker Red 6","Director & Co Founder\n Organization 6,\n Singapore"));
        return lstSpeaker;
    }
}
