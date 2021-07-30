package com.example.android.earthquake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          //create a fake list of earthquake
//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake("2.5", "Jharkhand", "5 april"));
//        earthquakes.add(new Earthquake("3.2", "Manipur", "23 march"));
//        earthquakes.add(new Earthquake("4.1", "Kerala", "29 june"));
//        earthquakes.add(new Earthquake("5.9", "Odissa", "4 dec"));
//        earthquakes.add(new Earthquake("6.8", "UP", "15 may"));
//        earthquakes.add(new Earthquake("7.3", "Agartala", "9 nov"));
//        earthquakes.add(new Earthquake("8.4", "Assam", "17 feb"));

        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        //create new adapter that takes list of earthquake as input
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);


        earthquakeListView.setAdapter(adapter);
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}