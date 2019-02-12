package com.example.katsu.machinisthelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class DrillSizeDBContract {

    private DrillSizeDBContract() {}

    public static class TableColumns implements BaseColumns {
        public static final String TABLE_NAME = "DrillChartSizes";
        public static final String NAME = "name";
        public static final String IMPERIAL_SIZE = "imperial_size";
        public static final String METRIC_SIZE = "metric_size";
        public static final String DRILL_TYPE = "drill_type";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TableColumns.TABLE_NAME + " (" +
                        _ID + "INTEGER PRIMARY KEY, " +
                        NAME + " TEXT, " +
                        IMPERIAL_SIZE + " REAL, " +
                        METRIC_SIZE + " REAL, " +
                        DRILL_TYPE + " TEXT)";
        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TableColumns.TABLE_NAME;
    }
}