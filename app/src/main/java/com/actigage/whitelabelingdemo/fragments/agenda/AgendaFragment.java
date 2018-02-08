package com.actigage.whitelabelingdemo.fragments.agenda;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actigage.whitelabelingdemo.R;
import com.actigage.whitelabelingdemo.WhiteLabelingApplication;
import com.actigage.whitelabelingdemo.di.modules.AppModule;
import com.actigage.whitelabelingdemo.di.component.DaggerAppComponent;

public class AgendaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        WhiteLabelingApplication.getApp().getComponent().inject(this);
        return inflater.inflate(R.layout.fragment_agenda, container, false);
    }
}

