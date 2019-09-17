package xyz.webflutter.moviecatalogue.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultTvShow implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("original_name")
    private String originalName;
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
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("origin_country")
    private List<String> originCountry;
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.originalName);
        dest.writeString(this.voteCount);
        dest.writeString(this.voteAverage);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.posterPath);
        dest.writeString(this.popularity);
        dest.writeString(this.overview);
        dest.writeString(this.firstAirDate);
        dest.writeString(this.backdropPath);
        dest.writeStringList(this.originCountry);
        dest.writeList(this.genreIds);
        dest.writeInt(this.id);
    }

    public ResultTvShow() {
    }

    protected ResultTvShow(Parcel in) {
        this.name = in.readString();
        this.originalName = in.readString();
        this.voteCount = in.readString();
        this.voteAverage = in.readString();
        this.originalLanguage = in.readString();
        this.posterPath = in.readString();
        this.popularity = in.readString();
        this.overview = in.readString();
        this.firstAirDate = in.readString();
        this.backdropPath = in.readString();
        this.originCountry = in.createStringArrayList();
        this.genreIds = new ArrayList<Integer>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<ResultTvShow> CREATOR = new Parcelable.Creator<ResultTvShow>() {
        @Override
        public ResultTvShow createFromParcel(Parcel source) {
            return new ResultTvShow(source);
        }

        @Override
        public ResultTvShow[] newArray(int size) {
            return new ResultTvShow[size];
        }
    };
}
