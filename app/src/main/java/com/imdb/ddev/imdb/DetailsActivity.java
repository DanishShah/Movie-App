package com.imdb.ddev.imdb;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Danish Shah on 07-04-2017.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);          // setting a back button on your action bar

        Bundle bundle = getIntent().getExtras();
        // use bundle.getString("key");
        // use the key which we used in our previous activity

        TextView title = (TextView) findViewById(R.id.title);
        TextView release = (TextView) findViewById(R.id.release);
        TextView director = (TextView) findViewById(R.id.director);
        TextView genre = (TextView) findViewById(R.id.genre);
        TextView actor = (TextView) findViewById(R.id.actor);
        TextView language = (TextView) findViewById(R.id.language);
        TextView plot= (TextView) findViewById(R.id.plot);
        TextView rating = (TextView) findViewById(R.id.rating);

        ImageView poster = (ImageView) findViewById(R.id.poster);

        title.setText("Movie: "+bundle.getString("title"));             // recieving the data which we passed from previous activity using bundle
        release.setText("Release Date: "+bundle.getString("release"));
        director.setText("Director: "+bundle.getString("director"));
        genre.setText("Genre: "+bundle.getString("genre"));
        actor.setText("Actors: "+bundle.getString("actor"));
        language.setText("Language: "+bundle.getString("language"));
        plot.setText("Plot: "+bundle.getString("plot"));
        rating.setText("IMDB Rating: "+bundle.getString("rating"));

        //Using a library picasso for downloading the poster image into the imageview
        //Documentation of the library http://square.github.io/picasso/
        //Added INTERNET permission in the AndroidManifest for downloading the image.
        Picasso.with(this)
                .load(bundle.getString("poster"))
                .into(poster);

    }

}
