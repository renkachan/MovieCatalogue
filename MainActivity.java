package com.hard.trying.renka.cataloguemovie;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager
        .LoaderCallbacks<ArrayList<MovieItem>>, View.OnClickListener {
    Button btnSearch;
    EditText etMovieName;
    ListView movieLV;
    MovieAdapter adapter;
    static final String MOVIE_TO_SEARCH= "movie_search";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btn_Search);
        btnSearch.setOnClickListener(this);

        adapter = new MovieAdapter(this);
        adapter.notifyDataSetChanged();

        movieLV = findViewById(R.id.lv_movie);
        movieLV.setAdapter(adapter);

        etMovieName = findViewById(R.id.et_movie_search);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_Search) {
            String movie = etMovieName.getText().toString();
            if(TextUtils.isEmpty(movie)) {
                Toast.makeText(this, "No movie name has been given",Toast.LENGTH_LONG)
                        .show();
            } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(MOVIE_TO_SEARCH, movie);

                    getLoaderManager().restartLoader(0, bundle, MainActivity.this);

            }
        }

    }

    @Override
    public Loader<ArrayList<MovieItem>> onCreateLoader(int id, Bundle args)
    {
        if (args != null) {
            String movieToSearch = args.getString(MOVIE_TO_SEARCH);

            return new MovieAsyncLoader(this, movieToSearch);
        }

        return  null;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<MovieItem>> loader, ArrayList<MovieItem> data) {
        adapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<MovieItem>> loader) {
        adapter.setData(null);
    }
}
