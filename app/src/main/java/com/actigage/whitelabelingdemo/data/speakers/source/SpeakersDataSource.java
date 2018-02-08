package com.actigage.whitelabelingdemo.data.speakers.source;

import android.support.annotation.NonNull;

import com.actigage.whitelabelingdemo.data.speakers.Speaker;

import java.util.List;

public interface SpeakersDataSource {
    interface LoadSpeakersCallback {

        void onSpeakersLoaded(List<Speaker> Speakers);

        void onDataNotAvailable();
    }

    interface GetSpeakerCallback {

        void onSpeakerLoaded(Speaker Speaker);

        void onDataNotAvailable();
    }

    void getSpeakers(@NonNull LoadSpeakersCallback callback);

    void getSpeaker(@NonNull String speakerId, @NonNull GetSpeakerCallback callback);

    void saveSpeaker(@NonNull Speaker speaker);
    void deleteAllSpeakers();
}
