package com.actigage.whitelabelingdemo.data.speakers.source.remote;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.actigage.whitelabelingdemo.Utils;
import com.actigage.whitelabelingdemo.data.speakers.Speaker;
import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersDataSource;
import com.google.common.collect.Lists;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Singleton;

/**
 * Created by Venkata Pranav on 07-02-2018.
 */
@Singleton
public class SpeakersRemoteDataSource implements SpeakersDataSource {
    private static final int DELAY = 5000;

    private final static Map<String, Speaker> SPEAKERS_SERVICE_DATA;
    static {
        SPEAKERS_SERVICE_DATA = new LinkedHashMap<>(2);
        for(Speaker speaker: Utils.getSpeakerData()){
            addSpeakers(speaker.getTitle(),speaker.getDescription());
        }
    }
    public SpeakersRemoteDataSource() {}
    @Override
    public void getSpeakers(@NonNull final LoadSpeakersCallback callback) {
        // Simulate network by delaying the execution.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSpeakersLoaded(Lists.newArrayList(SPEAKERS_SERVICE_DATA.values()));
            }
        }, DELAY);
    }

    @Override
    public void getSpeaker(@NonNull String speakerId, @NonNull final GetSpeakerCallback callback) {
        final Speaker speaker = SPEAKERS_SERVICE_DATA.get(speakerId);

        // Simulate network by delaying the execution.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSpeakerLoaded(speaker);
            }
        }, DELAY);
    }

    @Override
    public void saveSpeaker(@NonNull Speaker speaker) {
        SPEAKERS_SERVICE_DATA.put(speaker.getId(), speaker);
    }
    @Override
    public void deleteAllSpeakers() {
        SPEAKERS_SERVICE_DATA.clear();
    }
    private static void addSpeakers(String title, String description) {
        Speaker newSpeaker = new Speaker(title, description);
        SPEAKERS_SERVICE_DATA.put(newSpeaker.getId(), newSpeaker);
    }
}
