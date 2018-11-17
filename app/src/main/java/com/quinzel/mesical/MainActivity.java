package com.quinzel.mesical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    /* this declares all the button in main Page*/
    private Button bRender = null;
    private Button bRecord = null;
    private Button bMyFiles = null;
    private Button bQuit = null;
    private Button bSettings = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRender =  findViewById(R.id.buttonMesical);
        bRecord =  findViewById(R.id.buttonMainRecord);
        bMyFiles =  findViewById(R.id.buttonMainMyVideos);
        bQuit =  findViewById(R.id.buttonMainQuit);
        bSettings =  findViewById(R.id.buttonMainSettings);

        bRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, setUpNotes.class );
                startActivity(i);
            }

        });
    }

}
