package com.example.katsu.machinisthelper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class DrillChart extends AppCompatActivity {
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter sa;
    Cursor c;
    DrillSizeDB drilldb;
    SQLiteDatabase db;
    int name, imperial, metric, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_chart);
        HashMap<String,String> item;

        try {
            drilldb = new DrillSizeDB(getBaseContext());
            db = drilldb.getReadableDatabase();
            c = db.query(DrillSizeDBContract.TableColumns.TABLE_NAME, null, null, null, null, null, DrillSizeDBContract.TableColumns.IMPERIAL_SIZE + " ASC", null);
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
                    /* debug line
                    Log.i("name: ", c.getString(name));
                    Log.i("imperial size: ", Double.toString(c.getDouble(imperial)));
                    Log.i("Metric Size: ", Double.toString(c.getDouble(metric)));
                    Log.i("category: ", c.getString(category));
                    */
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
    public void loadAllData(){
        c = db.query(DrillSizeDBContract.TableColumns.TABLE_NAME, null, null, null, null, null, DrillSizeDBContract.TableColumns.IMPERIAL_SIZE + " ASC", null);
    }
}

