package com.hard.trying.renka.cataloguemovie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.movie_item, null);
            holder.textViewMovieTitle = convertView.findViewById(R.id.tv_movie_title);
            holder.textViewMovieDesc = convertView.findViewById(R.id.tv_movie_desc);
            holder.textViewAiringDate = convertView.findViewById(R.id.tv_movie_time);
            holder.imageViewPoster = convertView.findViewById(R.id.iv_movie_poster);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

            holder.textViewMovieTitle.setText(movieData.get(position).getTitle());
            holder.textViewMovieDesc.setText(movieData.get(position).getDescription());
            holder.textViewAiringDate.setText(movieData.get(position).getreleaseDate());

            Picasso.get().load(movieData.get(position).getPosterPath()).into(holder.imageViewPoster);

        return  convertView;
    }

    private static class ViewHolder {
            TextView textViewMovieTitle;
            TextView textViewMovieDesc;
            TextView textViewAiringDate;
            ImageView imageViewPoster;
    }
}
