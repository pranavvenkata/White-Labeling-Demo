package com.actigage.whitelabelingdemo.data.speakers.source.local;

import android.support.annotation.NonNull;

import com.actigage.whitelabelingdemo.data.speakers.Speaker;
import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersDataSource;
import com.actigage.whitelabelingdemo.util.AppExecutors;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Venkata Pranav on 07-02-2018.
 */
@Singleton
public class SpeakersLocalDataSource implements SpeakersDataSource {
    private final SpeakersDao mSpeakersDao;

    private final AppExecutors mAppExecutors;

    @Inject
    public SpeakersLocalDataSource(@NonNull AppExecutors executors, @NonNull SpeakersDao speakersDao) {
        mSpeakersDao = speakersDao;
        mAppExecutors = executors;
    }
    @Override
    public void getSpeakers(@NonNull final LoadSpeakersCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Speaker> speakers = mSpeakersDao.getSpeakers();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (speakers.isEmpty()) {
                            // This will be called if the table is new or just empty.
                            callback.onDataNotAvailable();
                        } else {
                            callback.onSpeakersLoaded(speakers);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getSpeaker(@NonNull final String speakerId, @NonNull final GetSpeakerCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Speaker speaker = mSpeakersDao.getSpeakerById(speakerId);

                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (speaker != null) {
                            callback.onSpeakerLoaded(speaker);
                        } else {
                            callback.onDataNotAvailable();
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveSpeaker(@NonNull final Speaker speaker) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                mSpeakersDao.insertSpeaker(speaker);
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void deleteAllSpeakers() {

    }
}
