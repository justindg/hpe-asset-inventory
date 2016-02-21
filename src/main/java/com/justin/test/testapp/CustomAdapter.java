package com.justin.test.testapp;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by deguzmju on 2/19/2016.
 */
public class CustomAdapter extends BaseAdapter implements DialogInterface.OnClickListener {

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
