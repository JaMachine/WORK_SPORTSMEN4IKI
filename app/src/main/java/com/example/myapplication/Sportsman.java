package com.example.myapplication;

import android.app.Activity;
import android.content.res.TypedArray;

public class Sportsman {

    public TypedArray get(Activity a, int i) {
        TypedArray sportsman = null;
        if (i == 1) sportsman = a.getResources().obtainTypedArray(R.array.s1);
        if (i == 2) sportsman = a.getResources().obtainTypedArray(R.array.s2);
        if (i == 3) sportsman = a.getResources().obtainTypedArray(R.array.s3);
        if (i == 4) sportsman = a.getResources().obtainTypedArray(R.array.s4);
        if (i == 5) sportsman = a.getResources().obtainTypedArray(R.array.s5);
        if (i == 6) sportsman = a.getResources().obtainTypedArray(R.array.s6);
        if (i == 7) sportsman = a.getResources().obtainTypedArray(R.array.s7);
        if (i == 8) sportsman = a.getResources().obtainTypedArray(R.array.s8);
        if (i == 9) sportsman = a.getResources().obtainTypedArray(R.array.s9);
        if (i == 10) sportsman = a.getResources().obtainTypedArray(R.array.s10);
        if (i == 11) sportsman = a.getResources().obtainTypedArray(R.array.s11);
        if (i == 12) sportsman = a.getResources().obtainTypedArray(R.array.s12);
        if (i == 13) sportsman = a.getResources().obtainTypedArray(R.array.s13);
        if (i == 14) sportsman = a.getResources().obtainTypedArray(R.array.s14);
        if (i == 15) sportsman = a.getResources().obtainTypedArray(R.array.s15);
        return sportsman;
    }
}
