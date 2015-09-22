package com.ads.dagger.modules;

import android.app.Application;

import com.ads.ADSApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bah on 9/21/15.
 */
@Module
public class AppModule {

    private ADSApplication app;

    public AppModule(ADSApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }
}
