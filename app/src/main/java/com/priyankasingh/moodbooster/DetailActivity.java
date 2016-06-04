package com.priyankasingh.moodbooster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Detail page for each of the thought. This page has a share button to share the thought to other
 * apps.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String KEY_THOUGHT = "KEY_THOUGHT";
    public static final String NO_THOUGHTS_SELECTED = "No thoughts selected";
    public static final String SHARE_VIA = "Share via";
    public static final String TEXT_PLAIN = "text/plain";
    Thought thought;
    ImageView imageView ;
    TextView title;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
        Bundle extra = getIntent().getExtras();

        /**
         * If somebody accidently called this activity without providing Thought object page will
         * close safely as nothing to show here.
         */
        if(extra!=null && extra.containsKey(KEY_THOUGHT)){
            thought = extra.getParcelable(KEY_THOUGHT);
        }else{
            Toast.makeText(getApplicationContext(), NO_THOUGHTS_SELECTED,Toast.LENGTH_LONG).show();
            finish();
        }

        imageView = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);
        title = (TextView) findViewById(R.id.title);

        imageView.setImageResource(thought.getImage());
        description.setText(getResources().getString(thought.getDescription()));
        title.setText(getResources().getString(thought.getTitle()));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType(TEXT_PLAIN);
                String shareBody = getResources().getString(thought.getDescription());
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getResources().getString(thought.getTitle()));
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, SHARE_VIA));

            }
        });
    }


}
