package com.priyankasingh.moodbooster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter class for listview.
 */

public class ListViewAdapter extends ArrayAdapter<Thought>{

    private final ArrayList<Thought> thoughtes;
    private final Context context;

    public ListViewAdapter(Context context, int resource, List<Thought> objects) {
        super(context, resource, objects);
        this.thoughtes = (ArrayList<Thought>) objects;
        this.context = context;

    }

    @Override
    public int getCount() {
        return thoughtes.size();
    }

    @Override
    public Thought getItem(int position) {
        Thought thought = thoughtes.get(position);
        return thought;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_row,null);
        TextView title = (TextView) view.findViewById(R.id.title_text);
        title.setText(context.getResources().getString(thoughtes.get(position).getTitle()));
        return view;
    }
}
