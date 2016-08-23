package com.neivin.materialcolorpalette;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neivin on 2016-08-21.
 */
public class ColorGridAdapter extends ArrayAdapter<String> {

    private boolean[] isLight;

    public ColorGridAdapter(Context context, ArrayList<String> colorList, boolean[] isLight) {
        super(context, 0, colorList);
        this.isLight = isLight;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_layout, parent, false);
        }

        String colorName = getItem(position);

        TextView colorNameTextView = (TextView) gridItemView.findViewById(R.id.color_name);
        colorNameTextView.setText(colorName);

        if (colorName.contains("Light") || colorName.equals("Grey") || colorName.equals("Yellow") || colorName.equals("Amber")
                || colorName.equals("Orange") || colorName.equals("Green")
                || colorName.equals("Lime") || colorName.equals("Cyan")) {
            colorNameTextView.setTextColor(Color.BLACK);
        }
        else{
            colorNameTextView.setTextColor(Color.WHITE);
        }


        String resourceName = colorName.toLowerCase().replace(' ', '_') + "_500";
        Log.i("Adapter", "colorName: " + colorName);
        gridItemView.setBackgroundColor(ContextCompat.getColor(getContext(), getContext().getResources().getIdentifier(resourceName, "color", "com.neivin.materialcolorpalette")));


        return gridItemView;
    }
}
