package com.neivin.materialcolorpalette;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorDetailActivity extends AppCompatActivity {

    String mColorName;
    ArrayList<ColorValue> mColorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_detail);

        // Obtain the name of the color
        mColorName = getIntent().getStringExtra("COLOR_NAME");

        // Fill out the values neeeded to list out the color values
        populateColorList();

        // Set title of the Activity to hte chosen color
        if (getActionBar()!= null)
            getActionBar().setTitle(mColorName);
        if(getSupportActionBar() != null)
            getSupportActionBar().setTitle(mColorName);

        ColorListAdaper listAdaper = new ColorListAdaper(this, mColorList);

        ListView colorList = (ListView) findViewById(R.id.color_list);
        colorList.setAdapter(listAdaper);


    }

    private void populateColorList(){
        String resourceName = mColorName.toLowerCase().replace(' ', '_') + "_color_values";

        String[] colorHexValues  = getResources().getStringArray(getResources().getIdentifier(resourceName,"array","com.neivin.materialcolorpalette"));

        ArrayList<String> colorGrades = new ArrayList<>(Arrays.asList("50","100","200","300","400","500","600","700","800","900"));

        if(!mColorName.equals("Brown") && !mColorName.equals("Grey") && !mColorName.equals("Blue Grey")){
            colorGrades.add("A100");
            colorGrades.add("A200");
            colorGrades.add("A400");
            colorGrades.add("A700");
        }

        mColorList = new ArrayList<>();
        // Add to color List to send to adapter
        for(int i = 0; i<colorHexValues.length; i++){
            mColorList.add(new ColorValue(colorGrades.get(i), colorHexValues[i]));
        }
    }
}
