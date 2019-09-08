package com.rdstudio.mooviesubmissiontwo;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private TypedArray dataPosterMovie;
    private String[] dataTitleMovie;
    private String[] dataPhMovie;
    private String[] dataStorylineMovie;
    private String[] dataRatingMovie;
    private ArrayList<MovieTVModel> listMovie;

    public MoviesFragment() {
        // Required empty public constructor
    }

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);


    }

    // Insert data to ArrayList that can be processed by adapter
    private void addItemsMovieTv() {
        listMovie = new ArrayList<>();

        for (int i = 0; i < dataTitleMovie.length; i++) {
            MovieTVModel movie = new MovieTVModel();
            movie.setPosterMovie(dataPosterMovie.getResourceId(i, -1));
            movie.setTitleMovie(dataTitleMovie[i]);
            movie.setPhMovie(dataPhMovie[i]);
            movie.setStorylineMovie(dataStorylineMovie[i]);
            movie.setRatingMovie(dataRatingMovie[i]);

            listMovie.add(movie);
        }

    }

    // Initiate arrayList
    private void initArrayContent() {

        dataPosterMovie = getResources().obtainTypedArray(R.array.poster_movies);
        dataTitleMovie = getResources().getStringArray(R.array.title_movies);
        dataPhMovie = getResources().getStringArray(R.array.ph_movies);
        dataStorylineMovie = getResources().getStringArray(R.array.storyline_movies);
        dataRatingMovie = getResources().getStringArray(R.array.rating_movies);

    }

}
