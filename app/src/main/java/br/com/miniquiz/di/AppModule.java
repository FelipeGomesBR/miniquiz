package br.com.miniquiz.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import br.com.miniquiz.App;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final App application;
    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}