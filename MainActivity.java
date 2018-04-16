package com.hard.trying.renka.cataloguemovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSearch;
    ListView movieLV;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btn_Search);
        btnSearch.setOnClickListener(this);

        adapter = new MovieAdapter(this);
        adapter.notifyDataSetChanged();

        movieLV = findViewById(R.id.lv_movie);



    }

    @Override
    public void onClick(View v) {

    }
}
