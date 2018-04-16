package com.hard.trying.renka.cataloguemovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Renka on 4/16/2018.
 */

public class MovieAdapter extends BaseAdapter {
    private ArrayList<MovieItem> movieData = new ArrayList<MovieItem>();
    private LayoutInflater mLayoutInflater;
    private Context context;

    public MovieAdapter (Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        if (movieData == null) {
            return 0;
        } else {
            return movieData.size();
        }
    }

    public void setData(ArrayList<MovieItem> data) {
        movieData = data;
        notifyDataSetChanged();
    }

    public void clearData() {
        movieData.clear();
    }
    @Override
    public MovieItem getItem(int position) {
        return movieData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
