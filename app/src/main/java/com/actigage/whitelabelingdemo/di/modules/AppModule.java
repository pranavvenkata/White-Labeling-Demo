package com.actigage.whitelabelingdemo.di.modules;

import android.app.Activity;
import android.content.Context;

import com.actigage.whitelabelingdemo.WhiteLabelingApplication;
import com.actigage.whitelabelingdemo.di.qualifiers.ActivityContext;
import com.actigage.whitelabelingdemo.di.qualifiers.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Venkata Pranav on 08-02-2018.
 */
@Module
public class AppModule {
    private final WhiteLabelingApplication application;
    public AppModule(WhiteLabelingApplication application) {
        this.application = application;
    }
    //Application Related Dependencies Start
    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return application;
    }
    @Provides
    @Singleton
    WhiteLabelingApplication provideAppClass() {
        return application;
    }

}
