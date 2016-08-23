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

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        ColorValue color = getItem(position);

        String hexCode = color.getHexCode();

        TextView colorGradeView = (TextView) listItemView.findViewById(R.id.color_grade);
        colorGradeView.setText(color.getColorGrade());

        TextView colorHexCodeView = (TextView) listItemView.findViewById(R.id.color_hex_code);
        colorHexCodeView.setText(hexCode);

        // Set the background color
        listItemView.setBackgroundColor(Color.parseColor(color.getHexCode()));

        // Algorithm source: Blaskovicz on StackOverflow
        // http://stackoverflow.com/questions/7785510/android-java-determining-if-text-color-will-blend-in-with-the-background?rq=1
        // Determine if the text will blend with the background or not

        //remove hash character from string
        String rawFontColor = hexCode.substring(1, hexCode.length());

        // convert hex string to int
        int rgbColor = Integer.parseInt(rawFontColor, 16);

        // Get RGB values of color
        float[] rgb = {Color.red(rgbColor), Color.green(rgbColor), Color.blue(rgbColor)};

        // Get an acceptable contrast ratio that coincides with material guidelines
        int brightness = (int) Math.sqrt(rgb[0] * rgb[0] * .241 + rgb[1]
                * rgb[1] * .691 + rgb[2] * rgb[2] * .068);

        if (brightness < 150) {
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
