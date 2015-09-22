package com.ads.countries.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.ads.countries.model.Country.CountryName;

/**
 * Created by bah on 9/21/15.
 */
public class CountryModelList {
    List<Country> countryList = new ArrayList<>();

    public CountryModelList(JSONObject data) {
        JSONArray jsonArray = data.optJSONArray("countries");
        if (jsonArray != null && jsonArray.length() > 0) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject countryJson = jsonArray.optJSONObject(i);
                Log.e(getClass().getSimpleName(),countryJson.toString());
                Country country = new Country();
                country.setCountryId(countryJson.optString("country_id"));
                country.setCountryNameDefault(countryJson.optString("country_name_default"));

                CountryName countryName = country.new CountryName();
                JSONObject countryNameJson = countryJson.optJSONObject("country_name");
                countryName.setNameEnglish(countryNameJson.optString("en"));
                countryName.setNameFrench(countryNameJson.optString("fr"));
                country.setCountryName(countryName);

                country.setCapital(countryJson.optString("capital"));
                country.setCountryMapUrl(countryJson.optString("country_map_url"));
                country.setIsActive(countryJson.optBoolean("is_active"));
                countryList.add(country);

            }
        }

    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
