package com.actigage.whitelabelingdemo.data.speakers.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.actigage.whitelabelingdemo.data.speakers.Speaker;

import java.util.List;

/**
 * @author Venkata Pranav
 */

@Dao
public interface SpeakersDao {

    @Query("SELECT * FROM Speakers")
    List<Speaker> getSpeakers();

    @Query("SELECT * FROM Speakers WHERE entryid = :speakerId")
    Speaker getSpeakerById(String speakerId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpeaker(Speaker speaker);

}
