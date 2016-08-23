package com.neivin.materialcolorpalette;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neivin on 2016-08-22.
 */
public class ColorListAdapter extends ArrayAdapter<ColorValue> {

    public ColorListAdapter(Context context, ArrayList<ColorValue> colorList) {
        super(context, 0, colorList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout,parent,false);
        }

        ColorValue color = getItem(position);

        String hexCode = color.getHexCode();

        TextView colorGradeView = (TextView) listItemView.findViewById(R.id.color_grade);
        colorGradeView.setText(color.getColorGrade());

        TextView colorHexCodeView = (TextView) listItemView.findViewById(R.id.color_hex_code);
        colorHexCodeView.setText(hexCode);

        // Set the background color
        listItemView.setBackgroundColor(Color.parseColor(color.getHexCode()));


        /* How to tell if the color is light or dark from its hex value.
         * Credit to Dunes on StackOverflow
         */

        // remove hash character from string
        String rawFontColor = hexCode.substring(1,hexCode.length());

        // convert hex string to int
        int rgb = Integer.parseInt(rawFontColor, 16);

        float [] hsv = new float[3];

        Color.RGBToHSV(Color.red(rgb), Color.green(rgb), Color.blue(rgb), hsv);

        float brightness = hsv[2];

        if (brightness <= 0.8) {
            // use white text
            colorGradeView.setTextColor(Color.WHITE);
            colorHexCodeView.setTextColor(Color.WHITE);
        } else {
            // use dark text
            colorGradeView.setTextColor(Color.BLACK);
            colorHexCodeView.setTextColor(Color.BLACK);
        }


        return listItemView;
    }
}
