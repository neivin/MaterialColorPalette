package com.neivin.materialcolorpalette;

/**
 * Created by Neivin on 2016-08-22.
 */
public class ColorValue {
    String mColorGrade;
    String mHexCode;

    public ColorValue(String mColorGrade, String mHexCode) {
        this.mColorGrade = mColorGrade;
        this.mHexCode = mHexCode;
    }

    public String getColorGrade() {
        return mColorGrade;
    }

    public String getHexCode() {
        return mHexCode;
    }
}
