package com.actigage.whitelabelingdemo.fragments.speakers;

import com.actigage.whitelabelingdemo.data.speakers.Speaker;
import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersRepository;

import java.util.ArrayList;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public interface SpeakersContract {
    interface View{
        void displayProgress(boolean display);
        void showSpeakersListData(ArrayList<Speaker>speakersListData);
        void showDetailedSpeakers(Speaker speaker);
    }
    interface Model{
        ArrayList<Speaker> getSpeakerData(SpeakersRepository speakersRepository);
    }
    interface Presenter{
        void initView(SpeakersContract.View view);
        void onRowClick(Speaker rowData);
    }
}
