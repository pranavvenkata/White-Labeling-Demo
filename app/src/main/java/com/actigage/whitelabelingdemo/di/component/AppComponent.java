package com.actigage.whitelabelingdemo.di.component;

import com.actigage.whitelabelingdemo.MainActivity;
import com.actigage.whitelabelingdemo.WhiteLabelingApplication;
import com.actigage.whitelabelingdemo.data.speakers.source.SpeakersRepository;
import com.actigage.whitelabelingdemo.di.modules.AgendaModule;
import com.actigage.whitelabelingdemo.di.modules.AppModule;
import com.actigage.whitelabelingdemo.di.modules.MainActivityModule;
import com.actigage.whitelabelingdemo.di.modules.SpeakersModule;
import com.actigage.whitelabelingdemo.fragments.agenda.AgendaFragment;
import com.actigage.whitelabelingdemo.fragments.speakers.SpeakersFragment;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {AppModule.class,
        SpeakersModule.class,
        AgendaModule.class,
        MainActivityModule.class})
public interface AppComponent {
    void inject(WhiteLabelingApplication application);
    void inject(MainActivity activity);
    void inject(SpeakersFragment speakersFragment);
    void inject(AgendaFragment agendaFragment);
}
