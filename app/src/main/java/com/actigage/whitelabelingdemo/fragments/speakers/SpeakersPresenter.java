package com.actigage.whitelabelingdemo.fragments.speakers;

import com.actigage.whitelabelingdemo.data.speakers.Speaker;
import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersDataSource;
import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public class SpeakersPresenter implements SpeakersContract.Presenter {
    private SpeakersContract.View mView;
    private SpeakersRepository mSpeakersRepository;
    public SpeakersPresenter(SpeakersRepository speakersRepository){
        mSpeakersRepository=speakersRepository;
    }
    @Override
    public void initView(SpeakersContract.View view) {
        this.mView = view;
        mView.displayProgress(true);
        mSpeakersRepository.getSpeakers(new SpeakersDataSource.LoadSpeakersCallback() {
            @Override
            public void onSpeakersLoaded(List<Speaker> speakers) {
                mView.showSpeakersListData((ArrayList<Speaker>) speakers);
                mView.displayProgress(false);
            }
            @Override
            public void onDataNotAvailable() {
                mView.displayProgress(false);
            }
        });
    }
    @Override
    public void onRowClick(Speaker rowData) {
        mView.showDetailedSpeakers(rowData);
    }
}
