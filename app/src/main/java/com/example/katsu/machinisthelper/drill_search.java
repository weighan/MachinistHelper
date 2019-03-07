package com.example.katsu.machinisthelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_search);
        ConstraintLayout background = (ConstraintLayout) findViewById(R.id.background);
        Switch ImperialMetric = (Switch) findViewById(R.id.imperialSwitch);
        background.setOnClickListener(this);

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

        if(imperialMetric.isChecked()){
            impMet = DrillSizeDBContract.TableColumns.METRIC_SIZE;
        }
        else{
            impMet =  DrillSizeDBContract.TableColumns.IMPERIAL_SIZE;
        }
        if(greaterLessRadio.getCheckedRadioButtonId() == -1) {
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

        Log.i("query", query);
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
        Log.i("testing", buttonView.getText().toString() + " " + isChecked);
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
        Log.i("testing", groupBy);
    }

}
