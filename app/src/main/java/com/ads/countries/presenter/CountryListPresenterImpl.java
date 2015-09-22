package com.ads.countries.presenter;

import com.ads.countries.interactor.CountryListInteractor;
import com.ads.countries.model.Country;
import com.ads.countries.view.CountryListView;

import java.util.List;

/**
 * Created by bah on 9/21/15.
 */
public class CountryListPresenterImpl implements CountryListPresenter, CountryListLoadedListener {

    private CountryListInteractor countryListInteractor;
    private CountryListView countryListView;

    public CountryListPresenterImpl(CountryListView countryListView,CountryListInteractor interactor) {
        this.countryListInteractor = interactor;
        this.countryListView = countryListView;
    }

    @Override
    public void onCountryClicked(Country country) {
        //TODO
    }

    @Override
    public void fetchAndDisplayCountryList() {
        showLoadingView();
        countryListInteractor.fetchCountryList(this);
    }

    @Override
    public void onCleanUp() {
        countryListInteractor.cancelCountryListFetch();
    }

    @Override
    public void countryListLoaded(List<Country> countryList) {
        hideLoadingView();
        updateUIData(countryList);
    }

    private void showLoadingView(){
        countryListView.showLoadingView();
    }

    private void hideLoadingView(){
        countryListView.hideLoadingView();
    }

    private void updateUIData(List<Country> countryList){
        countryListView.updateUIData(countryList);
    }
}
