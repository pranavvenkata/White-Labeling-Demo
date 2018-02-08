package com.actigage.whitelabelingdemo.di.modules;

import com.actigage.whitelabelingdemo.fragments.agenda.AgendaFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Venkata Pranav on 08-02-2018.
 */
@Module
public class AgendaModule {
    @Provides
    AgendaFragment provideAgendaFragment(){
        return  new AgendaFragment();
    }
}
