package com.ads.countries.interactor;

import com.ads.countries.model.Country;
import com.ads.countries.presenter.CountryListLoadedListener;

/**
 * Created by bah on 9/21/15.
 */
public interface CountryListInteractor {
    void onCountryClicked(Country country);
    void fetchCountryList(CountryListLoadedListener listener);
    void cancelCountryListFetch();
}
