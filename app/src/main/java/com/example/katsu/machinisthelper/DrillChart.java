package com.example.katsu.machinisthelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;

public class DrillChart extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter sa;
    Cursor c;
    DrillSizeDB drilldb;
    SQLiteDatabase db;
    int name, imperial, metric, category;
    ToggleButton togNumber, togLetter, togFractional, togMetric;
    String groupBy, searchString;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_chart);

        Intent intent = getIntent();
        searchString = intent.getStringExtra("query");

        HashMap<String,String> item;
        togNumber = (ToggleButton)findViewById(R.id.number);
        togNumber.setOnCheckedChangeListener(this);
        togLetter = (ToggleButton)findViewById(R.id.letter);
        togLetter.setOnCheckedChangeListener(this);
        togFractional = (ToggleButton)findViewById(R.id.fractional);
        togFractional.setOnCheckedChangeListener(this);
        togMetric = (ToggleButton)findViewById(R.id.metric);
        togMetric.setOnCheckedChangeListener(this);
        groupBy = "('metric', 'number', 'fractional', 'letter')";

        try {
            drilldb = new DrillSizeDB(getBaseContext());
            db = drilldb.getReadableDatabase();
            if(searchString == null) {
                c = db.query(DrillSizeDBContract.TableColumns.TABLE_NAME, null, null, null, null, null, DrillSizeDBContract.TableColumns.IMPERIAL_SIZE + " ASC", null);
            }
            else{
                c = db.rawQuery(searchString, null);
            }
            name = c.getColumnIndex(DrillSizeDBContract.TableColumns.NAME);
            imperial = c.getColumnIndex(DrillSizeDBContract.TableColumns.IMPERIAL_SIZE);
            metric = c.getColumnIndex(DrillSizeDBContract.TableColumns.METRIC_SIZE);
            category = c.getColumnIndex(DrillSizeDBContract.TableColumns.DRILL_TYPE);
            if (c.moveToFirst()) {
                while (!c.isAfterLast()) {
                    item = new HashMap<String, String>();
                    item.put("name", c.getString(name));
                    item.put("imperial", Double.toString(c.getDouble(imperial)));
                    item.put("metric",   Double.toString(c.getDouble(metric)));
                    list.add(item);
                    Log.i("name: ", c.getString(name));
                    // debug line
                    Log.i("name: ", c.getString(name));
                    Log.i("imperial size: ", Double.toString(c.getDouble(imperial)));
                    Log.i("Metric Size: ", Double.toString(c.getDouble(metric)));
                    Log.i("category: ", c.getString(category));

                    c.moveToNext();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        sa = new SimpleAdapter(this, list,
                R.layout.drill_chart,
                new String[] {"name", "imperial", "metric"},
                new int[] {R.id.drillName, R.id.imperialSize, R.id.metricSize});
        ((ListView)findViewById(R.id.chart)).setAdapter(sa);

    }
    public void loadAllData(String s){
        HashMap<String,String> item;
        Log.i("loadData", "called it");
        list =  new ArrayList<HashMap<String,String>>();
        c = db.query(DrillSizeDBContract.TableColumns.TABLE_NAME, null, DrillSizeDBContract.TableColumns.DRILL_TYPE + " IN "+ s, null, null, null, DrillSizeDBContract.TableColumns.IMPERIAL_SIZE + " ASC", null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                item = new HashMap<String, String>();
                item.put("name", c.getString(name));
                item.put("imperial", Double.toString(c.getDouble(imperial)));
                item.put("metric",   Double.toString(c.getDouble(metric)));
                list.add(item);
                Log.i("loadData", c.getString(name));
                c.moveToNext();
            }
        }
        sa = new SimpleAdapter(this, list,
                R.layout.drill_chart,
                new String[] {"name", "imperial", "metric"},
                new int[] {R.id.drillName, R.id.imperialSize, R.id.metricSize});
        ((ListView)findViewById(R.id.chart)).setAdapter(sa);
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
        loadAllData(groupBy);
        Log.i("testing", groupBy);
    }

    public void startDrillSearch(View view){
        Intent intent = new Intent (getApplicationContext(), drill_search.class);
        startActivity(intent);
    }
}

