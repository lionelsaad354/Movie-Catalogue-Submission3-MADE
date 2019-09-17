package xyz.webflutter.moviecatalogue.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultMovie implements Parcelable {
    @SerializedName("title")
    private String title;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("vote_count")
    private String voteCount;
    @SerializedName("vote_average")
    private String voteAverage;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("popularity")
    private String popularity;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @SerializedName("id")
    private int id;
    @SerializedName("video")
    private boolean video;
    @SerializedName("adult")
    private boolean adult;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.originalTitle);
        dest.writeString(this.voteCount);
        dest.writeString(this.voteAverage);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.posterPath);
        dest.writeString(this.popularity);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeString(this.backdropPath);
        dest.writeList(this.genreIds);
        dest.writeInt(this.id);
        dest.writeByte(this.video ? (byte) 1 : (byte) 0);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
    }

    public ResultMovie() {
    }

    protected ResultMovie(Parcel in) {
        this.title = in.readString();
        this.originalTitle = in.readString();
        this.voteCount = in.readString();
        this.voteAverage = in.readString();
        this.originalLanguage = in.readString();
        this.posterPath = in.readString();
        this.popularity = in.readString();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.backdropPath = in.readString();
        this.genreIds = new ArrayList<Integer>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.id = in.readInt();
        this.video = in.readByte() != 0;
        this.adult = in.readByte() != 0;
    }

    public static final Parcelable.Creator<ResultMovie> CREATOR = new Parcelable.Creator<ResultMovie>() {
        @Override
        public ResultMovie createFromParcel(Parcel source) {
            return new ResultMovie(source);
        }

        @Override
        public ResultMovie[] newArray(int size) {
            return new ResultMovie[size];
        }
    };
}
