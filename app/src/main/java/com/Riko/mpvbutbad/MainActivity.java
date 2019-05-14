package com.Riko.mpvbutbad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    String[] names = {"Video 1", "Video 2", "Video 3"};
    String[] Uris;
    ListView lv;
    private VideoView vv;
    private MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv = findViewById(R.id.videoView);
        mc = new MediaController(MainActivity.this);

        fillArray();

        lv = findViewById(R.id.memelist);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        mc.setAnchorView(vv);

        vv.setMediaController(mc);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                vv.setVideoURI(Uri.parse(Uris[position]));

                vv.requestFocus();

                vv.start();

            }
        });

        vv.start();

    }

    void fillArray() {
        Uris = new String[4];

        Uris[0] = "android.resource://" + getPackageName() + "/" + R.raw.raw_video;
        Uris[1] = "android.resource://" + getPackageName() + "/" + R.raw.raw_video_2;
        Uris[2] = "android.resource://" + getPackageName() + "/" + R.raw.raw_video_3;

    }

    public void myButt(View v) {
        Intent myIntent = new Intent(this, AimpButbad.class);
        startActivity(myIntent);
    }

}
