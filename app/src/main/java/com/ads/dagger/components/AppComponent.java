package com.ads.dagger.components;

import com.ads.ADSApplication;
import com.ads.countries.interactor.CountryListInteractor;
import com.ads.dagger.modules.AppModule;
import com.ads.dagger.modules.InteractorsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bah on 9/21/15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                InteractorsModule.class
        }
)
public interface AppComponent {
    void inject(ADSApplication application);
    //declare others injectable objects here like Activities, Fragments etc.
    CountryListInteractor getCountryListInteractor();
}
