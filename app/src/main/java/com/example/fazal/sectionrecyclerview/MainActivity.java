package com.example.fazal.sectionrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Main Activity Class to view the section list.
 *
 * @version 1.0
 * @author Fazal Hussain
 */
public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private MyAdapter mAdapter;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);


        final List<Item> list = new ArrayList<>();

        //Static data to load data
        list.add(new ItemModel("Pizza Max", "500 Minimum delivery"));
        list.add(new ItemModel("Pizza Max", "500 Minimum delivery"));
        list.add(new HeaderModel("2 Closed"));
        list.add(new ItemModel("Pizza Max", "No delivery"));
        list.add(new ItemModel("Pizza Max", "No delivery"));

        // specify an adapter
        mAdapter = new MyAdapter(MainActivity.this, R.layout.activity_main, list);
        lv.setAdapter(mAdapter);

        //List View Click Listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = list.get(position);
                if (!item.isSection()){
                    Log.d(TAG, "pos" + position);
                }
            }
        });
    }
}
