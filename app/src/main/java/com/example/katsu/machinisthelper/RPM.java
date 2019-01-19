package com.example.katsu.machinisthelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RPM extends AppCompatActivity {

    double sfm, diameter;

    EditText InLeft, InRight;
    TextView ans, RightText, LeftText, ansTitle;
    Switch ImperialMetric;
    RadioButton RPMRadio, IPMRadio, SFMRadio;
    RadioGroup rpmRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpm);

        InLeft = (EditText) findViewById(R.id.InLeft);
        InRight = (EditText) findViewById(R.id.InRight);
        ans = (TextView) findViewById(R.id.answer_result);
        ansTitle = (TextView) findViewById(R.id.answer_title);
        ImperialMetric = (Switch) findViewById(R.id.ImperialMetric);
        RightText = (TextView) findViewById(R.id.RightText);
        LeftText = (TextView) findViewById(R.id.LeftText);
        RPMRadio = (RadioButton) findViewById(R.id.rpmRadio);
        IPMRadio = (RadioButton) findViewById(R.id.ipmRadio);
        SFMRadio = (RadioButton) findViewById(R.id.sfmRadio);
        rpmRadioGroup = (RadioGroup) findViewById(R.id.rpmRadioGroup);

        rpmRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setHeaderTexts(ImperialMetric.isChecked(), checkedId);
            }
        });


        ImperialMetric.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setHeaderTexts(isChecked, rpmRadioGroup.getCheckedRadioButtonId());
            }
        });
    }

    public void calculate(View view) {
        if (isNumeric(InLeft.getText().toString())) {
            diameter = Integer.parseInt(InLeft.getText().toString());
        }
        else{
            return;
        }
        if (isNumeric(InRight.getText().toString())) {
            sfm = Integer.parseInt(InRight.getText().toString());
        }
        else{
            return;
        }

        double result;

        if(rpmRadioGroup.getCheckedRadioButtonId() == RPMRadio.getId()){
            if (ImperialMetric.isChecked()) {
                result = (sfm * (1000.0 / Math.PI) / diameter);
            } else {
                result = (sfm * (12.0 / Math.PI) / diameter);
            }
        }
        else if(rpmRadioGroup.getCheckedRadioButtonId() == IPMRadio.getId()){
            result = sfm*diameter;
        }
        else{
            if(ImperialMetric.isChecked()) {
                result = (diameter * sfm * Math.PI / 1000.0);
            }
            else{
                result = (diameter * sfm * Math.PI / 12.0);
            }
        }

        Log.i("ANSWER!!!!", "InLeft is " + InLeft.getText());
        Log.i("ANSWER!!!!", "InRight is " + InRight.getText());
        Log.i("ANSWER!!!!", Double.toString(result));

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
        }
    }

    public void setRadioText(boolean metric){
        if(metric){
            SFMRadio.setText("M/Min");
            IPMRadio.setText("mm/Min");
        }
        else{
            SFMRadio.setText("SFM");
            IPMRadio.setText("IPM");
        }
    }
}


