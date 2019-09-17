package xyz.webflutter.moviecatalogue.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ModelMovie {
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int total_result;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("results")
    private ArrayList<ResultMovie> resultMovies;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_result() {
        return total_result;
    }

    public void setTotal_result(int total_result) {
        this.total_result = total_result;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<ResultMovie> getResultMovies() {
        return resultMovies;
    }

    public void setResultMovies(ArrayList<ResultMovie> resultMovies) {
        this.resultMovies = resultMovies;
    }
}