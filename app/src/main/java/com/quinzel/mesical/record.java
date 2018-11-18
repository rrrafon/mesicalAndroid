package com.quinzel.mesical;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class record extends AppCompatActivity {
    private final int REQUEST_VIDEO_CAPTURE = 3;
    private final int REQUEST_TAKE_GALLERY_VIDEO = 1;

    private Uri vidLoc;
    private Button bCamera = null;
    private Button bMyFiles = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri videoUri = data.getData();
        String path = videoUri.getPath(); //may cause null pointer exception

        //Toast.makeText(record.this, "Video saved to: " + path , Toast.LENGTH_LONG).show();
    }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        bCamera = findViewById(R.id.buttonRecordCamera);
        bMyFiles = findViewById(R.id.buttonRecordFiles);


        bCamera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //This starts video capture
                Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                //vidLoc = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
                //takeVideoIntent.putExtra(MediaStore.EXTRA_OUTPUT, vidLoc);
                takeVideoIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

                if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
                    //Uri vidLoc = takeVideoIntent.getData();
                }


            }


        });



        bMyFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("video/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_TAKE_GALLERY_VIDEO);

            }
        });

    }
}