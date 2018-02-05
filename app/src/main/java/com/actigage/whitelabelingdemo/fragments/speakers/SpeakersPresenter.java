package com.actigage.whitelabelingdemo.fragments.speakers;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public class SpeakersPresenter implements SpeakersContract.Presenter {
    private SpeakersContract.View mView;
    private SpeakersModel mModel;
    public SpeakersPresenter(SpeakersContract.View view){
        mView=view;
    }
    @Override
    public void initViews(){
        mModel = new SpeakersModel();
        mView.showSpeakersListData(mModel.getSpeakerData());
    }
    @Override
    public void onRowClick(Speaker rowData) {
        mView.showDetailedSpeakers(rowData);
    }
}
