package com.ads.countries.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ads.R;
import com.ads.countries.model.Country;
import com.ads.databinding.CountryListItemBinding;

/**
 * Created by bah on 9/21/15.
 */
public class CountryViewHolder extends RecyclerView.ViewHolder {

    private CountryListItemBinding binding;

    public CountryViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void onBindViewData(Country country) {
        binding.setCountry(country);
    }
}
