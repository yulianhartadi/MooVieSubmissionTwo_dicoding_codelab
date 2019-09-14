package com.rdstudio.mooviesubmissiontwo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TVShowDetailActivity extends AppCompatActivity {

    public static String TVSHOW_DETAIL = "tvshow_detail";

    ImageView imgPoster, imgHeader, imgBookmarks;
    TextView tvDetailTVShowTitle, tvDetailPhTVShow, tvDetailRatingTVShow, tvStorylineTVShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailtvshow);

        imgHeader = findViewById(R.id.img_header);
        imgPoster = findViewById(R.id.img_poster);
        tvDetailTVShowTitle = findViewById(R.id.tv_detail_tvshow_title);
        tvDetailPhTVShow = findViewById(R.id.tv_detail_ph_tvshow);
        tvDetailRatingTVShow = findViewById(R.id.tv_detail_rating_tv_show);
        tvStorylineTVShow = findViewById(R.id.tv_detail_storyline_tv_show);
        imgBookmarks = findViewById(R.id.img_bookmark);

        final TVShow dataTVShow = getIntent().getParcelableExtra(TVSHOW_DETAIL);

        // insert image header
        if (dataTVShow != null) {
            Glide.with(getApplicationContext())
                    .load(dataTVShow.getPosterTVShow())
                    .apply(new RequestOptions().override(525, 350))
                    .into(imgHeader);
        }

        // insert image poster
        if (dataTVShow != null) {
            Glide.with(getApplicationContext())
                    .load(dataTVShow.getPosterTVShow())
                    .apply(new RequestOptions().override(110, 160))
                    .into(imgPoster);
        }

        // title movie
        String titleTVShow = null;
        if (dataTVShow != null) {
            titleTVShow = dataTVShow.getTitleTVShow();
        }
        tvDetailTVShowTitle.setText(titleTVShow);

        // ph movie
        String phTVShow = null;
        if (dataTVShow != null) {
            phTVShow = dataTVShow.getPhTVShow();
        }
        tvDetailPhTVShow.setText(phTVShow);

        // rating rating
        String ratingTVShow = null;
        if (dataTVShow != null) {
            ratingTVShow = dataTVShow.getRatingTVShow();
        }
        tvDetailRatingTVShow.setText(ratingTVShow);

        // storyline movie
        String storyTVShow = null;
        if (dataTVShow != null) {
            storyTVShow = dataTVShow.getStorylineTVShow();
        }
        tvStorylineTVShow.setText(storyTVShow);

        // bookmarks
        imgBookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert dataTVShow != null;
                Toast.makeText(getApplicationContext(), dataTVShow.getTitleTVShow() + " add to favorite", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
