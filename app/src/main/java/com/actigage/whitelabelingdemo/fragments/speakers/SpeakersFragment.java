package com.actigage.whitelabelingdemo.fragments.speakers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actigage.whitelabelingdemo.R;

import java.util.ArrayList;


public class SpeakersFragment extends Fragment implements SpeakersContract.View{
    private RecyclerView recyclerViewSpeakers;
    private SpeakersPresenter mSpeakersPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_speakers, container, false);
        recyclerViewSpeakers =(RecyclerView)fragView.findViewById(R.id.recyclerViewSpeakers);
        mSpeakersPresenter = new SpeakersPresenter(this);
        mSpeakersPresenter.initViews();
        return fragView;
    }

    @Override
    public void showSpeakersListData(ArrayList<Speaker> speakersListData) {
        recyclerViewSpeakers.setHasFixedSize(true);
        final LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewSpeakers.setLayoutManager(MyLayoutManager);
        recyclerViewSpeakers.setAdapter(new SpeakersAdapter(this, speakersListData));
    }
    @Override
    public void showDetailedSpeakers(Speaker speaker) {
        Toast.makeText(getActivity(),speaker.getmName()+", "+speaker.getmQualification(),Toast.LENGTH_LONG).show();
    }
}
