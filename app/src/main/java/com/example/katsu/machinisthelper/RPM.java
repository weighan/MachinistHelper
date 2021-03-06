package com.example.katsu.machinisthelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class RPM extends AppCompatActivity implements View.OnKeyListener, View.OnClickListener {

    double rightNum, leftNum, midNum;

    EditText InLeft, InRight, InMid;
    TextView ans, RightText, LeftText, ansTitle, MidText;
    Switch ImperialMetric;
    RadioButton RPMRadio, IPMRadio, SFMRadio, IPRRadio;
    RadioGroup rpmRadioGroup;
    ConstraintLayout LayoutBack;

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
        setContentView(R.layout.activity_rpm);

        InLeft = (EditText) findViewById(R.id.InLeft);
        InRight = (EditText) findViewById(R.id.InRight);
        InMid = (EditText) findViewById(R.id.inMid);
        ans = (TextView) findViewById(R.id.answer_result);
        ansTitle = (TextView) findViewById(R.id.answer_title);
        ImperialMetric = (Switch) findViewById(R.id.ImperialMetric);
        RightText = (TextView) findViewById(R.id.RightText);
        LeftText = (TextView) findViewById(R.id.LeftText);
        MidText = (TextView) findViewById(R.id.MidText);
        RPMRadio = (RadioButton) findViewById(R.id.rpmRadio);
        IPMRadio = (RadioButton) findViewById(R.id.ipmRadio);
        SFMRadio = (RadioButton) findViewById(R.id.sfmRadio);
        IPRRadio = (RadioButton) findViewById(R.id.iprRadio);
        rpmRadioGroup = (RadioGroup) findViewById(R.id.rpmRadioGroup);
        LayoutBack = (ConstraintLayout) findViewById(R.id.LayoutBack);

        //check preferences to see if metric or imperial units should be used
        final SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.katsu.machinisthelper", Context.MODE_PRIVATE);
        boolean metricMode = sharedPreferences.getBoolean("ImperialMetric", false);
        ImperialMetric.setChecked(metricMode);

        //ad init
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        rpmRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setHeaderTexts(ImperialMetric.isChecked(), checkedId);
            }
        });


        ImperialMetric.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("ImperialMetric", isChecked).apply();
                setHeaderTexts(isChecked, rpmRadioGroup.getCheckedRadioButtonId());
            }
        });

        InRight.setOnKeyListener(this);
        LayoutBack.setOnClickListener(this);
        LeftText.setOnClickListener(this);
        RightText.setOnClickListener(this);
        MidText.setOnClickListener(this);
    }

    public void calculate(View view) {
        if (isNumeric(InLeft.getText().toString())) {
            leftNum = Integer.parseInt(InLeft.getText().toString());
        }
        else{
            Toast.makeText(RPM.this, "Input a Value In All Fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (isNumeric(InRight.getText().toString())) {
            rightNum = Integer.parseInt(InRight.getText().toString());
        }
        else{
            Toast.makeText(RPM.this, "Input a Value In All Fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (MidText.getVisibility() == View.INVISIBLE) {}
        else{
            if(isNumeric(InMid.getText().toString())){
                midNum = Integer.parseInt(InMid.getText().toString());
            }
            else {
                Toast.makeText(RPM.this, "Input a Value In All Fields", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        double result;

        if(rpmRadioGroup.getCheckedRadioButtonId() == RPMRadio.getId()){
            if (ImperialMetric.isChecked()) {
                result = (rightNum * (1000.0 / Math.PI) / leftNum);
            } else {
                result = (rightNum * (12.0 / Math.PI) / leftNum);
            }
        }
        else if(rpmRadioGroup.getCheckedRadioButtonId() == IPMRadio.getId()){
            result = rightNum * leftNum * midNum;
        }
        else if(rpmRadioGroup.getCheckedRadioButtonId() == IPRRadio.getId()){
            result = rightNum/leftNum;
        }
        else{// SFM is selected
            if(ImperialMetric.isChecked()) {
                result = (leftNum * rightNum * Math.PI / 1000.0);
            }
            else{
                result = (leftNum * rightNum * Math.PI / 12.0);
            }
        }
        /* debug lines
        Log.i("ANSWER!!!!", "InLeft is " + InLeft.getText());
        Log.i("ANSWER!!!!", "InRight is " + InRight.getText());
        Log.i("ANSWER!!!!", Double.toString(result));
        */

        ans.setText(String.format("%.2f", result));
    }

    public static boolean isNumeric(String string) {
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void setHeaderTexts(boolean metricChecked, int checkedId) {
        if(checkedId == RPMRadio.getId()){
            if(metricChecked){
                RightText.setText("M/Min");
                LeftText.setText("Diameter (mm)");
                setRadioText(true);
            }
            else{
                RightText.setText("SFM");
                LeftText.setText("Diameter (in)");
                setRadioText(false);
            }
            ansTitle.setText("RPM");
            setMidInvisible();
        }
        else if(checkedId == IPMRadio.getId()){
            if(metricChecked){
                RightText.setText("mmPR");
                ansTitle.setText("mm/Min");
                setRadioText(true);
            }
            else{
                RightText.setText("IPR");
                ansTitle.setText("IPM");
                setRadioText(false);
            }
            LeftText.setText("RPM");
            setMidVisibile();
        }
        else if(checkedId == SFMRadio.getId()){
            if(metricChecked){
                RightText.setText("Diameter (mm)");
                ansTitle.setText("M/Min");
                setRadioText(true);
            }
            else{
                RightText.setText("Diameter (in)");
                ansTitle.setText("SFM");
                setRadioText(false);
            }
            LeftText.setText("RPM");
            setMidInvisible();
        }
        else if(checkedId == IPRRadio.getId()){
            if(metricChecked){
                RightText.setText("mm/Min");
                ansTitle.setText("mm/Rev");
                setRadioText(true);
            }
            else{
                RightText.setText("IPM");
                ansTitle.setText("IPR");
                setRadioText(false);
            }
            LeftText.setText("RPM");
            setMidInvisible();
        }
        ans.setText("");
    }

    public void setRadioText(boolean metric){
        if(metric){
            SFMRadio.setText("M/Min");
            IPMRadio.setText("mm/Min");
            IPRRadio.setText("mm/Rev");
        }
        else{
            SFMRadio.setText("SFM");
            IPMRadio.setText("IPM");
            IPRRadio.setText("IPR");
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
            calculate(v);
        }
        return false;
    }

    @Override
    public void onClick(View v) { //hides keyboard when you tap on the background, and maybe the input titles
        if(v.getId() == R.id.LayoutBack || v.getId() == R.id.LeftText || v.getId() == R.id.RightText || v.getId() == R.id.MidText) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void setMidVisibile(){
        InMid.setVisibility(View.VISIBLE);
        MidText.setVisibility(View.VISIBLE);
    }

    public void setMidInvisible(){
        InMid.setVisibility(View.INVISIBLE);
        MidText.setVisibility(View.INVISIBLE);
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
}


