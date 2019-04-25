package com.example.katsu.machinisthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.drill_chart, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.search_button:
                startDrillSearch();
                return true;
            case R.id.rpm:
                rpmSwitch(null);
                return true;
            case R.id.drillChart:
                drillSwitch(null);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ad init
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void rpmSwitch(View view){
        Intent intent = new Intent(getApplicationContext(), RPM.class);
        startActivity(intent);
    }

    public void drillSwitch(View view){
        Intent intent = new Intent(getApplicationContext(), DrillChart.class);
        startActivity(intent);
    }

    public void startDrillSearch(){
        Intent intent = new Intent (getApplicationContext(), drill_search.class);
        startActivity(intent);
    }
}
