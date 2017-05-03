package com.ach.haroun.fujitsu.expandablelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListViewAdapter expandableListViewAdapter;
    ExpandableListView expandableListView;
    List<String> mListHeaders;
    HashMap<String, List<ListItem>> mListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view_id);
        mListHeaders = new ArrayList<>();
        mListItems = new HashMap<>();
        mListHeaders.add("Europe");
        mListHeaders.add("North America");
        //Europe items
        List<ListItem> europeItems = new ArrayList<>();
        europeItems.add(new ListItem("Germany"));
        europeItems.add(new ListItem("England"));
        europeItems.add(new ListItem("Italy"));
        europeItems.add(new ListItem("Spain"));
        //North America items
        List<ListItem> northAmericaItems = new ArrayList<>();
        northAmericaItems.add(new ListItem("Canada"));
        northAmericaItems.add(new ListItem("United States"));
        northAmericaItems.add(new ListItem("Mexico"));
        mListItems.put(mListHeaders.get(0), europeItems);
        mListItems.put(mListHeaders.get(1), northAmericaItems);
        expandableListViewAdapter = new ExpandableListViewAdapter(this, mListHeaders, mListItems);
        expandableListView.setAdapter(expandableListViewAdapter);
    }
}
