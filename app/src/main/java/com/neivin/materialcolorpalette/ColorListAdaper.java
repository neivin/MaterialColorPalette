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
public class ColorListAdaper extends ArrayAdapter<ColorValue> {

    public ColorListAdaper(Context context, ArrayList<ColorValue> colorList) {
        super(context, 0, colorList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout,parent,false);
        }

        ColorValue color = getItem(position);

        TextView colorGradeView = (TextView) listItemView.findViewById(R.id.color_grade);
        colorGradeView.setText(color.getColorGrade());

        TextView colorHexCodeView = (TextView) listItemView.findViewById(R.id.color_hex_code);
        colorHexCodeView.setText(color.getHexCode());

        listItemView.setBackgroundColor(Color.parseColor(color.getHexCode()));
        return listItemView;
    }
}
