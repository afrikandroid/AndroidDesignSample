package com.ads.countries.presenter;

import com.ads.countries.model.Country;

import java.util.List;

/**
 * Created by bah on 9/21/15.
 */
public interface CountryListLoadedListener {
    void countryListLoaded(List<Country> countryList);
}
