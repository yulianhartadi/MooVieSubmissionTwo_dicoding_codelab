package com.rdstudio.mooviesubmissiontwo;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVFragment extends Fragment {

    private ArrayList<TVShow> listTVShow;
    private TypedArray dataPosterMovie;
    private String[] dataTitleTVShow;
    private String[] dataPhTVShow;
    private String[] dataStorylineTVShow;
    private String[] dataRatingTVShow;

    public TVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tvView = inflater.inflate(R.layout.fragment_tv, container, false);

        // Recyclerview
        RecyclerView rvTvShow = tvView.findViewById(R.id.rv_fragment_tvshow);
        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTvShow.setHasFixedSize(true);

        initArrayContent();
        addItemsMovieTv();

        // Create & add Adapter
        TVShowAdapter tvShowAdapter = new TVShowAdapter(listTVShow);
        rvTvShow.setAdapter(tvShowAdapter);
        rvTvShow.setItemAnimator(new DefaultItemAnimator());

        // onClickListener to detail movie items
        tvShowAdapter.setOnItemClickCallBack(new TVShowAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(TVShow data) {
                showSelectedTVShow(data);
            }
        });

        return tvView;
    }

    // Initial Array content
    private void initArrayContent() {
        dataPosterMovie = getResources().obtainTypedArray(R.array.poster_tvshows);
        dataTitleTVShow = getResources().getStringArray(R.array.title_tvshows);
        dataPhTVShow = getResources().getStringArray(R.array.ph_tvshows);
        dataStorylineTVShow = getResources().getStringArray(R.array.storyline_tvshows);
        dataRatingTVShow = getResources().getStringArray(R.array.rating_tvshows);
    }

    // Insert data to ArrayList that can be processed by adapter
    private void addItemsMovieTv() {
        listTVShow = new ArrayList<>();
        for (int i = 0; i < dataTitleTVShow.length; i++) {
            TVShow tvShow = new TVShow();
            tvShow.setPosterTVShow(dataPosterMovie.getResourceId(i, -1));
            tvShow.setTitleTVShow(dataTitleTVShow[i]);
            tvShow.setPhTVShow(dataPhTVShow[i]);
            tvShow.setStorylineTVShow(dataStorylineTVShow[i]);
            tvShow.setRatingTVShow(dataRatingTVShow[i]);

            listTVShow.add(tvShow);
        }
    }

    // To Detail
    private void showSelectedTVShow(TVShow tvShow) {
        Toast.makeText(getActivity(), "detail to : " + tvShow.getTitleTVShow(), Toast.LENGTH_SHORT).show();

        //data to detail
        TVShow dataTVShow = new TVShow();
        dataTVShow.setPosterTVShow(tvShow.getPosterTVShow());
        dataTVShow.setTitleTVShow(tvShow.getTitleTVShow());
        dataTVShow.setPhTVShow(tvShow.getPhTVShow());
        dataTVShow.setRatingTVShow(tvShow.getRatingTVShow());
        dataTVShow.setStorylineTVShow(tvShow.getStorylineTVShow());

        Intent detailIntent = new Intent(getActivity(), TVShowDetailActivity.class);
        detailIntent.putExtra(TVShowDetailActivity.TVSHOW_DETAIL, dataTVShow);
        startActivity(detailIntent);
    }
}
