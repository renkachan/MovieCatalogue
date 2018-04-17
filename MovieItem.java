package com.hard.trying.renka.cataloguemovie;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Renka on 4/16/2018.
 */

public class MovieItem {
    private String title, description, releaseDate, posterPath;
    private String url = "http://image.tmdb.org/t/p/w185";

    public MovieItem(JSONObject object) {
        try {
            title = object.getString("title");
            description = object.getString("overview");
            releaseDate = object.getString("release_date");
            posterPath = object.getString("poster_path");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getreleaseDate()  {
        try {
            DateFormat formatFrom = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            formatFrom.setLenient(false);
            DateFormat expectedFormat = new SimpleDateFormat("E, MMM d, yyyy");
            expectedFormat.setLenient(false);

            Date date = formatFrom.parse(releaseDate);
            releaseDate = expectedFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return releaseDate;
    }

    public void setreleaseDate(String airingTime) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        posterPath = url + posterPath;
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
