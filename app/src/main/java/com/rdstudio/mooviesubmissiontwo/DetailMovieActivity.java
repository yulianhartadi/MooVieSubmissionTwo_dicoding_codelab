package com.rdstudio.mooviesubmissiontwo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailMovieActivity extends AppCompatActivity {

    public static String MOVIE_DETAIL = "movie_deail";

    ImageView imgPoster, imgHeader, imgBookmarks;
    TextView tvDetailMovieTitle, tvDetailPhMovie, tvDetailRating, tvStoryline;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        imgHeader = findViewById(R.id.img_header);
        imgPoster = findViewById(R.id.img_poster);
        tvDetailMovieTitle = findViewById(R.id.tv_detail_movie_title);
        tvDetailPhMovie = findViewById(R.id.tv_detail_ph_movie);
        tvDetailRating = findViewById(R.id.tv_detail_rating);
        tvStoryline = findViewById(R.id.tv_detail_storyline);
        imgBookmarks = findViewById(R.id.img_bookmark);

        final MovieTVModel dataMovie = getIntent().getParcelableExtra(MOVIE_DETAIL);

        // insert image header
        if (dataMovie != null) {
            Glide.with(getApplicationContext())
                    .load(dataMovie.getPosterMovie())
                    .apply(new RequestOptions().override(525, 350))
                    .into(imgHeader);
        }

        // insert image poster
        if (dataMovie != null) {
            Glide.with(getApplicationContext())
                    .load(dataMovie.getPosterMovie())
                    .apply(new RequestOptions().override(110, 160))
                    .into(imgPoster);
        }

        // title movie
        String titleMovie = null;
        if (dataMovie != null) {
            titleMovie = dataMovie.getTitleMovie();
        }
        tvDetailMovieTitle.setText(titleMovie);

        // ph movie
        String phMovie = null;
        if (dataMovie != null) {
            phMovie = dataMovie.getPhMovie();
        }
        tvDetailPhMovie.setText(phMovie);

        // rating rating
        String ratingMovie = null;
        if (dataMovie != null) {
            ratingMovie = dataMovie.getRatingMovie();
        }
        tvDetailRating.setText(ratingMovie);

        // storyline movie
        String storyMovie = null;
        if (dataMovie != null) {
            storyMovie = dataMovie.getStorylineMovie();
        }
        tvStoryline.setText(storyMovie);

        // bookmarks
        imgBookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert dataMovie != null;
                Toast.makeText(getApplicationContext(), dataMovie.getTitleMovie() + " add to favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
