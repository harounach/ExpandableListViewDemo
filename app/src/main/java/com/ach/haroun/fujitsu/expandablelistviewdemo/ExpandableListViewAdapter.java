package com.ach.haroun.fujitsu.expandablelistviewdemo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> mListHeaders;
    private HashMap<String, List<ListItem>> mListItems;

    public ExpandableListViewAdapter(Context context, List<String> listHeaders, HashMap<String, List<ListItem>> listItems){
        this.mContext = context;
        this.mListHeaders = listHeaders;
        this.mListItems = listItems;
    }


    @Override
    public int getGroupCount() {
        return mListHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mListItems.get(mListHeaders.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mListHeaders.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListItems.get(mListHeaders.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_group, null);
        TextView textHeader = (TextView) convertView.findViewById(R.id.list_header_id);
        textHeader.setText(mListHeaders.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ListItem listItem = (ListItem) getChild(groupPosition, childPosition);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView textItem = (TextView) convertView.findViewById(R.id.list_item_id);
        textItem.setText(listItem.item);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
