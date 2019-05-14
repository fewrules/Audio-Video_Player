package com.Riko.mpvbutbad;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AimpButbad extends AppCompatActivity {

    private String[] audiosheet = { "Audio 1", "Audio 2", "Audio 3" };

    String[] Uris;
    private ListView lv;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aimp_butbad);

        fillArray();
        lv = findViewById(R.id.ls2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, audiosheet);

        mp = new MediaPlayer();

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                    }

                    mp = new MediaPlayer();
                    mp.setDataSource(getApplicationContext(), Uri.parse(Uris[position]));
                    mp.prepare();
                    mp.start();
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }

    public void myButton(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void STOPTIGHTTHERE(View v){
        if(mp.isPlaying())
            mp.stop();
    }

    void fillArray() {
        Uris = new String[4];

        Uris[0] = "android.resource://" + getPackageName() + "/" + R.raw.raw_video;
        Uris[1] = "android.resource://" + getPackageName() + "/" + R.raw.raw_video_2;
        Uris[2] = "android.resource://" + getPackageName() + "/" + R.raw.raw_video_3;

    }

}
