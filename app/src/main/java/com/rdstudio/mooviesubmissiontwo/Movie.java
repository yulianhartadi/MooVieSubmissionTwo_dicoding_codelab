package com.rdstudio.mooviesubmissiontwo;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int posterMovie;
    private String titleMovie;
    private String phMovie;
    private String storylineMovie;
    private String ratingMovie;

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
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.posterMovie = in.readInt();
        this.titleMovie = in.readString();
        this.phMovie = in.readString();
        this.storylineMovie = in.readString();
        this.ratingMovie = in.readString();

    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
