package com.neivin.materialcolorpalette;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    final static String[] mColorList = {"Red", "Pink", "Purple", "Deep Purple", "Indigo",
            "Blue", "Light Blue", "Cyan", "Teal", "Green",
            "Light Green", "Lime", "Yellow", "Amber", "Orange",
            "Deep Orange", "Brown", "Grey", "Blue Grey"};

    final static boolean[] mIsLight = {false, false, false, false, false,
            false, true, true, false, true,
            true, true, true, true, true
            , false, false, true, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> colorList = new ArrayList<>(Arrays.asList(mColorList));

        ColorGridAdapter colorAdapter = new ColorGridAdapter(this, colorList, mIsLight);

        GridView colorGrid = (GridView) findViewById(R.id.color_grid);
        colorGrid.setAdapter(colorAdapter);
        colorGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ColorDetailActivity.class);
                intent.putExtra("COLOR_NAME",mColorList[position]);
                startActivity(intent);
            }
        });

    }

}
