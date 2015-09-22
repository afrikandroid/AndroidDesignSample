package com.ads.countries.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ads.ADSApplication;
import com.ads.R;
import com.ads.countries.model.Country;
import com.ads.countries.presenter.CountryListPresenter;
import com.ads.dagger.components.AppComponent;
import com.ads.dagger.modules.CountryListModule;
import com.ads.dagger.components.DaggerCountryListComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bah on 9/21/15.
 */
public class CountryListFragment extends Fragment implements CountryListView {
    private static final String TAG = CountryListFragment.class.getSimpleName();

    //views
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
    @Bind(R.id.nodata_view)
    View emptyView;
    @Bind(R.id.error_view)
    View errorView;
    @Bind(R.id.progress)
    View loadingView;

    private Handler handler;
    private RecyclerView.LayoutManager layoutManager;
    private CountryListAdapter adapter;
    private List<Country> countryList = new ArrayList<>();

    @Inject
    CountryListPresenter countryListPresenter;

    public static CountryListFragment newInstance() {
        CountryListFragment fragment = new CountryListFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupComponent(ADSApplication.getInstance().getAppComponent());
        initRecyclerView();
        countryListPresenter.fetchAndDisplayCountryList();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CountryListAdapter(getActivity(), countryList);
        recyclerView.setAdapter(adapter);
    }

    private void setupComponent(AppComponent appComponent) {
        DaggerCountryListComponent.builder().appComponent(appComponent).countryListModule(new
                CountryListModule(this)).build().inject(this);
    }

    @Override
    public void updateUIData(final List<Country> countryList) {
        this.countryList = countryList;
        showContentView();
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.onBindAdapterData(countryList);
            }
        });
    }

    @Override
    public void showLoadingView() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                loadingView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void hideLoadingView() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                loadingView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void showNoDataView() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.setVisibility(View.GONE);
                errorView.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void showErrorView() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.setVisibility(View.GONE);
                emptyView.setVisibility(View.GONE);
                errorView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void showContentView() {
        if (countryList.size() == 0) {
            showNoDataView();
        } else {
            showRecyclerView();
        }
    }

    protected void showRecyclerView() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.setVisibility(View.VISIBLE);
                errorView.setVisibility(View.GONE);
                emptyView.setVisibility(View.GONE);
            }
        });
    }
}
