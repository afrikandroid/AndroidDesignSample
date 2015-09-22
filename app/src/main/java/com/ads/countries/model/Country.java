package com.ads.countries.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ads.BR;

/**
 * Created by bah on 9/21/15.
 */
public class Country extends BaseObservable {

    private String countryId;
    private String countryNameDefault;
    private CountryName countryName;
    private String capital;
    private String countryMapUrl;
    private boolean isActive;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Bindable
    public String getCountryNameDefault() {
        return countryNameDefault;
    }

    public void setCountryNameDefault(String countryNameDefault) {
        this.countryNameDefault = countryNameDefault;
        notifyPropertyChanged(BR.countryNameDefault);
    }

    @Bindable
    public CountryName getCountryName() {
        return countryName;
    }

    public void setCountryName(CountryName countryName) {
        this.countryName = countryName;
        notifyPropertyChanged(BR.countryName);
    }

    @Bindable
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
        notifyPropertyChanged(BR.capital);
    }

    @Bindable
    public String getCountryMapUrl() {
        return countryMapUrl;
    }

    public void setCountryMapUrl(String countryMapUrl) {
        this.countryMapUrl = countryMapUrl;
        notifyPropertyChanged(BR.countryMapUrl);
    }

    @Bindable
    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        notifyPropertyChanged(BR.active);
    }

    public class CountryName extends BaseObservable {
        private String nameEnglish;
        private String nameFrench;

        public CountryName() {
        }

        @Bindable
        public String getNameEnglish() {
            return nameEnglish;
        }

        public void setNameEnglish(String nameEnglish) {
            this.nameEnglish = nameEnglish;
            notifyPropertyChanged(BR.nameEnglish);
        }

        @Bindable
        public String getNameFrench() {
            return nameFrench;
        }

        public void setNameFrench(String nameFrench) {
            this.nameFrench = nameFrench;
            notifyPropertyChanged(BR.nameFrench);
        }
    }
}
