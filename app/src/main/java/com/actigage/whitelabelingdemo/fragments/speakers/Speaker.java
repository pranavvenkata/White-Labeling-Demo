package com.actigage.whitelabelingdemo.fragments.speakers;

/**
 * Created by Venkata Pranav on 05-02-2018.
 */

public class Speaker {
    private String mName;
    private String mQualification;

    public Speaker(String mName, String mQualification) {
        this.mName = mName;
        this.mQualification = mQualification;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getmQualification() {
        return mQualification;
    }
    public void setmQualification(String mQualification) {
        this.mQualification = mQualification;
    }
}
