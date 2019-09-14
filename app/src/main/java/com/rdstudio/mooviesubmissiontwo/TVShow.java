package com.rdstudio.mooviesubmissiontwo;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {

    private int posterTVShow;
    private String titleTVShow;
    private String phTVShow;
    private String storylineTVShow;
    private String ratingTVShow;

    public int getPosterTVShow() {
        return posterTVShow;
    }

    public void setPosterTVShow(int posterTVShow) {
        this.posterTVShow = posterTVShow;
    }

    public String getTitleTVShow() {
        return titleTVShow;
    }

    public void setTitleTVShow(String titleTVShow) {
        this.titleTVShow = titleTVShow;
    }

    public String getPhTVShow() {
        return phTVShow;
    }

    public void setPhTVShow(String phTVShow) {
        this.phTVShow = phTVShow;
    }

    public String getStorylineTVShow() {
        return storylineTVShow;
    }

    public void setStorylineTVShow(String storylineTVShow) {
        this.storylineTVShow = storylineTVShow;
    }

    public String getRatingTVShow() {
        return ratingTVShow;
    }

    public void setRatingTVShow(String ratingTVShow) {
        this.ratingTVShow = ratingTVShow;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.posterTVShow);
        dest.writeString(this.titleTVShow);
        dest.writeString(this.phTVShow);
        dest.writeString(this.storylineTVShow);
        dest.writeString(this.ratingTVShow);
    }

    public TVShow() {
    }

    protected TVShow(Parcel in) {
        this.posterTVShow = in.readInt();
        this.titleTVShow = in.readString();
        this.phTVShow = in.readString();
        this.storylineTVShow = in.readString();
        this.ratingTVShow = in.readString();
    }

    public static final Parcelable.Creator<TVShow> CREATOR = new Parcelable.Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel source) {
            return new TVShow(source);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };
}
