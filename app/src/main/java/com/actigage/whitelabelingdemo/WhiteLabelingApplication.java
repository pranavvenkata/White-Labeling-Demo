package com.actigage.whitelabelingdemo;

import android.app.Application;

import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersRepository;
import com.actigage.whitelabelingdemo.di.component.AppComponent;
import com.actigage.whitelabelingdemo.di.modules.AppModule;

import javax.inject.Inject;
import com.actigage.whitelabelingdemo.di.component.DaggerAppComponent;
/**
 * Created by Venkata Pranav on 08-02-2018.
 */

public class WhiteLabelingApplication extends Application {
    private AppComponent component;
    private static WhiteLabelingApplication app;

    public static WhiteLabelingApplication getApp() {
        return app;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        component.inject(this);
    }
    public AppComponent getComponent(){
        return component;
    }
}
