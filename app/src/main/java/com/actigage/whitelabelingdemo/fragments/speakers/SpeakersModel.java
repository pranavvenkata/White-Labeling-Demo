package com.actigage.whitelabelingdemo.fragments.speakers;

import com.actigage.whitelabelingdemo.Utils;

import java.util.ArrayList;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public class SpeakersModel implements SpeakersContract.Model {
    @Override
    public ArrayList<Speaker> getSpeakerData() {
        return Utils.getSpeakerData();
    }
}
