package com.actigage.whitelabelingdemo.fragments.speakers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actigage.whitelabelingdemo.R;
import com.actigage.whitelabelingdemo.data.speakers.Speaker;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * @author Venkata Pranav .
 */

public class SpeakersAdapter extends RecyclerView.Adapter<SpeakersAdapter.SpeakersViewHolder> {
    private ArrayList<Speaker> speakersList;
    SpeakersPresenter mPresenter;
    private SpeakersContract.View mView;
    public SpeakersAdapter(SpeakersContract.View view, ArrayList<Speaker> lstSpeakers,
                           SpeakersPresenter presenter) {
        this.mView = view;
        this.speakersList = lstSpeakers;
        mPresenter = presenter;
    }
    @Override
    public SpeakersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_speakers_cardview, parent, false);

        return new SpeakersViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final SpeakersViewHolder holder, int position) {
        Speaker data = speakersList.get(position);
        holder.txtName.setText(data.getTitle());
        holder.txtDesignation.setText(data.getDescription());
    }
    @Override
    public int getItemCount() {
        return speakersList != null ?speakersList.size() : 0;
    }
    public class SpeakersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName;
        TextView txtDesignation;
        SpeakersViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txtName);
            txtDesignation = (TextView) view.findViewById(R.id.txtDesignation);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            mPresenter.onRowClick(speakersList.get(getPosition()));
        }
    }
}