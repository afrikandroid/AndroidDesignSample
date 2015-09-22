package com.ads.dagger.modules;

import android.app.Application;

import com.ads.countries.interactor.CountryListInteractor;
import com.ads.countries.interactor.CountryListInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bah on 9/21/15.
 */
@Module
public class InteractorsModule {

    @Provides
    CountryListInteractor provideCountryListInteractor(Application context) {
        return new CountryListInteractorImpl(context);
    }
}
