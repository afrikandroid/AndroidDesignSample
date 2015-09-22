package com.ads.dagger.components;

import com.ads.countries.presenter.CountryListPresenter;
import com.ads.countries.view.CountryListFragment;
import com.ads.dagger.FragmentScope;
import com.ads.dagger.modules.CountryListModule;

import dagger.Component;

/**
 * Created by bah on 9/21/15.
 */
@FragmentScope
@Component(
        dependencies = AppComponent.class,
        modules = CountryListModule.class
)
public interface CountryListComponent {
    void inject(CountryListFragment fragment);
    CountryListPresenter getCountryListPresenter();
}
