package com.priyankasingh.moodbooster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<Thoughts> thoughtList;

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

    private void openDetails(Thoughts thought) {
        Intent intent = new Intent(this,ScrollingActivity.class);
        intent.putExtra(ScrollingActivity.KEY_THOUGHT, thought);
        startActivityForResult(intent,0);
    }

    private ArrayList<Thoughts> getData() {
        ArrayList<Thoughts> thoughtList = new ArrayList<>();
        for(int i=1;i<=5;i++){
            Thoughts thoughts = new Thoughts(i);
            thoughtList.add(thoughts);
        }
        return thoughtList;
    }

}
