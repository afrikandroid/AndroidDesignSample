package com.ads.countries.interactor;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.ads.ADSApplication;
import com.ads.R;
import com.ads.countries.model.Country;
import com.ads.countries.model.CountryModelList;
import com.ads.countries.presenter.CountryListLoadedListener;
import com.ads.util.IOUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bah on 9/21/15.
 */
public class CountryListInteractorImpl implements CountryListInteractor {
    private static final String TAG = CountryListInteractorImpl.class.getSimpleName();

    private Context context;
    private CountryListLoadedListener countryListLoadedListener;
    private AsyncTask<Void, Void, List<Country>> fetchCountriesTask;

    public CountryListInteractorImpl(Application context) {
        this.context = context;
    }

    @Override
    public void onCountryClicked(Country country) {

    }

    @Override
    public void fetchCountryList(CountryListLoadedListener listener) {
        this.countryListLoadedListener = listener;
        fetchCountriesTask = new FetchCountryListTask().execute();
    }

    @Override
    public void cancelCountryListFetch() {
        if (countryListLoadedListener != null) {
            countryListLoadedListener = null;
        }

        if (fetchCountriesTask != null) {
            fetchCountriesTask.cancel(true);
        }
    }

    private class FetchCountryListTask extends AsyncTask<Void, Void, List<Country>> {

        @Override
        protected List<Country> doInBackground(Void... params) {
            InputStream inputStream = null;
            List<Country> countryList = new ArrayList<>();
            inputStream = ADSApplication.getInstance().getResources().openRawResource(R.raw
                    .countries);
            String content = IOUtil.toString(inputStream);
            JSONObject result = null;
            try {
                result = new JSONObject(content);

                CountryModelList countryModelList = new CountryModelList(result);
                countryList = countryModelList.getCountryList();
                Log.e(TAG, "countryList size ... " + countryList.size());
            } catch (JSONException e) {
                Log.e(TAG, e.getMessage());
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e1) {
                        e1.getMessage();
                    }
                }
            }

            return countryList;
        }

        @Override
        protected void onPostExecute(List<Country> countryList) {
            countryListLoadedListener.countryListLoaded(countryList);
        }
    }
}
