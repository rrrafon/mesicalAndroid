package com.quinzel.mesical;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class record extends AppCompatActivity {
    private final int REQUEST_VIDEO_CAPTURE = 1;
    Uri vidLoc = null;

    private Button bCamera = null;
    private Button bMyFiles = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        bCamera = findViewById(R.id.buttonRecordCamera);
        bMyFiles = findViewById(R.id.buttonRecordFiles);

        bCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);

                    Uri vidLoc = takeVideoIntent.getData();
                }
            }
        });
        /*
        bMyFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.setVideoURI(videoUri);
            }
        });
        */



    }
}
