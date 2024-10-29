package com.example.citiesspinner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class city_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_activity);

        // Retrieve data from the intent
        String cityName = getIntent().getStringExtra("city_name");
        int cityImage = getIntent().getIntExtra("city_image", R.drawable.edmonton); //default image
        String cityWeather = getIntent().getStringExtra("city_weather");
        String cityPopulation = getIntent().getStringExtra("city_population");

        // Set the city name, image, weather, and population
        TextView cityNameTextView = findViewById(R.id.txt_name);
        ImageView cityImageView = findViewById(R.id.img_city);
        TextView cityWeatherTextView = findViewById(R.id.txt_weather);
        TextView cityPopulationTextView = findViewById(R.id.txt_population);

        //Display the city name
        cityNameTextView.setText(cityName);
        cityImageView.setImageResource(cityImage);
        cityWeatherTextView.setText("Weather: " + cityWeather);
        cityPopulationTextView.setText("Population: " + cityPopulation);
    }
}
