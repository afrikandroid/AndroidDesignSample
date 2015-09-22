package com.ads.dagger.modules;

import com.ads.countries.interactor.CountryListInteractor;
import com.ads.countries.presenter.CountryListPresenter;
import com.ads.countries.presenter.CountryListPresenterImpl;
import com.ads.countries.view.CountryListView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bah on 9/21/15.
 */
@Module
public class CountryListModule {

    private CountryListView countryListView;

    public CountryListModule(CountryListView countryListView) {
        this.countryListView = countryListView;
    }

    @Provides
    public CountryListView provideCountryListView() {
        return countryListView;
    }

    @Provides
    public CountryListPresenter provideCountryListPresenter(CountryListView countryListView,
                                                            CountryListInteractor countryListInteractor) {
        return new CountryListPresenterImpl(countryListView, countryListInteractor);
    }
}
