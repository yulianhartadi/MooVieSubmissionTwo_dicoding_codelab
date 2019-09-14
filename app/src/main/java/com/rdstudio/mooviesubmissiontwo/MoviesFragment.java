package com.rdstudio.mooviesubmissiontwo;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private int someStateValue;
    private final String SOME_VALUE_KEY = "someValueToSave";

    private TypedArray dataPosterMovie;
    private String[] dataTitleMovie;
    private String[] dataPhMovie;
    private String[] dataStorylineMovie;
    private String[] dataRatingMovie;
    private ArrayList<Movie> listMovie;


    public MoviesFragment() {
        // Required empty public constructor
    }

    static MoviesFragment newInstance() {
        return new MoviesFragment();
    }


    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        assert savedInstanceState != null;
        savedInstanceState.putInt(SOME_VALUE_KEY, someStateValue);
        return super.onGetLayoutInflater(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        // RecyclerView
        RecyclerView rvMovie = rootView.findViewById(R.id.rv_fragment_movie);
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovie.setHasFixedSize(true);

        initArrayContent();
        addItemsMovieTv();

        // Create & add Adapter
        MovieAdapter movieAdapter = new MovieAdapter(listMovie);
        rvMovie.setAdapter(movieAdapter);
        rvMovie.setItemAnimator(new DefaultItemAnimator());

        // onClickListener to detail movie items
        movieAdapter.setOnItemClickCallBack(new MovieAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Movie data) {
                showSelectedMovie(data);
            }
        });


        return rootView;
    }

    // Insert data to ArrayList that can be processed by adapter
    private void addItemsMovieTv() {
        listMovie = new ArrayList<>();

        for (int i = 0; i < dataTitleMovie.length; i++) {
            Movie movie = new Movie();
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

    // Click to detail items movie
    private void showSelectedMovie(Movie movie) {
        Toast.makeText(getActivity(), "detail to : " + movie.getTitleMovie(), Toast.LENGTH_SHORT).show();

        //data to detail
        Movie dataMovie = new Movie();
        dataMovie.setPosterMovie(movie.getPosterMovie());
        dataMovie.setTitleMovie(movie.getTitleMovie());
        dataMovie.setPhMovie(movie.getPhMovie());
        dataMovie.setRatingMovie(movie.getRatingMovie());
        dataMovie.setStorylineMovie(movie.getStorylineMovie());

        Intent detailIntent = new Intent(getContext(), DetailMovieActivity.class);
        detailIntent.putExtra(DetailMovieActivity.MOVIE_DETAIL, dataMovie);
        startActivity(detailIntent);

    }

}
