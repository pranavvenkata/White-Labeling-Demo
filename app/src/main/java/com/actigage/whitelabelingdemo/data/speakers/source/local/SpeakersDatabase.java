package com.actigage.whitelabelingdemo.data.speakers.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.actigage.whitelabelingdemo.data.speakers.Speaker;
import com.actigage.whitelabelingdemo.data.speakers.source.local.SpeakersDao;


@Database(entities = {Speaker.class}, version = 1)
public abstract class SpeakersDatabase extends RoomDatabase {
    public abstract SpeakersDao speakersDao();
}
