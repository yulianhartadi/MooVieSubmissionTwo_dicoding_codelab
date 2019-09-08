package com.rdstudio.mooviesubmissiontwo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<MovieTVModel> listMovie;

    // interface onItemClickCallBack
    private OnItemClickCallBack onItemClickCallBack;

    // constructor onItemClickCallBack
    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public MovieAdapter(ArrayList<MovieTVModel> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        MovieTVModel movie = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPosterMovie())
                .apply(new RequestOptions().override(110, 160))
                .into(holder.imgThumbMoviePoster);

        holder.tvTitleMovie.setText(movie.getTitleMovie());
        holder.tvMoviePh.setText(movie.getPhMovie());
        holder.tvMovieStoryline.setText(movie.getStorylineMovie());
        holder.tvRatingMovie.setText(movie.getRatingMovie());

        //More Info Click listener items
        holder.tvMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(listMovie.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgThumbMoviePoster;
        TextView tvTitleMovie, tvMoviePh, tvMovieStoryline, tvRatingMovie, tvMoreInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgThumbMoviePoster = itemView.findViewById(R.id.iv_poster_movie);
            tvTitleMovie = itemView.findViewById(R.id.tv_movie_title);
            tvMoviePh = itemView.findViewById(R.id.tv_ph_movie);
            tvMovieStoryline = itemView.findViewById(R.id.tv_movie_storyline);
            tvRatingMovie = itemView.findViewById(R.id.tv_movie_rating);
            tvMoreInfo = itemView.findViewById(R.id.tv_more_info);
        }
    }

    // Interface parameter onClickItem
    public interface OnItemClickCallBack{
        void onItemClicked(MovieTVModel data);
    }

}
