package com.app.peris.artup.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import com.app.peris.artup.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Beth on 19/05/2016.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context con;
    private ArrayList<String> headers;
    private ArrayList<Integer> layouts;

    public ExpandableAdapter(Context context,ArrayList<String> listheaders,ArrayList<Integer> layouts)
    {
        this.con=context;
        this.headers=listheaders;
        this.layouts=layouts;
    }

    // get child of header
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.layouts.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    // return the view of child

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        if(convertView==null)
//        {
        LayoutInflater inflater=(LayoutInflater)LayoutInflater.from(con);
        convertView=inflater.inflate(layouts.get(groupPosition),null);
//        }
        return convertView;
    }

    // returns children count of header
    @Override
    public int getChildrenCount(int groupPosition) {
//        return this.headeritems.get(headers.get(groupPosition)).size();
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        Log.d("groupposition", this.headers.get(groupPosition));
        return this.headers.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.headers.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //returns the view of group
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headername=(String)getGroup(groupPosition);
        if(convertView==null)
        {
            LayoutInflater inflater= LayoutInflater.from(con);
            convertView=inflater.inflate(R.layout.chooseteamsexpandableheaderlayout,null);
        }
        TextView header=(TextView)convertView.findViewById(R.id.expandheader);
        header.setText(headername);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
