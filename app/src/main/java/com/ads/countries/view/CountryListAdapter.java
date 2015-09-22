package com.ads.countries.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ads.R;
import com.ads.countries.model.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bah on 9/21/15.
 */
public class CountryListAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private Context context;
    private List<Country> countryList = new ArrayList<>();

    public CountryListAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    public void onBindAdapterData(List<Country> countryList) {
        this.countryList = countryList;
        notifyDataSetChanged();
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout
                .country_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.onBindViewData(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
