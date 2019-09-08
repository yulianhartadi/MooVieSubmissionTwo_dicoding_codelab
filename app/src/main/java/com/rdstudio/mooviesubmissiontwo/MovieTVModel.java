package com.rdstudio.mooviesubmissiontwo;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieTVModel implements Parcelable {
    private int posterMovie;
    private String titleMovie;
    private String phMovie;
    private String storylineMovie;
    private String ratingMovie;

    private int posterTVShows;
    private String titleTVShows;
    private String phTVShows;
    private String storylineTVShows;
    private String ratingTVShows;

    public int getPosterMovie() {
        return posterMovie;
    }

    public void setPosterMovie(int posterMovie) {
        this.posterMovie = posterMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getPhMovie() {
        return phMovie;
    }

    public void setPhMovie(String phMovie) {
        this.phMovie = phMovie;
    }

    public String getStorylineMovie() {
        return storylineMovie;
    }

    public void setStorylineMovie(String storylineMovie) {
        this.storylineMovie = storylineMovie;
    }

    public String getRatingMovie() {
        return ratingMovie;
    }

    public void setRatingMovie(String ratingMovie) {
        this.ratingMovie = ratingMovie;
    }

    public int getPosterTVShows() {
        return posterTVShows;
    }

    public void setPosterTVShows(int posterTVShows) {
        this.posterTVShows = posterTVShows;
    }

    public String getTitleTVShows() {
        return titleTVShows;
    }

    public void setTitleTVShows(String titleTVShows) {
        this.titleTVShows = titleTVShows;
    }

    public String getPhTVShows() {
        return phTVShows;
    }

    public void setPhTVShows(String phTVShows) {
        this.phTVShows = phTVShows;
    }

    public String getStorylineTVShows() {
        return storylineTVShows;
    }

    public void setStorylineTVShows(String storylineTVShows) {
        this.storylineTVShows = storylineTVShows;
    }

    public String getRatingTVShows() {
        return ratingTVShows;
    }

    public void setRatingTVShows(String ratingTVShows) {
        this.ratingTVShows = ratingTVShows;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.posterMovie);
        dest.writeString(this.titleMovie);
        dest.writeString(this.phMovie);
        dest.writeString(this.storylineMovie);
        dest.writeString(this.ratingMovie);
        dest.writeInt(this.posterTVShows);
        dest.writeString(this.titleTVShows);
        dest.writeString(this.phTVShows);
        dest.writeString(this.storylineTVShows);
        dest.writeString(this.ratingTVShows);
    }

    public MovieTVModel() {
    }

    protected MovieTVModel(Parcel in) {
        this.posterMovie = in.readInt();
        this.titleMovie = in.readString();
        this.phMovie = in.readString();
        this.storylineMovie = in.readString();
        this.ratingMovie = in.readString();
        this.posterTVShows = in.readInt();
        this.titleTVShows = in.readString();
        this.phTVShows = in.readString();
        this.storylineTVShows = in.readString();
        this.ratingTVShows = in.readString();
    }

    public static final Parcelable.Creator<MovieTVModel> CREATOR = new Parcelable.Creator<MovieTVModel>() {
        @Override
        public MovieTVModel createFromParcel(Parcel source) {
            return new MovieTVModel(source);
        }

        @Override
        public MovieTVModel[] newArray(int size) {
            return new MovieTVModel[size];
        }
    };
}
