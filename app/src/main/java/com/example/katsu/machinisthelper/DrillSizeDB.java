package com.example.katsu.machinisthelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DrillSizeDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DrillChart.db";

    public DrillSizeDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(DrillSizeDBContract.TableColumns.SQL_CREATE_ENTRIES);
        addEntry(db, "#107", 0.0019, 0.0483, "number");
        addEntry(db, "#106", 0.0023, 0.0584, "number");
        addEntry(db, "#105", 0.0027, 0.0686, "number");
        addEntry(db, "#104", 0.0031, 0.079, "number");
        addEntry(db, "#103", 0.0035, 0.089, "number");
        addEntry(db, "#102", 0.0039, 0.099, "number");
        addEntry(db, "#101", 0.0043, 0.109, "number");
        addEntry(db, "#100", 0.0047, 0.119, "number");
        addEntry(db, "#99", 0.0051, 0.130, "number");
        addEntry(db, "#98", 0.0055, 0.140, "number");
        addEntry(db, "#97", 0.0059, 0.150, "number");
        addEntry(db, "#96", 0.0063, 0.160, "number");
        addEntry(db, "#95", 0.0067, 0.170, "number");
        addEntry(db, "#94", 0.0071, 0.180, "number");
        addEntry(db, "#93", 0.0075, 0.191, "number");
        addEntry(db, "#92", 0.0079, 0.201, "number");
        addEntry(db, "#91", 0.0083, 0.211, "number");
        addEntry(db, "#90", 0.0087, 0.221, "number");
        addEntry(db, "#89", 0.0091, 0.231, "number");
        addEntry(db, "#88", 0.0095, 0.241, "number");
        addEntry(db, "#87", 0.010, 0.254, "number");
        addEntry(db, "#86", 0.0105, 0.267, "number");
        addEntry(db, "#85", 0.011, 0.279, "number");
        addEntry(db, "#84", 0.0115, 0.292, "number");
        addEntry(db, "#83", 0.012, 0.305, "number");
        addEntry(db, "#82", 0.0125, 0.318, "number");
        addEntry(db, "#81", 0.013, 0.330, "number");
        addEntry(db, "#80", 0.0135, 0.343, "number");
        addEntry(db, "#79", 0.0145, 0.368, "number");
        addEntry(db, "#78", 0.016, 0.406, "number");
        addEntry(db, "#77", 0.018, 0.457, "number");
        addEntry(db, "#76", 0.020, 0.508, "number");
        addEntry(db, "#75", 0.021, 0.533, "number");
        addEntry(db, "#74", 0.0225, 0.572, "number");
        addEntry(db, "#73", 0.024, 0.610, "number");
        addEntry(db, "#72", 0.025, 0.635, "number");
        addEntry(db, "#71", 0.026, 0.660, "number");
        addEntry(db, "#70", 0.028, 0.711, "number");
        addEntry(db, "#69", 0.0292, 0.742, "number");
        addEntry(db, "#68", 0.031, 0.787, "number");
        addEntry(db, "#67", 0.032, 0.813, "number");
        addEntry(db, "#66", 0.033, 0.838, "number");
        addEntry(db, "#65", 0.035, 0.889, "number");
        addEntry(db, "#64", 0.036, 0.914, "number");
        addEntry(db, "#63", 0.037, 0.940, "number");
        addEntry(db, "#62", 0.038, 0.965, "number");
        addEntry(db, "#61", 0.039, 0.991, "number");
        addEntry(db, "#60", 0.040, 1.016, "number");
        addEntry(db, "#59", 0.041, 1.041, "number");
        addEntry(db, "#58", 0.042, 1.067, "number");
        addEntry(db, "#57", 0.043, 1.092, "number");
        addEntry(db, "#56", 0.0465, 1.181, "number");
        addEntry(db, "#55", 0.052, 1.321, "number");
        addEntry(db, "#54", 0.055, 1.397, "number");
        addEntry(db, "#53", 0.0595, 1.511, "number");
        addEntry(db, "#52", 0.0635, 1.613, "number");
        addEntry(db, "#51", 0.067, 1.702, "number");
        addEntry(db, "#50", 0.070, 1.778, "number");
        addEntry(db, "#49", 0.073, 1.854, "number");
        addEntry(db, "#48", 0.076, 1.930, "number");
        addEntry(db, "#47", 0.0785, 1.994, "number");
        addEntry(db, "#46", 0.081, 2.057, "number");
        addEntry(db, "#45", 0.082, 2.083, "number");
        addEntry(db, "#44", 0.086, 2.184, "number");
        addEntry(db, "#43", 0.089, 2.261, "number");
        addEntry(db, "#42", 0.0935, 2.375, "number");
        addEntry(db, "#41", 0.096, 2.438, "number");
        addEntry(db, "#40", 0.098, 2.489, "number");
        addEntry(db, "#39", 0.0995, 2.527, "number");
        addEntry(db, "#38", 0.1015, 2.578, "number");
        addEntry(db, "#37", 0.104, 2.642, "number");
        addEntry(db, "#36", 0.1065, 2.705, "number");
        addEntry(db, "#35", 0.110, 2.794, "number");
        addEntry(db, "#34", 0.111, 2.819, "number");
        addEntry(db, "#33", 0.113, 2.870, "number");
        addEntry(db, "#32", 0.116, 2.946, "number");
        addEntry(db, "#31", 0.120, 3.048, "number");
        addEntry(db, "#30", 0.1285, 3.264, "number");
        addEntry(db, "#29", 0.136, 3.454, "number");
        addEntry(db, "#28", 0.1405, 3.569, "number");
        addEntry(db, "#27", 0.144, 3.658, "number");
        addEntry(db, "#26", 0.147, 3.734, "number");
        addEntry(db, "#25", 0.1495, 3.797, "number");
        addEntry(db, "#24", 0.152, 3.861, "number");
        addEntry(db, "#23", 0.154, 3.912, "number");
        addEntry(db, "#22", 0.157, 3.988, "number");
        addEntry(db, "#21", 0.159, 4.039, "number");
        addEntry(db, "#20", 0.161, 4.089, "number");
        addEntry(db, "#19", 0.166, 4.216, "number");
        addEntry(db, "#18", 0.1695, 4.305, "number");
        addEntry(db, "#17", 0.173, 4.394, "number");
        addEntry(db, "#16", 0.177, 4.496, "number");
        addEntry(db, "#15", 0.180, 4.572, "number");
        addEntry(db, "#14", 0.182, 4.623, "number");
        addEntry(db, "#13", 0.185, 4.699, "number");
        addEntry(db, "#12", 0.189, 4.801, "number");
        addEntry(db, "#11", 0.191, 4.851, "number");
        addEntry(db, "#10", 0.1935, 4.915, "number");
        addEntry(db, "#9", 0.196, 4.978, "number");
        addEntry(db, "#8", 0.199, 5.055, "number");
        addEntry(db, "#7", 0.201, 5.105, "number");
        addEntry(db, "#6", 0.204, 5.182, "number");
        addEntry(db, "#5", 0.2055, 5.220, "number");
        addEntry(db, "#4", 0.209, 5.309, "number");
        addEntry(db, "#3", 0.213, 5.410, "number");
        addEntry(db, "#2", 0.221, 5.613, "number");
        addEntry(db, "#1", 0.228, 5.791, "number");
        addEntry(db, "A", 0.234, 5.944, "letter");
        addEntry(db, "B", 0.238, 6.045, "letter");
        addEntry(db, "C", 0.242, 6.147, "letter");
        addEntry(db, "D", 0.246, 6.248, "letter");
        addEntry(db, "E", 0.250, 6.350, "letter");
        addEntry(db, "F", 0.257, 6.528, "letter");
        addEntry(db, "G", 0.261, 6.629, "letter");
        addEntry(db, "H", 0.266, 6.756, "letter");
        addEntry(db, "I", 0.272, 6.909, "letter");
        addEntry(db, "J", 0.277, 7.036, "letter");
        addEntry(db, "K", 0.281, 7.137, "letter");
        addEntry(db, "L", 0.290, 7.366, "letter");
        addEntry(db, "M", 0.295, 7.493, "letter");
        addEntry(db, "N", 0.302, 7.671, "letter");
        addEntry(db, "O", 0.316, 8.026, "letter");
        addEntry(db, "P", 0.323, 8.204, "letter");
        addEntry(db, "Q", 0.332, 8.433, "letter");
        addEntry(db, "R", 0.339, 8.611, "letter");
        addEntry(db, "S", 0.348, 8.839, "letter");
        addEntry(db, "T", 0.358, 9.093, "letter");
        addEntry(db, "U", 0.368, 9.347, "letter");
        addEntry(db, "V", 0.377, 9.576, "letter");
        addEntry(db, "W", 0.386, 9.804, "letter");
        addEntry(db, "X", 0.397, 10.08, "letter");
        addEntry(db, "Y", 0.404, 10.26, "letter");
        addEntry(db, "Z", 0.413, 10.49, "letter");
        addEntry(db, "1⁄64 in", 0.01563, 0.3969, "fractional");
        addEntry(db, "1⁄32 in", 0.03125, 0.7938, "fractional");
        addEntry(db, "3⁄64 in", 0.04688, 1.1906, "fractional");
        addEntry(db, "1⁄16 in", 0.06250, 1.5875, "fractional");
        addEntry(db, "5⁄64 in", 0.07813, 1.9844, "fractional");
        addEntry(db, "3⁄32 in", 0.09375, 2.3813, "fractional");
        addEntry(db, "7⁄64 in", 0.10938, 2.7781, "fractional");
        addEntry(db, "1⁄8 in", 0.12500, 3.1750, "fractional");
        addEntry(db, "9⁄64 in", 0.14063, 3.5719, "fractional");
        addEntry(db, "5⁄32 in", 0.15625, 3.9688, "fractional");
        addEntry(db, "11⁄64 in", 0.17188, 4.3656, "fractional");
        addEntry(db, "3⁄16 in", 0.18750, 4.7625, "fractional");
        addEntry(db, "13⁄64 in", 0.20313, 5.1594, "fractional");
        addEntry(db, "7⁄32 in", 0.21875, 5.5563, "fractional");
        addEntry(db, "15⁄64 in", 0.23438, 5.9531, "fractional");
        addEntry(db, "1⁄4 in", 0.25000, 6.3500, "fractional");
        addEntry(db, "17⁄64 in", 0.26563, 6.7469, "fractional");
        addEntry(db, "9⁄32 in", 0.28125, 7.1438, "fractional");
        addEntry(db, "19⁄64 in", 0.29688, 7.5406, "fractional");
        addEntry(db, "5⁄16 in", 0.31250, 7.9375, "fractional");
        addEntry(db, "21⁄64 in", 0.32813, 8.3344, "fractional");
        addEntry(db, "11⁄32 in", 0.34375, 8.7313, "fractional");
        addEntry(db, "23⁄64 in", 0.35938, 9.1281, "fractional");
        addEntry(db, "3⁄8 in", 0.37500, 9.5250, "fractional");
        addEntry(db, "25⁄64 in", 0.39063, 9.9219, "fractional");
        addEntry(db, "13⁄32 in", 0.40625, 10.3188, "fractional");
        addEntry(db, "27⁄64 in", 0.42188, 10.7156, "fractional");
        addEntry(db, "7⁄16 in", 0.43750, 11.1125, "fractional");
        addEntry(db, "29⁄64 in", 0.45313, 11.5094, "fractional");
        addEntry(db, "15⁄32 in", 0.46875, 11.9063, "fractional");
        addEntry(db, "31⁄64 in", 0.48438, 12.3031, "fractional");
        addEntry(db, "1⁄2 in", 0.50000, 12.7000, "fractional");
        addEntry(db, "33⁄64 in", 0.51563, 13.0969, "fractional");
        addEntry(db, "17⁄32 in", 0.53125, 13.4938, "fractional");
        addEntry(db, "35⁄64 in", 0.54688, 13.8906, "fractional");
        addEntry(db, "9⁄16 in", 0.56250, 14.2875, "fractional");
        addEntry(db, "37⁄64 in", 0.57813, 14.6844, "fractional");
        addEntry(db, "19⁄32 in", 0.59375, 15.0813, "fractional");
        addEntry(db, "39⁄64 in", 0.60938, 15.4781, "fractional");
        addEntry(db, "5⁄8 in", 0.62500, 15.8750, "fractional");
        addEntry(db, "41⁄64 in", 0.64063, 16.2719, "fractional");
        addEntry(db, "21⁄32 in", 0.65625, 16.6688, "fractional");
        addEntry(db, "43⁄64 in", 0.67188, 17.0656, "fractional");
        addEntry(db, "11⁄16 in", 0.68750, 17.4625, "fractional");
        addEntry(db, "45⁄64 in", 0.70313, 17.8594, "fractional");
        addEntry(db, "23⁄32 in", 0.71875, 18.2563, "fractional");
        addEntry(db, "47⁄64 in", 0.73438, 18.6531, "fractional");
        addEntry(db, "3⁄4 in", 0.75000, 19.0500, "fractional");
        addEntry(db, "49⁄64 in", 0.76563, 19.4469, "fractional");
        addEntry(db, "25⁄32 in", 0.78125, 19.8438, "fractional");
        addEntry(db, "51⁄64 in", 0.79688, 20.2406, "fractional");
        addEntry(db, "13⁄16 in", 0.81250, 20.6375, "fractional");
        addEntry(db, "53⁄64 in", 0.82813, 21.0344, "fractional");
        addEntry(db, "27⁄32 in", 0.84375, 21.4313, "fractional");
        addEntry(db, "55⁄64 in", 0.85938, 21.8281, "fractional");
        addEntry(db, "7⁄8 in", 0.87500, 22.2250, "fractional");
        addEntry(db, "57⁄64 in", 0.89063, 22.6219, "fractional");
        addEntry(db, "29⁄32 in", 0.90625, 23.0188, "fractional");
        addEntry(db, "59⁄64 in", 0.92188, 23.4156, "fractional");
        addEntry(db, "15⁄16 in", 0.93750, 23.8125, "fractional");
        addEntry(db, "61⁄64 in", 0.95313, 24.2094, "fractional");
        addEntry(db, "31⁄32 in", 0.96875, 24.6063, "fractional");
        addEntry(db, "63⁄64 in", 0.98438, 25.0031, "fractional");
        addEntry(db, "1 in", 1.00000, 25.4000, "fractional");
        addEntry(db, "1 1⁄64 in", 1.01563, 25.7969, "fractional");
        addEntry(db, "1 1⁄32 in", 1.03125, 26.1938, "fractional");
        addEntry(db, "1 3⁄64 in", 1.04688, 26.5906, "fractional");
        addEntry(db, "1 1⁄16 in", 1.06250, 26.9875, "fractional");
        addEntry(db, "1 7⁄64 in", 1.10938, 28.1781, "fractional");
        addEntry(db, "1 1⁄8 in", 1.12500, 28.5750, "fractional");
        addEntry(db, "1 5⁄32 in", 1.15625, 29.3688, "fractional");
        addEntry(db, "1 11⁄64 in", 1.17188, 29.7656, "fractional");
        addEntry(db, "1 3⁄16 in", 1.18750, 30.1625, "fractional");
        addEntry(db, "1 13⁄64 in", 1.20313, 30.5594, "fractional");
        addEntry(db, "1 7⁄32 in", 1.21875, 30.9563, "fractional");
        addEntry(db, "1 15⁄64 in", 1.23438, 31.3531, "fractional");
        addEntry(db, "1 9⁄32 in", 1.28125, 32.5438, "fractional");
        addEntry(db, "1 19⁄64 in", 1.29688, 32.9406, "fractional");
        addEntry(db, "1 5⁄16 in", 1.31250, 33.3375, "fractional");
        addEntry(db, "1 21⁄64 in", 1.32813, 33.7344, "fractional");
        addEntry(db, "1 11⁄32 in", 1.34375, 34.1313, "fractional");
        addEntry(db, "1 23⁄64 in", 1.35938, 34.5281, "fractional");
        addEntry(db, "1 13⁄32 in", 1.40625, 35.7188, "fractional");
        addEntry(db, "1 27⁄64 in", 1.42188, 36.1156, "fractional");
        addEntry(db, "0.05 mm", 0.00197, 0.0500, "metric");
        addEntry(db, "0.1 mm", 0.00394, 0.1000, "metric");
        addEntry(db, "0.2 mm", 0.00787, 0.2000, "metric");
        addEntry(db, "0.25 mm", 0.00984, 0.2500, "metric");
        addEntry(db, "0.3 mm", 0.01181, 0.3000, "metric");
        addEntry(db, "0.35 mm", 0.01378, 0.3500, "metric");
        addEntry(db, "0.4 mm", 0.01575, 0.4000, "metric");
        addEntry(db, "0.42 mm", 0.01654, 0.4200, "metric");
        addEntry(db, "0.45 mm", 0.01772, 0.4500, "metric");
        addEntry(db, "0.48 mm", 0.01890, 0.4800, "metric");
        addEntry(db, "0.5 mm", 0.01969, 0.5000, "metric");
        addEntry(db, "0.55 mm", 0.02165, 0.5500, "metric");
        addEntry(db, "0.6 mm", 0.02362, 0.6000, "metric");
        addEntry(db, "0.65 mm", 0.02559, 0.6500, "metric");
        addEntry(db, "0.7 mm", 0.02756, 0.7000, "metric");
        addEntry(db, "0.75 mm", 0.02953, 0.7500, "metric");
        addEntry(db, "0.8 mm", 0.03150, 0.8000, "metric");
        addEntry(db, "0.85 mm", 0.03346, 0.8500, "metric");
        addEntry(db, "0.9 mm", 0.03543, 0.9000, "metric");
        addEntry(db, "0.95 mm", 0.03740, 0.9500, "metric");
        addEntry(db, "1 mm", 0.03937, 1.0000, "metric");
        addEntry(db, "1.05 mm", 0.04134, 1.0500, "metric");
        addEntry(db, "1.1 mm", 0.04331, 1.1000, "metric");
        addEntry(db, "1.15 mm", 0.04528, 1.1500, "metric");
        addEntry(db, "1.2 mm", 0.04724, 1.2000, "metric");
        addEntry(db, "1.25 mm", 0.04921, 1.2500, "metric");
        addEntry(db, "1.3 mm", 0.05118, 1.3000, "metric");
        addEntry(db, "1.35 mm", 0.05315, 1.3500, "metric");
        addEntry(db, "1.4 mm", 0.05512, 1.4000, "metric");
        addEntry(db, "1.45 mm", 0.05709, 1.4500, "metric");
        addEntry(db, "1.5 mm", 0.05906, 1.5000, "metric");
        addEntry(db, "1.55 mm", 0.06102, 1.5500, "metric");
        addEntry(db, "1.6 mm", 0.06299, 1.6000, "metric");
        addEntry(db, "1.65 mm", 0.06496, 1.6500, "metric");
        addEntry(db, "1.7 mm", 0.06693, 1.7000, "metric");
        addEntry(db, "1.75 mm", 0.06890, 1.7500, "metric");
        addEntry(db, "1.8 mm", 0.07087, 1.8000, "metric");
        addEntry(db, "1.85 mm", 0.07283, 1.8500, "metric");
        addEntry(db, "1.9 mm", 0.07480, 1.9000, "metric");
        addEntry(db, "1.95 mm", 0.07677, 1.9500, "metric");
        addEntry(db, "2 mm", 0.07874, 2.0000, "metric");
        addEntry(db, "2.05 mm", 0.08071, 2.0500, "metric");
        addEntry(db, "2.1 mm", 0.08268, 2.1000, "metric");
        addEntry(db, "2.15 mm", 0.08465, 2.1500, "metric");
        addEntry(db, "2.2 mm", 0.08661, 2.2000, "metric");
        addEntry(db, "2.25 mm", 0.08858, 2.2500, "metric");
        addEntry(db, "2.3 mm", 0.09055, 2.3000, "metric");
        addEntry(db, "2.35 mm", 0.09252, 2.3500, "metric");
        addEntry(db, "2.4 mm", 0.09449, 2.4000, "metric");
        addEntry(db, "2.45 mm", 0.09646, 2.4500, "metric");
        addEntry(db, "2.6 mm", 0.10236, 2.6000, "metric");
        addEntry(db, "2.7 mm", 0.10630, 2.7000, "metric");
        addEntry(db, "2.8 mm", 0.11024, 2.8000, "metric");
        addEntry(db, "2.9 mm", 0.11417, 2.9000, "metric");
        addEntry(db, "3 mm", 0.11811, 3.0000, "metric");
        addEntry(db, "3.1 mm", 0.12205, 3.1000, "metric");
        addEntry(db, "3.2 mm", 0.12598, 3.2000, "metric");
        addEntry(db, "3.3 mm", 0.12992, 3.3000, "metric");
        addEntry(db, "3.4 mm", 0.13386, 3.4000, "metric");
        addEntry(db, "3.5 mm", 0.13780, 3.5000, "metric");
        addEntry(db, "3.6 mm", 0.14173, 3.6000, "metric");
        addEntry(db, "3.7 mm", 0.14567, 3.7000, "metric");
        addEntry(db, "3.8 mm", 0.14961, 3.8000, "metric");
        addEntry(db, "3.9 mm", 0.15354, 3.9000, "metric");
        addEntry(db, "4 mm", 0.15748, 4.0000, "metric");
        addEntry(db, "4.1 mm", 0.16142, 4.1000, "metric");
        addEntry(db, "4.2 mm", 0.16535, 4.2000, "metric");
        addEntry(db, "4.3 mm", 0.1693, 4.3000, "metric");
        addEntry(db, "4.4 mm", 0.17323, 4.4000, "metric");
        addEntry(db, "4.5 mm", 0.17717, 4.5000, "metric");
        addEntry(db, "4.6 mm", 0.18110, 4.6000, "metric");
        addEntry(db, "4.7 mm", 0.18504, 4.7000, "metric");
        addEntry(db, "4.8 mm", 0.18898, 4.8000, "metric");
        addEntry(db, "4.9 mm", 0.19291, 4.9000, "metric");
        addEntry(db, "5 mm", 0.19685, 5.0000, "metric");
        addEntry(db, "5.1 mm", 0.20079, 5.1000, "metric");
        addEntry(db, "5.2 mm", 0.20472, 5.2000, "metric");
        addEntry(db, "5.3 mm", 0.20866, 5.3000, "metric");
        addEntry(db, "5.4 mm", 0.21260, 5.4000, "metric");
        addEntry(db, "5.5 mm", 0.21654, 5.5000, "metric");
        addEntry(db, "5.6 mm", 0.22047, 5.6000, "metric");
        addEntry(db, "5.7 mm", 0.22441, 5.7000, "metric");
        addEntry(db, "5.8 mm", 0.22835, 5.8000, "metric");
        addEntry(db, "5.9 mm", 0.23228, 5.9000, "metric");
        addEntry(db, "6 mm", 0.23622, 6.0000, "metric");
        addEntry(db, "6.1 mm", 0.24016, 6.1000, "metric");
        addEntry(db, "6.2 mm", 0.24409, 6.2000, "metric");
        addEntry(db, "6.3 mm", 0.24803, 6.3000, "metric");
        addEntry(db, "6.4 mm", 0.25197, 6.4000, "metric");
        addEntry(db, "6.5 mm", 0.25591, 6.5000, "metric");
        addEntry(db, "6.6 mm", 0.25984, 6.6000, "metric");
        addEntry(db, "6.7 mm", 0.26378, 6.7000, "metric");
        addEntry(db, "6.8 mm", 0.26772, 6.8000, "metric");
        addEntry(db, "6.9 mm", 0.27165, 6.9000, "metric");
        addEntry(db, "7 mm", 0.27559, 7.0000, "metric");
        addEntry(db, "7.1 mm", 0.27953, 7.1000, "metric");
        addEntry(db, "7.2 mm", 0.28346, 7.2000, "metric");
        addEntry(db, "7.3 mm", 0.28740, 7.3000, "metric");
        addEntry(db, "7.4 mm", 0.29134, 7.4000, "metric");
        addEntry(db, "7.5 mm", 0.29528, 7.5000, "metric");
        addEntry(db, "7.6 mm", 0.29921, 7.6000, "metric");
        addEntry(db, "7.7 mm", 0.30315, 7.7000, "metric");
        addEntry(db, "7.8 mm", 0.30709, 7.8000, "metric");
        addEntry(db, "7.9 mm", 0.31102, 7.9000, "metric");
        addEntry(db, "8 mm", 0.31496, 8.0000, "metric");
        addEntry(db, "8.1 mm", 0.31890, 8.1000, "metric");
        addEntry(db, "8.2 mm", 0.32283, 8.2000, "metric");
        addEntry(db, "8.3 mm", 0.32677, 8.3000, "metric");
        addEntry(db, "8.4 mm", 0.33071, 8.4000, "metric");
        addEntry(db, "8.5 mm", 0.33465, 8.5000, "metric");
        addEntry(db, "8.6 mm", 0.33858, 8.6000, "metric");
        addEntry(db, "8.7 mm", 0.34252, 8.7000, "metric");
        addEntry(db, "8.8 mm", 0.34646, 8.8000, "metric");
        addEntry(db, "8.9 mm", 0.35039, 8.9000, "metric");
        addEntry(db, "9 mm", 0.35433, 9.0000, "metric");
        addEntry(db, "9.1 mm", 0.35827, 9.1000, "metric");
        addEntry(db, "9.2 mm", 0.36220, 9.2000, "metric");
        addEntry(db, "9.3 mm", 0.36614, 9.3000, "metric");
        addEntry(db, "9.4 mm", 0.37008, 9.4000, "metric");
        addEntry(db, "9.5 mm", 0.37402, 9.5000, "metric");
        addEntry(db, "9.6 mm", 0.37795, 9.6000, "metric");
        addEntry(db, "9.7 mm", 0.38189, 9.7000, "metric");
        addEntry(db, "9.8 mm", 0.38583, 9.8000, "metric");
        addEntry(db, "9.9 mm", 0.38976, 9.9000, "metric");
        addEntry(db, "10 mm", 0.39370, 10.0000, "metric");
        addEntry(db, "10.5 mm", 0.41339, 10.5000, "metric");
        addEntry(db, "11 mm", 0.43307, 11.0000, "metric");
        addEntry(db, "11.5 mm", 0.45276, 11.5000, "metric");
        addEntry(db, "12 mm", 0.47244, 12.0000, "metric");
        addEntry(db, "12.2 mm", 0.48031, 12.2000, "metric");
        addEntry(db, "12.5 mm", 0.49213, 12.5000, "metric");
        addEntry(db, "12.8 mm", 0.50393, 12.8000, "metric");
        addEntry(db, "13 mm", 0.51181, 13.0000, "metric");
        addEntry(db, "13.5 mm", 0.53150, 13.5000, "metric");
        addEntry(db, "14 mm", 0.55118, 14.0000, "metric");
        addEntry(db, "14.5 mm", 0.57087, 14.5000, "metric");
        addEntry(db, "15 mm", 0.59055, 15.0000, "metric");
        addEntry(db, "15.5 mm", 0.61024, 15.5000, "metric");
        addEntry(db, "16 mm", 0.62992, 16.0000, "metric");
        addEntry(db, "16.5 mm", 0.64961, 16.5000, "metric");
        addEntry(db, "17 mm", 0.66929, 17.0000, "metric");
        addEntry(db, "17.5 mm", 0.68898, 17.5000, "metric");
        addEntry(db, "18 mm", 0.70866, 18.0000, "metric");
        addEntry(db, "18.5 mm", 0.72835, 18.5000, "metric");
        addEntry(db, "19 mm", 0.74803, 19.0000, "metric");
        addEntry(db, "19.5 mm", 0.76772, 19.5000, "metric");
        addEntry(db, "20 mm", 0.78740, 20.0000, "metric");
        addEntry(db, "20.5 mm", 0.80709, 20.5000, "metric");
        addEntry(db, "21 mm", 0.82677, 21.0000, "metric");
        addEntry(db, "21.5 mm", 0.84646, 21.5000, "metric");
        addEntry(db, "22 mm", 0.86614, 22.0000, "metric");
        addEntry(db, "22.5 mm", 0.88583, 22.5000, "metric");
        addEntry(db, "23 mm", 0.90551, 23.0000, "metric");
        addEntry(db, "23.5 mm", 0.92520, 23.5000, "metric");
        addEntry(db, "24 mm", 0.94488, 24.0000, "metric");
        addEntry(db, "24.5 mm", 0.96457, 24.5000, "metric");
        addEntry(db, "25 mm", 0.98425, 25.0000, "metric");
        addEntry(db, "25.5 mm", 1.00394, 25.5000, "metric");
        addEntry(db, "26 mm", 1.02362, 26.0000, "metric");
        addEntry(db, "26.5 mm", 1.04331, 26.5000, "metric");
        addEntry(db, "27 mm", 1.06299, 27.0000, "metric");
        addEntry(db, "27.5 mm", 1.08268, 27.5000, "metric");
        addEntry(db, "28 mm", 1.10236, 28.0000, "metric");
        addEntry(db, "28.5 mm", 1.12205, 28.5000, "metric");
        addEntry(db, "29 mm", 1.14173, 29.0000, "metric");
        addEntry(db, "29.5 mm", 1.16142, 29.5000, "metric");
        addEntry(db, "30 mm", 1.18110, 30.0000, "metric");
        addEntry(db, "30.5 mm", 1.20079, 30.5000, "metric");
        addEntry(db, "31 mm", 1.22047, 31.0000, "metric");
        addEntry(db, "31.5 mm", 1.24016, 31.5000, "metric");
        addEntry(db, "32 mm", 1.25984, 32.0000, "metric");
        addEntry(db, "32.5 mm", 1.27953, 32.5000, "metric");
        addEntry(db, "33 mm", 1.29921, 33.0000, "metric");
        addEntry(db, "33.5 mm", 1.31890, 33.5000, "metric");
        addEntry(db, "34 mm", 1.33858, 34.0000, "metric");
        addEntry(db, "34.5 mm", 1.35827, 34.5000, "metric");
        addEntry(db, "35 mm", 1.37795, 35.0000, "metric");
        addEntry(db, "35.5 mm", 1.39764, 35.5000, "metric");
        addEntry(db, "36 mm", 1.41732, 36.0000, "metric");
        addEntry(db, "36.5 mm", 1.43701, 36.5000, "metric");


    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DrillSizeDBContract.TableColumns.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public void addEntry(SQLiteDatabase db, String name, double imperial, double metric, String type){
        db.execSQL("INSERT INTO " + DrillSizeDBContract.TableColumns.TABLE_NAME + "(" + DrillSizeDBContract.TableColumns.NAME + ", " +
                DrillSizeDBContract.TableColumns.IMPERIAL_SIZE + ", " + DrillSizeDBContract.TableColumns.METRIC_SIZE + ", " + DrillSizeDBContract.TableColumns.DRILL_TYPE +
                ") VALUES('" + name + "', '" + imperial + "', '" + metric + "', '" + type + "');");
    }
}