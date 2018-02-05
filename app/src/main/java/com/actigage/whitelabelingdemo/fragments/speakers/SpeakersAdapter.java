package com.actigage.whitelabelingdemo.fragments.speakers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actigage.whitelabelingdemo.R;

import java.util.ArrayList;

/**
 * @author Venkata Pranav .
 */

public class SpeakersAdapter extends RecyclerView.Adapter<SpeakersAdapter.MyViewHolder> {
    private ArrayList<Speaker> speakersList;
    private SpeakersPresenter mPresenter;
    private SpeakersContract.View mView;
    public SpeakersAdapter(SpeakersContract.View view, ArrayList<Speaker> lstSpeakers) {
        this.mView = view;
        this.speakersList = lstSpeakers;
        this.mPresenter=new SpeakersPresenter(mView);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_speakers_cardview, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Speaker data = speakersList.get(position);
        holder.txtName.setText(data.getmName());
        holder.txtQualification.setText(data.getmQualification());
    }
    @Override
    public int getItemCount() {
        return speakersList != null ?speakersList.size() : 0;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtName;
        public TextView txtQualification;
        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txtName);
            txtQualification= (TextView) view.findViewById(R.id.txtQualification);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            mPresenter.onRowClick(speakersList.get(getPosition()));
        }
    }
}