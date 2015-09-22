package com.ads.countries.view;

import com.ads.countries.model.Country;

import java.util.List;

/**
 * Created by bah on 9/21/15.
 */
public interface CountryListView {
    void updateUIData(List<Country> countryList);
    void showLoadingView();
    void hideLoadingView();
    void showNoDataView();
    void showErrorView();
    void showContentView();
}
