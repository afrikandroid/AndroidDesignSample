package com.ads.countries.presenter;

import com.ads.countries.model.Country;

/**
 * Created by bah on 9/21/15.
 */
public interface CountryListPresenter {
    void onCountryClicked(Country country);
    void fetchAndDisplayCountryList();
    void onCleanUp();
}
