package com.hard.trying.renka.cataloguemovie;

import org.json.JSONObject;

/**
 * Created by Renka on 4/16/2018.
 */

public class MovieItem {
    private String title, description, releaseDate, posterPath;

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

    public String getreleaseDate() {
        return releaseDate;
    }

    public void setreleaseDate(String airingTime) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
