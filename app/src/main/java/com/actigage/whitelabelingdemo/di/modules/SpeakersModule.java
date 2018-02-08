package com.actigage.whitelabelingdemo.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersRepository;
import com.actigage.whitelabelingdemo.di.qualifiers.ApplicationContext;
import com.actigage.whitelabelingdemo.di.qualifiers.Local;
import com.actigage.whitelabelingdemo.di.qualifiers.Remote;
import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersDataSource;
import com.actigage.whitelabelingdemo.data.speakers.source.local.SpeakersDao;
import com.actigage.whitelabelingdemo.data.speakers.source.local.SpeakersDatabase;
import com.actigage.whitelabelingdemo.data.speakers.source.local.SpeakersLocalDataSource;
import com.actigage.whitelabelingdemo.data.speakers.source.remote.SpeakersRemoteDataSource;
import com.actigage.whitelabelingdemo.fragments.speakers.SpeakersFragment;
import com.actigage.whitelabelingdemo.fragments.speakers.SpeakersPresenter;
import com.actigage.whitelabelingdemo.util.AppExecutors;
import com.actigage.whitelabelingdemo.util.DiskIOThreadExecutor;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Venkata Pranav on 08-02-2018.
 */
@Module
public class SpeakersModule {
    private static final int THREAD_COUNT = 3;
    //Speakers Fragment Related Dependencies Start
    @Singleton
    @Provides
    @Local
    SpeakersDataSource provideSpeakersLocalDataSource(SpeakersDao dao, AppExecutors executors) {
        return new SpeakersLocalDataSource(executors, dao);
    }
    @Singleton
    @Provides
    @Remote
    SpeakersDataSource provideSpeakersRemoteDataSource() {
        return new SpeakersRemoteDataSource();
    }
    @Singleton
    @Provides
    SpeakersDatabase provideDb(@ApplicationContext  Context mContext) {
        return Room.databaseBuilder(mContext, SpeakersDatabase.class, "WhiteLabeling.db")
                .build();
    }
    @Singleton
    @Provides
    SpeakersDao provideSpeakersDao(SpeakersDatabase db) {
        return db.speakersDao();
    }
    @Singleton
    @Provides
    AppExecutors provideAppExecutors() {
        return new AppExecutors(new DiskIOThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT),
                new AppExecutors.MainThreadExecutor());
    }
    @Provides
    @Singleton
    SpeakersPresenter provideSpeakersPresenter(SpeakersRepository speakersRepository) {
        return new SpeakersPresenter(speakersRepository);
    }
    @Provides
    SpeakersFragment provideSpeakersFragment(){
        return  new SpeakersFragment();
    }
    //Speakers Fragment Related Dependencies End
}
