package com.ads;

import android.app.Application;

import com.ads.dagger.components.AppComponent;
import com.ads.dagger.components.DaggerAppComponent;
import com.ads.dagger.modules.AppModule;

/**
 * Created by bah on 9/21/15.
 */
public class ADSApplication extends Application {
    private static ADSApplication INSTANCE;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        setupGraph();
    }

    private void setupGraph() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public static ADSApplication getInstance() {
        return INSTANCE;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
