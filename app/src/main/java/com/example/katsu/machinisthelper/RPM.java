package com.example.katsu.machinisthelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RPM extends AppCompatActivity {

    int sfm, diameter;

    EditText InLeft = (EditText) findViewById(R.id.InLeft);
    EditText InRight = (EditText) findViewById(R.id.InRight);
    TextView ans = (TextView) findViewById(R.id.answer_result);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpm);




    }


    public void calculate(View view){

        if(isNumeric(InLeft.getText().toString())){
            sfm = Integer.parseInt(InLeft.getText().toString());
        }
        if(isNumeric(InRight.getText().toString())) {
            diameter = Integer.parseInt(InRight.getText().toString());
        }

        double result = sfm * (12.0/Math.PI) / diameter;
        ans.setText(Double.toString(result));

    }

    public static boolean isNumeric(String string){
        try{
            double d = Double.parseDouble(string);
        }
        catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }
}


