package com.actigage.whitelabelingdemo.fragments.speakers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.actigage.whitelabelingdemo.R;
import com.actigage.whitelabelingdemo.WhiteLabelingApplication;
import com.actigage.whitelabelingdemo.data.speakers.Speaker;
import com.actigage.whitelabelingdemo.di.qualifiers.ApplicationContext;

import java.util.ArrayList;

import javax.inject.Inject;

public class SpeakersFragment extends Fragment implements SpeakersContract.View {
    private RecyclerView recyclerViewSpeakers;
    @Inject
    SpeakersPresenter mSpeakersPresenter;
    @Inject
    @ApplicationContext
    Context appContext;

    ProgressBar progressSpeaker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_speakers, container, false);
        WhiteLabelingApplication.getApp().getComponent().inject(this);
        recyclerViewSpeakers = fragView.findViewById(R.id.recyclerViewSpeakers);
        progressSpeaker = fragView.findViewById(R.id.progressSpeaker);
        return fragView;
    }
    @Override
    public void onStart() {
        super.onStart();
        mSpeakersPresenter.initView(this);
    }
    @Override
    public void displayProgress(boolean display) {
        if (display)
            progressSpeaker.setVisibility(View.VISIBLE);
        else
            progressSpeaker.setVisibility(View.GONE);
    }

    @Override
    public void showSpeakersListData(ArrayList<Speaker> speakersListData) {
        recyclerViewSpeakers.setHasFixedSize(true);
        final LinearLayoutManager MyLayoutManager = new LinearLayoutManager(appContext);
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewSpeakers.setLayoutManager(MyLayoutManager);
        recyclerViewSpeakers.setAdapter(new SpeakersAdapter(this, speakersListData,mSpeakersPresenter));
    }

    @Override
    public void showDetailedSpeakers(Speaker speaker) {
        Toast.makeText(appContext, "You've Clicked on\n"+speaker.getTitle() + ", " + speaker.getDescription(), Toast.LENGTH_LONG).show();
    }
}
