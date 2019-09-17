package xyz.webflutter.moviecatalogue.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.webflutter.moviecatalogue.BuildConfig;
import xyz.webflutter.moviecatalogue.ItemClickSupport;
import xyz.webflutter.moviecatalogue.activities.DetailTvShowActivity;
import xyz.webflutter.moviecatalogue.R;
import xyz.webflutter.moviecatalogue.adapters.AdapterTvShow;
import xyz.webflutter.moviecatalogue.models.ModelTvShow;
import xyz.webflutter.moviecatalogue.models.ResultTvShow;
import xyz.webflutter.moviecatalogue.viewmodel.MainViewModel;

public class TvShowFragment extends Fragment {
    private RecyclerView rvTvShow;
    private ProgressBar progressBarTvShow;
    private TextView tvLoading;
    private ArrayList<ResultTvShow> listTvShow = new ArrayList<>();
    private AdapterTvShow adapterTvShow;


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTvShow = view.findViewById(R.id.rv_tv_show);
        progressBarTvShow = view.findViewById(R.id.progress_bar_tv_show);
        tvLoading = view.findViewById(R.id.tv_loading_tv_show);
        progressBarTvShow.showContextMenu();

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.initializeTvShow();
        viewModel.getTvShowModel().observe(this, new Observer<ModelTvShow>() {
            @Override
            public void onChanged(ModelTvShow modelTvShow) {
                showLoading(false);
                List<ResultTvShow> resultTvShows = modelTvShow.getResultTvShows();
                listTvShow.addAll(resultTvShows);
                adapterTvShow.notifyDataSetChanged();
            }
        });
        initRvTvShow();
        clickTvShow();
    }

    private void initRvTvShow() {
        if (adapterTvShow == null) {
            adapterTvShow = new AdapterTvShow(getActivity(), listTvShow);
            rvTvShow.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            rvTvShow.setLayoutManager(layoutManager);
            rvTvShow.setAdapter(adapterTvShow);

        } else {
            adapterTvShow.notifyDataSetChanged();
        }
    }

    private void clickTvShow() {
        ItemClickSupport.addTo(rvTvShow).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(getActivity(), DetailTvShowActivity.class);
                try {
                    ResultTvShow modelTvShow = new ResultTvShow();
                    modelTvShow.setOriginalName(listTvShow.get(position).getOriginalName());
                    modelTvShow.setOverview(listTvShow.get(position).getOverview());
                    modelTvShow.setVoteCount(listTvShow.get(position).getVoteCount());
                    modelTvShow.setVoteAverage(listTvShow.get(position).getVoteAverage());
                    modelTvShow.setOriginalLanguage(listTvShow.get(position).getOriginalLanguage());
                    modelTvShow.setFirstAirDate(listTvShow.get(position).getFirstAirDate());
                    modelTvShow.setPopularity(listTvShow.get(position).getPopularity());
                    modelTvShow.setPosterPath(BuildConfig.IMAGE + listTvShow.get(position).getPosterPath());
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, modelTvShow);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBarTvShow.setVisibility(View.VISIBLE);
        } else {
            progressBarTvShow.setVisibility(View.GONE);
            tvLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
