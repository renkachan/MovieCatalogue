package com.hard.trying.renka.cataloguemovie;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Renka on 4/17/2018.
 */

public class MovieAsyncLoader extends AsyncTaskLoader<ArrayList<MovieItem>> {

    private ArrayList<MovieItem> mMovieSearchResult;
    private String movieToSearch;
    private Context context;
    boolean hasContent = false;
    private String API_KEY = "392a39a864b77a49478c82476fa520f5";

    public MovieAsyncLoader (Context context, String movieToSearch ) {
        super(context);
        onContentChanged();
        this.movieToSearch = movieToSearch;
    }

    @Override
    protected void onStartLoading() {
        if(takeContentChanged()) {
            forceLoad();
        } else if(hasContent) {
            deliverResult(mMovieSearchResult);
        }
    }

    @Override
    public void deliverResult(ArrayList<MovieItem> data) {
        mMovieSearchResult = data;
        hasContent = true;

        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();

        if (hasContent) {
            hasContent = false;
            mMovieSearchResult = null;
        }
    }

    @Override
    public ArrayList<MovieItem> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + API_KEY +
                "&language=en-US&query=" + movieToSearch;

        final ArrayList<MovieItem> movieSearchResult = new ArrayList<>();

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                setUseSynchronousMode(true);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject response = new JSONObject(result);
                    JSONArray  list = response.getJSONArray("results");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject movieObject = list.getJSONObject(i);
                        MovieItem movieItem = new MovieItem(movieObject);
                        movieSearchResult.add(movieItem);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return  movieSearchResult;
    }
}
