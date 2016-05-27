package com.priyankasingh.moodbooster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Main activity which shows 5 ways to boost your mood.
 */
public class MainActivity extends AppCompatActivity {

    protected ListView listView;
    protected ArrayList<Thought> thoughtList;
    private int REQUEST_DETAIL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thoughtList = getData();
        listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(new ListViewAdapter(this,R.layout.recycle_row,thoughtList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openDetails(thoughtList.get(position));
            }
        });
    }

    /**
     * Creates an Intent to open detailActivity with thought as parameter
     * @param thought
     */
    private void openDetails(Thought thought) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(DetailActivity.KEY_THOUGHT, thought);
        startActivityForResult(intent, REQUEST_DETAIL);
    }


    /**
     * Populates the static data in-memory to show in list view
     * @return
     */
    private ArrayList<Thought> getData() {
        ArrayList<Thought> thoughtList = new ArrayList<>();
        for(int i=1;i<=5;i++){
            Thought thought = new Thought(i);
            thoughtList.add(thought);
        }
        return thoughtList;
    }

}
