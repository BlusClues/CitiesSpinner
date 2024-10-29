package com.example.citiesspinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cities = new String[]{"Select A City", "Vancouver", "Toronto", "Montreal", "Halifax", "Edmonton"};
        Spinner spinner;
        spinner = findViewById(R.id.spinner);

        //create an array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);

        //specify the dropdown layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set the adapter to the spinner
        spinner.setAdapter(adapter);


        //setting the onitemselectedlistener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (selectedItem.equals("Select A City")) {
                    Toast.makeText(MainActivity.this, "Choose a City", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, city_activity.class);

                    intent.putExtra("city_name", selectedItem);

                    //pass more info about each city
                    switch (selectedItem) {
                        case "Vancouver":
                            intent.putExtra("city_image", R.drawable.vancouver);
                            intent.putExtra("city_weather", "Rainy, 15°C");
                            intent.putExtra("city_population", "2.5 million");
                            break;
                        case "Toronto":
                            intent.putExtra("city_image", R.drawable.toronto);
                            intent.putExtra("city_weather", "Sunny, 20°C");
                            intent.putExtra("city_population", "6.2 million");
                            break;
                        case "Montreal":
                            intent.putExtra("city_image", R.drawable.montreal);
                            intent.putExtra("city_weather", "Cloudy, 12°C");
                            intent.putExtra("city_population", "1.8 million");
                            break;
                        case "Halifax":
                            intent.putExtra("city_image", R.drawable.halifax);
                            intent.putExtra("city_weather", "Foggy, 10°C");
                            intent.putExtra("city_population", "403,000");
                            break;
                        case "Edmonton":
                            intent.putExtra("city_image", R.drawable.edmonton);
                            intent.putExtra("city_weather", "Windy, 8°C");
                            intent.putExtra("city_population", "1 million");
                            break;
                        default:
                            // Set a default image or default information if needed
                            intent.putExtra("city_image", R.drawable.vancouver);
                            intent.putExtra("city_weather", "Weather information unavailable");
                            intent.putExtra("city_population", "Population data unavailable");
                            break;

                    }

                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}