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
            public void onItemClicked(MovieTVModel data) {
                showSelectedMovie(data);
            }
        });


        return rootView;
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

    // Click to detail items movie
    private void showSelectedMovie(MovieTVModel movieTVModel) {
        Toast.makeText(getActivity(), "detail to : " + movieTVModel.getTitleMovie(), Toast.LENGTH_SHORT).show();

        //data to detail
        MovieTVModel dataMovie = new MovieTVModel();
        dataMovie.setPosterMovie(movieTVModel.getPosterMovie());
        dataMovie.setTitleMovie(movieTVModel.getTitleMovie());
        dataMovie.setPhMovie(movieTVModel.getPhMovie());
        dataMovie.setRatingMovie(movieTVModel.getRatingMovie());
        dataMovie.setStorylineMovie(movieTVModel.getStorylineMovie());

        Intent detailIntent = new Intent(getContext(), DetailMovieActivity.class);
        detailIntent.putExtra(DetailMovieActivity.MOVIE_DETAIL, dataMovie);
        startActivity(detailIntent);

    }

}
