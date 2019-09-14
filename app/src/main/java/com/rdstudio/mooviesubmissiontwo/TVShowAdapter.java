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

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.ViewHolder> {


    public TVShowAdapter(ArrayList<TVShow> listTVShow) {
        this.listTVShow = listTVShow;
    }

    // interface onItemClickCallBack
    private TVShowAdapter.OnItemClickCallBack onItemClickCallBack;

    // constructor onItemClickCallBack
    public void setOnItemClickCallBack(TVShowAdapter.OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    private ArrayList<TVShow> listTVShow;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_tvshow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final TVShow tvShow = listTVShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPosterTVShow())
                .apply(new RequestOptions().override(110,160))
                .into(holder.imgPosterTVShow);

        holder.tvTitleTVShow.setText(tvShow.getTitleTVShow());
        holder.tvPhTVShow.setText(tvShow.getPhTVShow());
        holder.tvStorylineTVShow.setText(tvShow.getStorylineTVShow());
        holder.tvRatingTVShow.setText(tvShow.getRatingTVShow());

        holder.tvMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clicked
                onItemClickCallBack.onItemClicked(listTVShow.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listTVShow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPosterTVShow;
        TextView tvTitleTVShow, tvPhTVShow, tvStorylineTVShow, tvRatingTVShow, tvMoreInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPosterTVShow = itemView.findViewById(R.id.img_poster_tvshow);
            tvTitleTVShow = itemView.findViewById(R.id.tv_tvshow_title);
            tvPhTVShow = itemView.findViewById(R.id.tv_ph_tvshow);
            tvStorylineTVShow = itemView.findViewById(R.id.tv_tvshow_storyline);
            tvRatingTVShow = itemView.findViewById(R.id.tv_tvshow_rating);
            tvMoreInfo = itemView.findViewById(R.id.tv_more_info);

        }
    }

    // Interface parameter onClickItem
    public interface OnItemClickCallBack{
        void onItemClicked(TVShow data);
    }
}
