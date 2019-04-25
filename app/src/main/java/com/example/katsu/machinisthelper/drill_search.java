package com.example.katsu.machinisthelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.HashMap;

public class drill_search extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    EditText dimension;
    Switch imperialMetric;
    ToggleButton togNumber, togLetter, togFractional, togMetric;
    RadioButton greater, less;
    String groupBy, query;
    RadioGroup greaterLessRadio;

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
                startRPM();
                return true;
            case R.id.drillChart:
                startDrillChart();
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_search);
        ConstraintLayout background = (ConstraintLayout) findViewById(R.id.background);
        Switch ImperialMetric = (Switch) findViewById(R.id.imperialSwitch);
        background.setOnClickListener(this);

        //ad init
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        dimension = (EditText) findViewById(R.id.dimension_entry);
        imperialMetric = (Switch) findViewById(R.id.imperialSwitch);
        togNumber = (ToggleButton)findViewById(R.id.number);
        togNumber.setOnCheckedChangeListener(this);
        togLetter = (ToggleButton)findViewById(R.id.letter);
        togLetter.setOnCheckedChangeListener(this);
        togFractional = (ToggleButton)findViewById(R.id.fractional);
        togFractional.setOnCheckedChangeListener(this);
        togMetric = (ToggleButton)findViewById(R.id.metric);
        togMetric.setOnCheckedChangeListener(this);
        greater = (RadioButton) findViewById(R.id.greatBut);
        less = (RadioButton) findViewById(R.id.lessBut);
        greaterLessRadio = (RadioGroup) findViewById(R.id.greaterLessRadio);
        groupBy = "('metric', 'number', 'fractional', 'letter')";

        //check preferences to see if metric or imperial units should be used
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.katsu.machinisthelper", Context.MODE_PRIVATE);
        boolean metricMode = sharedPreferences.getBoolean("ImperialMetric", false);
        imperialMetric.setChecked(metricMode);
    }

    public void search(View view){

        double dim;
        if(RPM.isNumeric(dimension.getText().toString())) {
            dim = Double.valueOf(dimension.getText().toString());
        }
        else{
            return;
        }
        String impMet, greaterLess;

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.katsu.machinisthelper", Context.MODE_PRIVATE);
        if(imperialMetric.isChecked()){
            impMet = DrillSizeDBContract.TableColumns.METRIC_SIZE;
            sharedPreferences.edit().putBoolean("ImperialMetric", true).apply();
        }
        else{
            impMet =  DrillSizeDBContract.TableColumns.IMPERIAL_SIZE;
            sharedPreferences.edit().putBoolean("ImperialMetric", false).apply();
        }
        if(greaterLessRadio.getCheckedRadioButtonId() == -1) {
            Toast.makeText(drill_search.this, "Choose Less Than or Greater Than", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            if (less.isChecked()) {
                greaterLess = " <= ";
            } else {
                greaterLess = " >= ";
            }
        }

        //c = db.query(DrillSizeDBContract.TableColumns.TABLE_NAME, null, DrillSizeDBContract.TableColumns.IMPERIAL_SIZE + " < " + dim, null, null, null, "ABS(" + dim + " - " + DrillSizeDBContract.TableColumns.IMPERIAL_SIZE + ")", "3");
        query = "SELECT * FROM (SELECT * FROM " + DrillSizeDBContract.TableColumns.TABLE_NAME + " WHERE " + impMet + greaterLess + dim + " AND " + DrillSizeDBContract.TableColumns.DRILL_TYPE + " IN " + groupBy + " ORDER BY ABS(" + dim + " - " + impMet + ") LIMIT 3) ORDER BY " + impMet + " ASC";

        //Log.i("query", query);
        Intent intent = new Intent (getApplicationContext(), DrillChart.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) { //hides keyboard when you tap on the background, and maybe the input titles
        if(v.getId() == R.id.background) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //Log.i("testing", buttonView.getText().toString() + " " + isChecked);
        if((isChecked == false) && (groupBy.contains(buttonView.getText()))){
            //this should replace the word in groupBy, including the first and last words in the string
            groupBy = groupBy.replace(", '"+ buttonView.getText().toString() + "'", "");
            groupBy = groupBy.replace("'"+ buttonView.getText().toString() + "', ", "");
            groupBy = groupBy.replace("'"+ buttonView.getText().toString() + "'", "");
        }
        else{
            if(groupBy.equals("()")){
                groupBy = new StringBuilder(groupBy).insert(groupBy.length() - 1, "'" + buttonView.getText() + "'").toString();
            }
            else {
                groupBy = new StringBuilder(groupBy).insert(groupBy.length() - 1, ", '" + buttonView.getText() + "'").toString();
            }
        }
        //Log.i("testing", groupBy);
        changeButtonColor(buttonView, isChecked);
    }

    public void startDrillSearch(){
        Intent intent = new Intent (getApplicationContext(), drill_search.class);
        startActivity(intent);
    }

    public void startRPM(){
        Intent intent = new Intent (getApplicationContext(), RPM.class);
        startActivity(intent);
    }

    public void startDrillChart(){
        Intent intent = new Intent (getApplicationContext(), DrillChart.class);
        startActivity(intent);
    }

    public void changeButtonColor(CompoundButton buttonView, boolean isChecked){
        if(isChecked){
            //do if button is checked
            buttonView.setBackground(ContextCompat.getDrawable(this, R.drawable.button_outline_on));
            buttonView.setTextColor(ContextCompat.getColor(this, R.color.textOn));
            buttonView.setAlpha((float) 1);
        }
        else{
            buttonView.setBackground(ContextCompat.getDrawable(this, R.drawable.button_outline_off));
            buttonView.setTextColor(ContextCompat.getColor(this, R.color.textOff));
            buttonView.setAlpha((float) 0.25);
        }
    }
}
