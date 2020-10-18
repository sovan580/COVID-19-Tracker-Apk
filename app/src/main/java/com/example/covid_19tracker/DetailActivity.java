package com.example.covid_19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private int positionCountry;
    TextView cases,deaths,todayDeths,todayCases,critical,recovered,continent,active,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i=getIntent();
        positionCountry=i.getIntExtra("position",0);
        getSupportActionBar().setTitle("Details of "+AffectedCountries.countryListView.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        cases=findViewById(R.id.tvCases);
        deaths=findViewById(R.id.tvdeaths);
        todayCases=findViewById(R.id.tvTodayCases);
        todayDeths=findViewById(R.id.tvTodayDeaths);
        critical=findViewById(R.id.tvCritical);
        recovered=findViewById(R.id.tvRecovered);
        continent=findViewById(R.id.tvContinent);
        active=findViewById(R.id.tvActive);
        country=findViewById(R.id.countryName);
        cases.setText(AffectedCountries.countryListView.get(positionCountry).getCases());
        deaths.setText(AffectedCountries.countryListView.get(positionCountry).getDeaths());
        todayCases.setText(AffectedCountries.countryListView.get(positionCountry).getTodayCases());
        todayDeths.setText(AffectedCountries.countryListView.get(positionCountry).getTodayDeaths());
        critical.setText(AffectedCountries.countryListView.get(positionCountry).getCritical());
        recovered.setText(AffectedCountries.countryListView.get(positionCountry).getReoovered());
        continent.setText(AffectedCountries.countryListView.get(positionCountry).getContinent());
        country.setText(AffectedCountries.countryListView.get(positionCountry).getCountry());
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);

    }
}
