package com.actigage.whitelabelingdemo.fragments.speakers;

import java.util.ArrayList;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public interface SpeakersContract {
    interface View{
        void showSpeakersListData(ArrayList<Speaker>speakersListData);
        void showDetailedSpeakers(Speaker speaker);
    }
    interface Model{
        ArrayList<Speaker> getSpeakerData();
    }
    interface Presenter{
        void initViews();
        void onRowClick(Speaker rowData);
    }
}
