package com.actigage.whitelabelingdemo.data.speakers.source;

import android.support.annotation.NonNull;

import com.actigage.whitelabelingdemo.WhiteLabelingApplication;
import com.actigage.whitelabelingdemo.data.speakers.Speaker;
import com.actigage.whitelabelingdemo.di.component.DaggerAppComponent;
import com.actigage.whitelabelingdemo.di.modules.AppModule;
import com.actigage.whitelabelingdemo.di.qualifiers.Local;
import com.actigage.whitelabelingdemo.di.qualifiers.Remote;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Venkata Pranav
 */
@Singleton
public class SpeakersRepository implements SpeakersDataSource {
    private final SpeakersDataSource mSpeakersRemoteDataSource;
    private final SpeakersDataSource mSpeakersLocalDataSource;
    Map<String, Speaker> mCachedSpeakers;
    boolean mCacheIsDirty = false;
    @Inject
    SpeakersRepository(@Remote SpeakersDataSource speakersRemoteDataSource,
                       @Local SpeakersDataSource speakersLocalDataSource) {
        mSpeakersRemoteDataSource = speakersRemoteDataSource;
        mSpeakersLocalDataSource = speakersLocalDataSource;
    }
    @Override
    public void getSpeakers(@NonNull final LoadSpeakersCallback callback) {
        if (mCachedSpeakers != null && !mCacheIsDirty) {
            callback.onSpeakersLoaded(new ArrayList<>(mCachedSpeakers.values()));
            return;
        }

        if (mCacheIsDirty) {
            // If the cache is dirty we need to fetch new data from the network.
            getSpeakersFromRemoteDataSource(callback);
        } else {
            // Query the local storage if available. If not, query the network.
            mSpeakersLocalDataSource.getSpeakers(new LoadSpeakersCallback() {
                @Override
                public void onSpeakersLoaded(List<Speaker> speaker) {
                    refreshCache(speaker);
                    callback.onSpeakersLoaded(new ArrayList<>(mCachedSpeakers.values()));
                }

                @Override
                public void onDataNotAvailable() {
                    getSpeakersFromRemoteDataSource(callback);
                }
            });
        }
    }

    @Override
    public void getSpeaker(@NonNull final String speakerId,
                           @NonNull final GetSpeakerCallback callback) {
        Speaker cachedSpeaker = getSpeakerWithId(speakerId);
        if (cachedSpeaker != null) {
            callback.onSpeakerLoaded(cachedSpeaker);
            return;
        }
        mSpeakersLocalDataSource.getSpeaker(speakerId, new GetSpeakerCallback() {
            @Override
            public void onSpeakerLoaded(Speaker speaker) {
                if (mCachedSpeakers == null) {
                    mCachedSpeakers = new LinkedHashMap<>();
                }
                mCachedSpeakers.put(speaker.getId(), speaker);
                callback.onSpeakerLoaded(speaker);
            }

            @Override
            public void onDataNotAvailable() {
                mSpeakersRemoteDataSource.getSpeaker(speakerId, new GetSpeakerCallback() {
                    @Override
                    public void onSpeakerLoaded(Speaker speaker) {
                        if (mCachedSpeakers == null) {
                            mCachedSpeakers = new LinkedHashMap<>();
                        }
                        mCachedSpeakers.put(speaker.getId(), speaker);
                        callback.onSpeakerLoaded(speaker);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void saveSpeaker(@NonNull Speaker speaker) {
        mSpeakersLocalDataSource.saveSpeaker(speaker);
        mSpeakersRemoteDataSource.saveSpeaker(speaker);
        if (mCachedSpeakers == null) {
            mCachedSpeakers = new LinkedHashMap<>();
        }
        mCachedSpeakers.put(speaker.getId(), speaker);
    }

    @Override
    public void deleteAllSpeakers() {
        mSpeakersRemoteDataSource.deleteAllSpeakers();
        mSpeakersLocalDataSource.deleteAllSpeakers();
        if (mCachedSpeakers == null) {
            mCachedSpeakers = new LinkedHashMap<>();
        }
        mCachedSpeakers.clear();
    }

    private void getSpeakersFromRemoteDataSource(@NonNull final LoadSpeakersCallback callback) {
        mSpeakersRemoteDataSource.getSpeakers(new LoadSpeakersCallback() {
            @Override
            public void onSpeakersLoaded(List<Speaker> speakers) {
                refreshCache(speakers);
                refreshLocalDataSource(speakers);
                callback.onSpeakersLoaded(new ArrayList<>(mCachedSpeakers.values()));
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    private Speaker getSpeakerWithId(@NonNull String id) {
        checkNotNull(id);
        if (mCachedSpeakers == null || mCachedSpeakers.isEmpty()) {
            return null;
        } else {
            return mCachedSpeakers.get(id);
        }
    }

    private void refreshCache(List<Speaker> speakers) {
        if (mCachedSpeakers == null) {
            mCachedSpeakers = new LinkedHashMap<>();
        }
        mCachedSpeakers.clear();
        for (Speaker speaker : speakers) {
            mCachedSpeakers.put(speaker.getId(), speaker);
        }
        mCacheIsDirty = false;
    }

    private void refreshLocalDataSource(List<Speaker> speakers) {
        mSpeakersLocalDataSource.deleteAllSpeakers();
        for (Speaker speaker : speakers) {
            mSpeakersLocalDataSource.saveSpeaker(speaker);
        }
    }
}
