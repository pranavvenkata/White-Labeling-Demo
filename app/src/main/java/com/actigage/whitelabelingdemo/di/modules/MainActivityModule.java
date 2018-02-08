package com.actigage.whitelabelingdemo.di.modules;

import android.app.Activity;
import android.content.Context;

import com.actigage.whitelabelingdemo.MainActivity;
import com.actigage.whitelabelingdemo.di.qualifiers.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Venkata Pranav on 08-02-2018.
 */
@Module
public class MainActivityModule {
    private MainActivity mActivity;
    public MainActivityModule(MainActivity activity) {
        mActivity = activity;
    }
    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }
    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
