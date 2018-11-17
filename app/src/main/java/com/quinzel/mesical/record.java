package com.quinzel.mesical;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Timestamp;


public class record extends AppCompatActivity {
    private final int REQUEST_VIDEO_CAPTURE = 3;
    private final int REQUEST_TAKE_GALLERY_VIDEO = 1;

    Uri vidLoc = null;
    VideoView videoViewLoad;

    private Button bCamera = null;
    private Button bMyFiles = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        bCamera = (Button) findViewById(R.id.buttonRecordCamera);
        bMyFiles = (Button) findViewById(R.id.buttonRecordFiles);





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
            /*
            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {

                if (resultCode == RESULT_OK)
                {
                    try
                    {
                        AssetFileDescriptor videoAsset = getContentResolver().openAssetFileDescriptor(data.getData(), "r");
                        FileInputStream fis = videoAsset.createInputStream();
                        File root=new File(Environment.getExternalStorageDirectory(),"/Mesical/Notes/");  //you can replace RecordVideo by the specific folder where you want to save the video
                        if (!root.exists()) {
                            System.out.println("No directory");
                            root.mkdirs();
                        }

                        File file;
                        file=new File(root,"android_"+System.currentTimeMillis()+".mp4" );

                        FileOutputStream fos = new FileOutputStream(file);

                        byte[] buf = new byte[1024];
                        int len;
                        while ((len = fis.read(buf)) > 0) {
                            fos.write(buf, 0, len);
                        }
                        fis.close();
                        fos.close();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            */


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
