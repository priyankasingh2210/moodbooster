package com.priyankasingh.moodbooster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Thoughts>{

    private final ArrayList<Thoughts> thoughtes;
    private final Context context;

    public ListViewAdapter(Context context, int resource, List<Thoughts> objects) {
        super(context, resource, objects);
        this.thoughtes = (ArrayList<Thoughts>) objects;
        this.context = context;

    }

    @Override
    public int getCount() {
        return thoughtes.size();
    }

    @Override
    public Thoughts getItem(int position) {
        Thoughts thoughts = thoughtes.get(position);
        return thoughts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_row,null);
        TextView title = (TextView) view.findViewById(R.id.title_text);
        title.setText(context.getResources().getString(thoughtes.get(position).getTitle()));
        return view;
    }
}
